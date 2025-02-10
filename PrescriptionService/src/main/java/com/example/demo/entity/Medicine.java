package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Medicine {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer mid; // Unique identifier for the medicine

	@NotNull(message = "PID cannot be null")
	private Integer pid; // Unique identifier for the prescription

	@NotNull(message = "Name cannot be null")
	private String name; // Name of the medicine

	@PositiveOrZero(message = "Tablet count must be zero or positive")
	private Integer tabletCount; // Number of tablets

	@NotNull(message = "Morning cannot be null")
	private Boolean morning; // Indicates if the medicine is taken in the morning

	@NotNull(message = "Afternoon cannot be null")
	private Boolean afternoon; // Indicates if the medicine is taken in the afternoon

	@NotNull(message = "Night cannot be null")
	private Boolean night; // Indicates if the medicine is taken at night
}
