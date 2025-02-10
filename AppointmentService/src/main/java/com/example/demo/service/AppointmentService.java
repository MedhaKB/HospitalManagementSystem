package com.example.demo.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.http.ResponseEntity;

import com.example.demo.dto.AppointmentDto;
import com.example.demo.dto.DoctorAppointmentDto;
import com.example.demo.dto.PatientAppointmentDto;
import com.example.demo.dto.PatientDoctorAppointmentDto;
import com.example.demo.entity.Appointment;
import com.example.demo.exception.AppointmentNotFoundException;

public interface AppointmentService {

	public ResponseEntity<PatientDoctorAppointmentDto> findById(int id) throws AppointmentNotFoundException;

	public ResponseEntity<Appointment> save(Appointment appointment, int doctorId);

	public ResponseEntity<String> deleteById(int id);

	public ResponseEntity<List<PatientAppointmentDto>> findByDoctorId(int doctorId) throws AppointmentNotFoundException;

	public ResponseEntity<String> accept(int id);

	public ResponseEntity<String> decline(int id);

	public ResponseEntity<List<DoctorAppointmentDto>> findByPatientId(int patientId);

	public ResponseEntity<List<PatientAppointmentDto>> getAppointmentsForDoctor(int doctorId,LocalDate date);
	
	public ResponseEntity<List<String>> show(int patientId) ;
	
	public AppointmentDto getById(int id);

}
