package com.example.demo.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DoctorDto {

	private int doctorId;
	private String emailId;
	private String name;
	private String mobile_number;
	private String specialization;
}
