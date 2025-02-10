package com.example.demo.entity;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Prescription {
    @Id // Unique identifier for the prescription
    private Integer pid;

    @NotNull(message = "AID cannot be null") // Unique identifier for the appointment
    private Integer aid;

    @NotNull(message = "Patient ID cannot be null") 
    @Positive(message = "Patient ID must be positive") // Unique identifier for the patient
    private Integer patientid;

    @NotNull(message = "Doctor ID cannot be null")
    @Positive(message = "Doctor ID must be positive") // Unique identifier for the doctor
    private Integer doctorid;

    @OneToMany(mappedBy = "pid", cascade = CascadeType.ALL, fetch = FetchType.LAZY) // List of medicines in the prescription
    private List<Medicine> medicine;

    @NotNull(message = "Date cannot be null") // Date of the prescription
    private LocalDate date;
}
