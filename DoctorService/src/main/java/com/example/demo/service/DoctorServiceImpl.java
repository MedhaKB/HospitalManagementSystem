package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Doctor;
import com.example.demo.exception.DoctorNotFound;
import com.example.demo.repository.DoctorRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class DoctorServiceImpl implements DoctorService {

	private final DoctorRepository repo;

	// Add a new doctor to the repository
	@Override
	public ResponseEntity<String> addDoctor(Doctor doctor) {
		repo.save(doctor);
		return new ResponseEntity<>("Doctor added successfully", HttpStatus.CREATED);
	}

	// Delete a doctor from the repository by ID
	@Override
	public ResponseEntity<String> deleteDoctor(int doctorId) {
		repo.deleteById(doctorId);
		return new ResponseEntity<>("Doctor with id " + doctorId + " deleted successfully", HttpStatus.OK);
	}

	// Update an existing doctor's details
	@Override
	public ResponseEntity<Doctor> updateDoctor(int doctorId, Doctor updatedDoctor) throws DoctorNotFound {
		Optional<Doctor> optional = repo.findById(doctorId);
		if (optional.isPresent()) {
			Doctor doctor = optional.get();
			doctor.setEmailId(updatedDoctor.getEmailId());
			doctor.setMobile_number(updatedDoctor.getMobile_number());
			doctor.setName(updatedDoctor.getName());
			doctor.setSpecialization(updatedDoctor.getSpecialization());
			repo.save(doctor);
			return new ResponseEntity<>(doctor, HttpStatus.OK);
		} else {
			throw new DoctorNotFound("Could not find Doctor with doctorId " + doctorId);
		}
	}

	// Find doctors by their specialization
	@Override
	public ResponseEntity<List<Doctor>> findBySpecialization(String specialization) {
		List<Doctor> doctors = repo.findBySpecialization(specialization);
		return new ResponseEntity<>(doctors, HttpStatus.OK);
	}

	// Find a doctor by their ID
	public ResponseEntity<Doctor> findById(int doctorId) throws DoctorNotFound {
		Optional<Doctor> optional = repo.findById(doctorId);
		if (optional.isPresent()) {
			Doctor doctor = new Doctor();
			doctor = optional.get();
			return new ResponseEntity<>(doctor, HttpStatus.OK);
		} else {
			throw new DoctorNotFound("Doctor of " + doctorId + " is not present");
		}
	}
}
