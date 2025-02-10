package com.example.demo.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.example.demo.entity.Doctor;

public interface DoctorService {

	public ResponseEntity<String> addDoctor(Doctor doctor);

	public ResponseEntity<String> deleteDoctor(int doctorId);

	public ResponseEntity<Doctor> updateDoctor(int doctorId, Doctor doctor);

	public ResponseEntity<List<Doctor>> findBySpecialization(String specialization);

	public ResponseEntity<Doctor> findById(int doctorId);
}
