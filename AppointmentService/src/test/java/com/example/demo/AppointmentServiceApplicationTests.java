package com.example.demo;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.demo.dto.DoctorAppointmentDto;
import com.example.demo.dto.DoctorDto;
import com.example.demo.dto.PatientAppointmentDto;
import com.example.demo.dto.PatientDoctorAppointmentDto;
import com.example.demo.dto.PatientDto;
import com.example.demo.entity.Appointment;
import com.example.demo.exception.AppointmentNotFoundException;
import com.example.demo.feign.DoctorInterface;
import com.example.demo.feign.PatientInterface;
import com.example.demo.repository.AppointmentRepository;
import com.example.demo.service.AppointmentServiceImpl;

@SpringBootTest
public class AppointmentServiceApplicationTests {

    @Mock
    private AppointmentRepository repository;

    @Mock
    private DoctorInterface doctorInterface;

    @Mock
    private PatientInterface patientInterface;

    @InjectMocks
    private AppointmentServiceImpl service;

    private Appointment appointment;
    private PatientDto patientDto;
    private DoctorDto doctorDto;

    @BeforeEach
    public void setUp() {
        appointment = new Appointment(1, 1, 1, LocalDate.of(2023, 4, 6), LocalTime.of(10, 0), "Pending");
        patientDto = new PatientDto(1, "patient@example.com", "Patient Name", 30, "1234567890", "Male");
        doctorDto = new DoctorDto(1, "doctor@example.com", "Doctor Name", "0987654321", "Cardiology");
    }

    @Test
    public void testFindById() throws AppointmentNotFoundException {
        when(repository.findById(anyInt())).thenReturn(Optional.of(appointment));
        when(patientInterface.findByPatientId(anyInt())).thenReturn(patientDto);
        when(doctorInterface.getDoctorById(anyInt())).thenReturn(doctorDto);

        ResponseEntity<PatientDoctorAppointmentDto> response = service.findById(1);

        assert response.getStatusCode() == HttpStatus.OK;
        assert response.getBody() != null;
        assert response.getBody().getPatient().equals(patientDto);
        assert response.getBody().getDoctor().equals(doctorDto);
    }

    @Test
    public void testSave() {
        when(repository.save(appointment)).thenReturn(appointment);
        when(patientInterface.findByPatientId(anyInt())).thenReturn(patientDto);
        when(doctorInterface.getDoctorById(anyInt())).thenReturn(doctorDto);

        ResponseEntity<Appointment> response = service.save(appointment, 1);

        assert response.getStatusCode() == HttpStatus.CREATED;
        assert response.getBody() != null;
        assert response.getBody().equals(appointment);
    }

    @Test
    public void testDeleteById() {
        ResponseEntity<String> response = service.deleteById(1);

        assert response.getStatusCode() == HttpStatus.OK;
        assert response.getBody().equals("Deleted Successfully");
    }

    @Test
    public void testFindByDoctorId() throws AppointmentNotFoundException {
        when(repository.findByDoctorId(anyInt())).thenReturn(Arrays.asList(appointment));
        when(patientInterface.findByPatientId(anyInt())).thenReturn(patientDto);

        ResponseEntity<List<PatientAppointmentDto>> response = service.findByDoctorId(1);

        assert response.getStatusCode() == HttpStatus.OK;
        assert response.getBody() != null;
        assert response.getBody().size() == 1;
        assert response.getBody().get(0).getPatient().equals(patientDto);
    }

    @Test
    public void testAccept() {
        when(repository.findByAppointmentId(anyInt())).thenReturn(appointment);

        ResponseEntity<String> response = service.accept(1);

        assert response.getStatusCode() == HttpStatus.OK;
        assert response.getBody().equals("Accepted");
    }

    @Test
    public void testDecline() {
        when(repository.findByAppointmentId(anyInt())).thenReturn(appointment);

        ResponseEntity<String> response = service.decline(1);

        assert response.getStatusCode() == HttpStatus.OK;
        assert response.getBody().equals("Declined");
    }

    @Test
    public void testFindByPatientId() {
        when(repository.findByPatientId(anyInt())).thenReturn(Arrays.asList(appointment));
        when(doctorInterface.getDoctorById(anyInt())).thenReturn(doctorDto);

        ResponseEntity<List<DoctorAppointmentDto>> response = service.findByPatientId(1);

        assert response.getStatusCode() == HttpStatus.OK;
        assert response.getBody() != null;
        assert response.getBody().size() == 1;
        assert response.getBody().get(0).getDoctor().equals(doctorDto);
    }

    @Test
    public void testGetAppointmentsForDoctor() {
        when(repository.findByDoctorIdAndDate(anyInt(), any())).thenReturn(Arrays.asList(appointment));
        when(patientInterface.findByPatientId(anyInt())).thenReturn(patientDto);

        ResponseEntity<List<PatientAppointmentDto>> response = service.getAppointmentsForDoctor(1, LocalDate.now());

        assert response.getStatusCode() == HttpStatus.OK;
        assert response.getBody() != null;
        assert response.getBody().size() == 1;
        assert response.getBody().get(0).getPatient().equals(patientDto);
    }

    @Test
    public void testShow() {
        when(repository.findByPatientId(anyInt())).thenReturn(Arrays.asList(appointment));
        when(doctorInterface.getDoctorById(anyInt())).thenReturn(doctorDto);

        ResponseEntity<List<String>> response = service.show(1);

        assert response.getStatusCode() == HttpStatus.OK;
        assert response.getBody() != null;
        assert response.getBody().size() == 1;
        assert response.getBody().get(0).contains("Doctor Name");
    }
}
