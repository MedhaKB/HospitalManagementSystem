package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.demo.entity.Patient;
import com.example.demo.exception.PatientNotFound;
import com.example.demo.repository.PatientRepository;
import com.example.demo.service.PatientServiceImpl;

@SpringBootTest(classes = PatientServiceApplication.class)
class PatientServiceApplicationTest {

	@Mock
	private PatientRepository repository;

	@InjectMocks
	private PatientServiceImpl patientService;

	private Patient patient;

	@BeforeEach
	void setUp() {
		patient = new Patient(1, "john.doe@example.com", "password123", "John Doe", 30, "1234567890", "Male");
	}

	@Test
	void testAddPatient() {
		when(repository.save(patient)).thenReturn(patient);
		ResponseEntity<String> response = patientService.addPatient(patient);
		assertEquals(HttpStatus.CREATED, response.getStatusCode());
		assertEquals("Patient successfully added", response.getBody());
	}

	@Test
	void testUpdatePatientDetails() throws PatientNotFound {
		Patient updatedPatient = new Patient(1, "jane.doe@example.com", "newpassword", "Jane Doe", 28, "0987654321",
				"Female");
		when(repository.findById(1)).thenReturn(Optional.of(patient));

		ResponseEntity<Patient> response = patientService.updatePatientDetails(1, updatedPatient);

		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals(updatedPatient.getEmailID(), response.getBody().getEmailID());
		assertEquals(updatedPatient.getPatientName(), response.getBody().getPatientName());
	}

	@Test
	void testDeletePatient() {
		doNothing().when(repository).deleteById(1);
		ResponseEntity<String> response = patientService.deletePatient(1);
		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals("Deleted Successfully", response.getBody());
	}

	@Test
	void testFindByPatientId() throws PatientNotFound {
		when(repository.findById(1)).thenReturn(Optional.of(patient));
		ResponseEntity<Patient> response = patientService.findByPatientId(1);
		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals(patient, response.getBody());
	}

}