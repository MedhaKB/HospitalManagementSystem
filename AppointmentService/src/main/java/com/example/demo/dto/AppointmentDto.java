package com.example.demo.dto;

import java.time.LocalDate;
import java.time.LocalTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppointmentDto {

	private Integer appointmentId; // Unique identifier for the appointment
	private Integer patientId; // Unique identifier for the patient
	private Integer doctorId; // Unique identifier for the doctor
	private LocalDate date; // Date of the appointment
	private LocalTime time;
	private String status;
}