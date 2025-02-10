package com.example.demo.service;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Patient;
import com.example.demo.exception.PatientNotFound;
import com.example.demo.repository.PatientRepository;

import lombok.AllArgsConstructor;

// Marks this class as a Spring service
@Service
// Generates a constructor with one parameter for each field in this class
@AllArgsConstructor
public class PatientServiceImpl implements PatientService {

	// Dependencies for repository and external interfaces
	private final PatientRepository repository;

	// Adds a new patient to the repository
	@Override
	public ResponseEntity<String> addPatient(Patient patient) {
		repository.save(patient);
		return new ResponseEntity<>("Patient successfully added", HttpStatus.CREATED);
	}

	// Updates patient details if the patient is found in the repository
	@Override
	public ResponseEntity<Patient> updatePatientDetails(int patientId, Patient updatedPatient) throws PatientNotFound {
		Optional<Patient> optional = repository.findById(patientId);
		if (optional.isPresent()) {
			Patient patient = optional.get();
			patient.setEmailID(updatedPatient.getEmailID());
			patient.setGender(updatedPatient.getGender());
			patient.setMobile_number(updatedPatient.getMobile_number());
			patient.setPassword(updatedPatient.getPassword());
			patient.setPatientAge(updatedPatient.getPatientAge());
			patient.setPatientName(updatedPatient.getPatientName());
			repository.save(patient);

			return new ResponseEntity<>(patient, HttpStatus.OK);
		} else {
			throw new PatientNotFound("Could not find Patient with patientId " + patientId);
		}
	}

	// Deletes a patient by ID
	@Override
	public ResponseEntity<String> deletePatient(int id) {
		repository.deleteById(id);
		return new ResponseEntity<>("Deleted Successfully", HttpStatus.OK);
	}

	// Finds patient details by patient ID
	@Override
	public ResponseEntity<Patient> findByPatientId(int id) throws PatientNotFound {
		Optional<Patient> optional = repository.findById(id);
		if (optional.isPresent()) {
			Patient patient = optional.get();
			return new ResponseEntity<>(patient, HttpStatus.OK);
		} else {
			throw new PatientNotFound("Patient not present");
		}
	}
}