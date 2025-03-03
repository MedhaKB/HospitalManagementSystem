package com.example.demo.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PatientDto {
    private int patientID;
    private String emailID;
    private String patientName;
    private int patientAge;
    private String mobile_number;
    private String gender;
}
