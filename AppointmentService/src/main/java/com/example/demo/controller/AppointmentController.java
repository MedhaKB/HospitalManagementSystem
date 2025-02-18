package com.example.demo.controller;

import java.time.LocalDate;
import java.util.List;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.AppointmentDto;
import com.example.demo.dto.DoctorAppointmentDto;
import com.example.demo.dto.PatientAppointmentDto;
import com.example.demo.dto.PatientDoctorAppointmentDto;
import com.example.demo.entity.Appointment;
import com.example.demo.exception.AppointmentNotFoundException;
import com.example.demo.service.AppointmentService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/appointment")
@AllArgsConstructor
public class AppointmentController {

	private static final Logger logger = LoggerFactory.getLogger(AppointmentController.class);

	private final AppointmentService service;

	/**
	 * Fetch an appointment by its ID.
	 * 
	 * @param id the ID of the appointment
	 * @return the appointment details
	 * @throws AppointmentNotFoundException if the appointment is not found
	 */
	@GetMapping("/findById/{id}")
	public ResponseEntity<PatientDoctorAppointmentDto> findById(@PathVariable int id)
			throws AppointmentNotFoundException {
		logger.info("Fetching appointment with ID: {}", id);
		return service.findById(id);
	}

	/**
	 * Book a new appointment for a specific doctor.
	 * 
	 * @param appointment the appointment details
	 * @param doctorId    the ID of the doctor
	 * @return the booked appointment
	 */
	@PostMapping("/book/{doctorId}")
	public ResponseEntity<Appointment> save(@RequestBody Appointment appointment, @PathVariable("doctorId") int doctorId) {
		logger.info("Booking appointment for doctor ID: {}", doctorId);
		return service.save(appointment, doctorId);
	}

	/**
	 * Delete an appointment by its ID.
	 * 
	 * @param id the ID of the appointment
	 * @return a confirmation message
	 */
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteById(@PathVariable int id) {
		logger.info("Deleting appointment with ID: {}", id);
		return service.deleteById(id);
	}

	/**
	 * Fetch all appointments for a specific doctor.
	 * 
	 * @param doctorId the ID of the doctor
	 * @return a list of appointments
	 * @throws AppointmentNotFoundException
	 */
	@GetMapping("/findByDoctorId/{doctorId}")
	public ResponseEntity<List<PatientAppointmentDto>> findByDoctorId(@PathVariable int doctorId)
			throws AppointmentNotFoundException {
		logger.info("Fetching appointments for doctor ID: {}", doctorId);
		return service.findByDoctorId(doctorId);
	}

	/**
	 * Accept an appointment by its ID.
	 * 
	 * @param id the ID of the appointment
	 * @return a confirmation message
	 */
	@PutMapping("/accept/{id}")
	public ResponseEntity<String> accept(@PathVariable int id) {
		logger.info("Accepting appointment with ID: {}", id);
		return service.accept(id);
	}

	/**
	 * Decline an appointment by its ID.
	 * 
	 * @param id the ID of the appointment
	 * @return a confirmation message
	 */
	@PutMapping("/decline/{id}")
	public ResponseEntity<String> decline(@PathVariable int id) {
		logger.info("Declining appointment with ID: {}", id);
		return service.decline(id);
	}

	/**
	 * Fetch all appointments for a specific patient.
	 * 
	 * @param patientId the ID of the patient
	 * @return a list of appointments
	 */
	@GetMapping("/findByPatientId/{patientId}")
	public ResponseEntity<List<DoctorAppointmentDto>> findByPatientId(@PathVariable int patientId) {
		logger.info("Fetching appointments for patient ID: {}", patientId);
		return service.findByPatientId(patientId);
	}

	/**
	 * Fetch appointments for a doctor on a specific date.
	 * 
	 * @param doctorId    the ID of the doctor
	 * @param currentDate the date for which appointments are being fetched
	 * @return a list of appointments
	 */
	@GetMapping("/getByDate/{doctorId}/{currentDate}")
	public ResponseEntity<List<PatientAppointmentDto>> getAppointmentsForDoctor(@PathVariable("doctorId") int doctorId,
			@PathVariable("currentDate") LocalDate currentDate) {
		logger.info("Fetching appointments for doctor ID: {} on date: {}", doctorId, currentDate);
		return service.getAppointmentsForDoctor(doctorId, currentDate);
	}

	/**
	 * Show the status of appointments for a specific patient.
	 * 
	 * @param patientId the ID of the patient
	 * @return a list of appointment statuses
	 */
	@GetMapping("/getStatus/{patientId}")
	public ResponseEntity<List<String>> show(@PathVariable int patientId) {
		logger.info("Fetching appointment status for patient ID: {}", patientId);
		return service.show(patientId);
	}
	
	@GetMapping("/getById/{id}")
	public ResponseEntity<AppointmentDto> getById(@PathVariable int id){
		return ResponseEntity.ok(service.getById(id));
	}
}
