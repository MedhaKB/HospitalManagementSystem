package com.example.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Patient;
import com.example.demo.service.PatientServiceImpl;

import lombok.AllArgsConstructor;

// Marks this class as a REST controller
@RestController
// Maps HTTP requests to /patient URL
@RequestMapping("/patient")
// Generates a constructor with one parameter for each field in this class
@AllArgsConstructor
public class PatientController {

	// Logger instance for logging messages
	private static final Logger logger = LoggerFactory.getLogger(PatientController.class);

	// Service layer dependency
	private PatientServiceImpl service;

	// Handles POST requests to /userregister for registering a new patient
	@PostMapping("/userregister")
	public ResponseEntity<String> register(@RequestBody Patient patient) {
		logger.info("Registering new patient");
		return service.addPatient(patient);
	}

//	@GetMapping("/getDemo")
//	public ResponseEntity<String> getDemo() {
//		return service.demo1();
	//}
	// Handles PUT requests to /update/{id} for updating patient details
	@PutMapping("/update/{id}")
	public ResponseEntity<Patient> updatePatientDetails(@PathVariable int id, @RequestBody Patient patient) {
		logger.info("Updating patient details for ID: {}", id);
		return service.updatePatientDetails(id, patient);
	}

	// Handles DELETE requests to /delete/{id} for deleting a patient
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deletePatient(@PathVariable int id) {
		logger.info("Deleting patient with ID: {}", id);
		return service.deletePatient(id);
	}

	// Handles GET requests to /findByPatientId/{id} for fetching patient details
	@GetMapping("/findByPatientId/{id}")
	public ResponseEntity<Patient> findByPatientId(@PathVariable int id) {
		logger.info("Fetching patient details for ID: {}", id);
		return service.findByPatientId(id);
	}
}
