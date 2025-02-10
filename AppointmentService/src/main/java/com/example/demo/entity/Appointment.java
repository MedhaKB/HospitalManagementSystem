package com.example.demo.entity;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity // Indicates that this class is a JPA entity
@Data // Lombok annotation to generate getters, setters, toString, equals, and hashCode methods
@AllArgsConstructor // Lombok annotation to generate a constructor with all fields as parameters
@NoArgsConstructor // Lombok annotation to generate a no-args constructor
public class Appointment {
    @Id // Specifies the primary key of the entity
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Specifies the generation strategy for the primary key
    private Integer appointmentId; // Unique identifier for the appointment

    @Positive(message = "Patient ID must be a positive number") // Validation to ensure patient ID is positive
    private Integer patientId; // Unique identifier for the patient

    @Positive(message = "Doctor ID must be a positive number") // Validation to ensure doctor ID is positive
    private Integer doctorId; // Unique identifier for the doctor

    @NotNull(message = "Date cannot be null") // Validation to ensure date is not null
    @Future(message = "Date must be in the future") // Validation to ensure the date is in the future
    private LocalDate date; // Date of the appointment

    @NotNull(message = "Time cannot be null") // Validation to ensure time is not null
    private LocalTime time; // Time of the appointment

    private String status; // Status of the appointment (e.g., scheduled, completed, cancelled)
}
