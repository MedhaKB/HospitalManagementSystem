package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// Lombok annotation to generate getters, setters, toString, and other methods
@Data
// Marks this class as a JPA entity
@Entity
// Specifies the table name in the database
@Table
// Lombok annotation to generate a constructor with one parameter for each field in this class
@AllArgsConstructor
// Lombok annotation to generate a default constructor with no parameters
@NoArgsConstructor
public class Patient {
    @Id
    // Specifies the primary key generation strategy
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int patientID;

    // Ensures email ID is not blank and follows a valid email format
    @NotBlank(message = "Email ID cannot be blank")
    @Email(message = "Email ID must be valid")
    private String emailID;

    // Ensures password is not blank and has a minimum length of 8 characters
    @NotBlank(message = "Password cannot be blank")
    @Size(min = 8, message = "Password must be at least 8 characters long")
    private String password;

    // Ensures patient name is not blank
    @NotBlank(message = "Patient name cannot be blank")
    private String patientName;

    // Ensures patient age is a positive number
    @Positive(message = "Patient age must be a positive number")
    private int patientAge;

    // Ensures mobile number is not null and follows a 10-digit pattern
    @NotNull(message = "Mobile number cannot be null")
    @Pattern(regexp = "^\\d{10}$", message = "Mobile number must be 10 digits long")
    private String mobile_number;

    // Ensures gender is not blank
    @NotBlank(message = "Gender cannot be blank")
    private String gender;
}
