package com.example.demo.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.dto.AppointmentDto;
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

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AppointmentServiceImpl implements AppointmentService {

	private AppointmentRepository repository;

	private DoctorInterface doctorInterface;

	private PatientInterface patientInterface;

	/**
	 * Find an appointment by its ID.
	 * 
	 * @param id the ID of the appointment
	 * @return the appointment details
	 * @throws AppointmentNotFoundException if the appointment is not found
	 */
	@Override
	public ResponseEntity<PatientDoctorAppointmentDto> findById(int id) throws AppointmentNotFoundException {
		Appointment app = repository.findById(id).get();
		if(app!=null) {
		PatientDto patient = patientInterface.findByPatientId(app.getPatientId());
		DoctorDto doctorDto = doctorInterface.getDoctorById(app.getDoctorId());
		PatientDoctorAppointmentDto appPatDto = new PatientDoctorAppointmentDto(patient, doctorDto,
				app.getAppointmentId(), app.getDate(), app.getTime(), app.getStatus());
		return new ResponseEntity<>(appPatDto, HttpStatus.OK);
		}
		else {
			throw new AppointmentNotFoundException("Not Found any Appointment with id "+id);
		}
	}

	/**
	 * Save a new appointment for a specific doctor.
	 * 
	 * @param appointment the appointment details
	 * @param doctorId    the ID of the doctor
	 * @return the saved appointment
	 */
	@Override
	public ResponseEntity<Appointment> save(Appointment appointment, int doctorId) {
		appointment.setStatus("Pending");
		appointment.setDoctorId(doctorId);
		patientInterface.findByPatientId(appointment.getPatientId()); // validate patient
		doctorInterface.getDoctorById(doctorId); // validate doctor
		Appointment savedAppointment = repository.save(appointment);
		return new ResponseEntity<>(savedAppointment, HttpStatus.CREATED);
	}

	/**
	 * Delete an appointment by its ID.
	 * 
	 * @param id the ID of the appointment
	 * @return a confirmation message
	 */
	@Override
	public ResponseEntity<String> deleteById(int id) {
		repository.deleteById(id);
		return new ResponseEntity<>("Deleted Successfully", HttpStatus.OK);
	}

	/**
	 * Find all appointments for a specific doctor.
	 * 
	 * @param doctorId the ID of the doctor
	 * @return a list of appointments
	 * @throws AppointmentNotFoundException if no appointments are found for the
	 *                                      doctor
	 */
	@Override
	public ResponseEntity<List<PatientAppointmentDto>> findByDoctorId(int doctorId) throws AppointmentNotFoundException {
		List<Appointment> appointments = repository.findByDoctorId(doctorId);
		List<PatientAppointmentDto> list = new ArrayList<>();
		for(Appointment e: appointments) {
			PatientDto patient=patientInterface.findByPatientId(e.getPatientId());
			PatientAppointmentDto dto=new PatientAppointmentDto(patient,e.getAppointmentId(),e.getDate(),e.getTime(),e.getStatus());
			list.add(dto);
		}
		return new ResponseEntity<>(list,HttpStatus.OK);
		
	}

	/**
	 * Accept an appointment by its ID.
	 * 
	 * @param id the ID of the appointment
	 * @return a confirmation message
	 */
	@Override
	public ResponseEntity<String> accept(int id) {
		Appointment apt = repository.findByAppointmentId(id);
		apt.setStatus("Accepted");
		repository.save(apt);
		return new ResponseEntity<>("Accepted", HttpStatus.OK);
	}

	/**
	 * Decline an appointment by its ID.
	 * 
	 * @param id the ID of the appointment
	 * @return a confirmation message
	 */
	@Override
	public ResponseEntity<String> decline(int id) {
		Appointment apt = repository.findByAppointmentId(id);
		apt.setStatus("Declined");
		repository.save(apt);
		return new ResponseEntity<>("Declined", HttpStatus.OK);
	}

	/**
	 * Find all appointments for a specific patient.
	 * 
	 * @param patientId the ID of the patient
	 * @return a list of appointments
	 */
	public ResponseEntity<List<DoctorAppointmentDto>> findByPatientId(int patientId) {
		List<Appointment> appointments = repository.findByPatientId(patientId);
		List<DoctorAppointmentDto> list = new ArrayList<>();
		for(Appointment e: appointments) {
			DoctorDto doctor=doctorInterface.getDoctorById(e.getDoctorId());
			DoctorAppointmentDto dto=new DoctorAppointmentDto(doctor,e.getAppointmentId(),e.getDate(),e.getTime(),e.getStatus());
			list.add(dto);
		}
		return new ResponseEntity<>(list,HttpStatus.OK);
	}

	public ResponseEntity<List<PatientAppointmentDto>> getAppointmentsForDoctor(int doctorId, LocalDate currentDate) {
		List<Appointment> appointments = repository.findByDoctorIdAndDate(doctorId, currentDate);
		List<PatientAppointmentDto> list = new ArrayList<>();
		for(Appointment e: appointments) {
			PatientDto patient=patientInterface.findByPatientId(e.getPatientId());
			PatientAppointmentDto dto=new PatientAppointmentDto(patient,e.getAppointmentId(),e.getDate(),e.getTime(),e.getStatus());
			list.add(dto);
		}
		return new ResponseEntity<>(list,HttpStatus.OK);
	}

	// Shows details of all appointments for a specific patient ID
	@Override
	public ResponseEntity<List<String>> show(int patientId) {
		List<Appointment> obj = repository.findByPatientId(patientId);
		List<String> provider = new ArrayList<>();
		for (Appointment e : obj) {
			DoctorDto docDto = doctorInterface.getDoctorById(e.getDoctorId());
			String doctor = docDto.getName();
			String sentence;
			if (e.getStatus().equals("Accepted")) {
				sentence = "Your requested appointment has been approved by doctor " + doctor + " on " + e.getDate()
						+ " at " + e.getTime();
			} else if (e.getStatus().equals("Declined")) {
				sentence = "Your requested appointment has been declined by doctor " + doctor;
			} else {
				sentence = "Your requested appointment is still pending for doctor " + doctor;
			}
			provider.add(sentence);
		}
		return new ResponseEntity<>(provider, HttpStatus.OK);
	}
	
	public AppointmentDto getById(int id){
		Appointment appointment = repository.findByAppointmentId(id);
		AppointmentDto appointmentDto = new AppointmentDto(appointment.getAppointmentId(), appointment.getPatientId(), appointment.getDoctorId(), appointment.getDate(), appointment.getTime(), appointment.getStatus());
		
		return appointmentDto;
		
	}

}
