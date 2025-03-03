package com.example.demo.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.DTO.PatientDoctorAppointmentDto;
import com.example.demo.entity.Doctor;

public interface DoctorService {

	public ResponseEntity<String> addDoctor(Doctor doctor);

	public ResponseEntity<String> deleteDoctor(int doctorId);

	public ResponseEntity<Doctor> updateDoctor(int doctorId, Doctor doctor);

	public List<Doctor> findBySpecialization(String specialization);

	public ResponseEntity<Doctor> findById(int doctorId);

	public List<Doctor> getAllDoctors();
	
	public ResponseEntity<PatientDoctorAppointmentDto> getAppointmentById(@PathVariable int id);
}
