package com.example.demo.dto;

import java.time.LocalDate;
import java.time.LocalTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PatientAppointmentDto {
	
	PatientDto patient;
	private int appId;
	private LocalDate date;
	private LocalTime time;
	private String status;

}
