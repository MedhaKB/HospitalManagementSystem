package com.example.demo;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import com.example.demo.client.AppointmentClient;
import com.example.demo.dto.AppointmentDto;
import com.example.demo.entity.Medicine;
import com.example.demo.entity.Prescription;
import com.example.demo.exception.PrescriptionNotFound;
import com.example.demo.repository.MedicineRepository;
import com.example.demo.repository.PrescriptionRepository;
import com.example.demo.service.PrescriptionServiceImpl;

@SpringBootTest
class PrescriptionServiceApplicationTests {

    @Mock
    private PrescriptionRepository presRepo;

    @Mock
    private MedicineRepository medRepo;

    @Mock
    private AppointmentClient client;

    @InjectMocks
    private PrescriptionServiceImpl prescriptionService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testAddMedicine() {
        Medicine medicine = new Medicine();
        medicine.setPid(1);
        medicine.setName("Paracetamol");
        medicine.setTabletCount(10);
        medicine.setMorning(true);
        medicine.setAfternoon(false);
        medicine.setNight(true);

        when(medRepo.save(medicine)).thenReturn(medicine);

        Medicine result = prescriptionService.addMedicine(medicine, 1);
        assertNotNull(result);
        assertEquals(1, result.getPid());
        assertEquals("Paracetamol", result.getName());
        assertEquals(10, result.getTabletCount());
        assertTrue(result.getMorning());
        assertFalse(result.getAfternoon());
        assertTrue(result.getNight());
    }


    @Test
    void testFindMedicineById() {
        List<Medicine> medicines = Arrays.asList(
            new Medicine(1, 1, "Paracetamol", 10, true, false, true),
            new Medicine(2, 1, "Ibuprofen", 20, true, true, false)
        );
        when(medRepo.findByPid(1)).thenReturn(medicines);

        List<Medicine> result = prescriptionService.findMedicneById(1);
        assertNotNull(result);
        assertEquals(2, result.size());
    }

    @Test
    void testAddPrescription() {
        AppointmentDto appointment = new AppointmentDto();
        appointment.setAppointmentId(1);
        appointment.setDoctorId(1);
        appointment.setPatientId(1);
        appointment.setDate(LocalDate.now());
        appointment.setTime(LocalTime.now());
        appointment.setStatus("Scheduled");

        when(client.getById(anyInt())).thenReturn(ResponseEntity.ok(appointment));

        Prescription prescription = new Prescription();
        prescription.setPid(1);
        prescription.setAid(1);
        prescription.setPatientid(1);
        prescription.setDoctorid(1);
        prescription.setDate(LocalDate.now());

        when(medRepo.findByPid(1)).thenReturn(Arrays.asList(new Medicine()));
        when(presRepo.save(any(Prescription.class))).thenReturn(prescription);

        ResponseEntity<Prescription> result = prescriptionService.addPrescription(1, prescription);

        assertNotNull(result);
        assertEquals(1, result.getBody().getPid());
        assertEquals(1, result.getBody().getAid());
        assertEquals(1, result.getBody().getPatientid());
        assertEquals(1, result.getBody().getDoctorid());
        assertNotNull(result.getBody().getDate());
    }

    @Test
    void testDeletePrescription() {
        doNothing().when(presRepo).deleteById(1);

        ResponseEntity<String> result = prescriptionService.deletePrescription(1);
        assertEquals("Deleted Successfully", result.getBody());
    }

    @Test
    void testFindByPatientId() throws PrescriptionNotFound {
        Prescription prescription = new Prescription();
        prescription.setPatientid(1);
        prescription.setAid(1);
        prescription.setDoctorid(1);
        prescription.setDate(LocalDate.now());

        when(presRepo.findById(1)).thenReturn(Optional.of(prescription));

        ResponseEntity<Prescription> result = prescriptionService.findByPatientId(1);
        assertNotNull(result);
        assertEquals(1, result.getBody().getPatientid());
        assertEquals(1, result.getBody().getAid());
        assertEquals(1, result.getBody().getDoctorid());
        assertNotNull(result.getBody().getDate());
    }

    @Test
    void testFindByAid() throws PrescriptionNotFound {
        Prescription prescription = new Prescription();
        prescription.setAid(1);
        prescription.setPatientid(1);
        prescription.setDoctorid(1);
        prescription.setDate(LocalDate.now());

        when(presRepo.findById(1)).thenReturn(Optional.of(prescription));

        ResponseEntity<Prescription> result = prescriptionService.findByAid(1);
        assertNotNull(result);
        assertEquals(1, result.getBody().getAid());
        assertEquals(1, result.getBody().getPatientid());
        assertEquals(1, result.getBody().getDoctorid());
        assertNotNull(result.getBody().getDate());
    }
}
