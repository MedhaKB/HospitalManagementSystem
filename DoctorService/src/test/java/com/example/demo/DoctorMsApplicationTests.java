package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.demo.entity.Doctor;
import com.example.demo.exception.DoctorNotFound;
import com.example.demo.repository.DoctorRepository;
import com.example.demo.service.DoctorServiceImpl;

@SpringBootTest
public class DoctorMsApplicationTests {

	@Mock
	private DoctorRepository repo;

	@InjectMocks
	private DoctorServiceImpl doctorService;

	private Doctor doctor;

	@BeforeEach
	void setUp() {
		doctor = new Doctor(1, "password123", "doctor@example.com", "Dr. Smith", "0987654321", "Cardiology");
	}

	@Test
	void testAddDoctor() {
		when(repo.save(doctor)).thenReturn(doctor);
		ResponseEntity<String> response = doctorService.addDoctor(doctor);
		assertEquals(HttpStatus.CREATED, response.getStatusCode());
		assertEquals("Doctor added successfully", response.getBody());
	}

	@Test
	void testDeleteDoctor() {
		doNothing().when(repo).deleteById(1);
		ResponseEntity<String> response = doctorService.deleteDoctor(1);
		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals("Doctor with id 1 deleted successfully", response.getBody());
	}

	@Test
	void testUpdateDoctor() throws DoctorNotFound {
		Doctor updatedDoctor = new Doctor(1, "newpassword123", "newdoctor@example.com", "Dr. Jane", "1234567890",
				"Dermatology");
		when(repo.findById(1)).thenReturn(Optional.of(doctor));

		ResponseEntity<Doctor> response = doctorService.updateDoctor(1, updatedDoctor);

		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals(updatedDoctor.getEmailId(), response.getBody().getEmailId());
		assertEquals(updatedDoctor.getName(), response.getBody().getName());
	}

//	@Test
//	void testFindBySpecialization() {
//		List<Doctor> doctors = List.of(doctor);
//		when(repo.findBySpecialization("Cardiology")).thenReturn(doctors);
//
//		List<Doctor> response = doctorService.findBySpecialization("Cardiology");
//		assertEquals(HttpStatus.OK, response.getStatusCode());
//		assertEquals(doctors, response.getBody());
//	}

	@Test
	void testFindById() throws DoctorNotFound {
		when(repo.findById(1)).thenReturn(Optional.of(doctor));
		ResponseEntity<Doctor> response = doctorService.findById(1);
		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals(doctor, response.getBody());
	}

	@Test
	void testDoctorNotFound() {
		when(repo.findById(1)).thenReturn(Optional.empty());

		Exception exception = assertThrows(DoctorNotFound.class, () -> {
			doctorService.findById(1);
		});

		String expectedMessage = "Doctor of 1 is not present";
		String actualMessage = exception.getMessage();

		assertTrue(actualMessage.contains(expectedMessage));
	}
}
