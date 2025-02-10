package com.example.demo.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Appointment;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Integer> {

	public List<Appointment> findByDoctorId(int doctorId);

	public Appointment findByAppointmentId(int appointmentId);

	public List<Appointment> findByPatientId(int patientId);

	public List<Appointment> findByDoctorIdAndDate(int doctorId, LocalDate date);

}
