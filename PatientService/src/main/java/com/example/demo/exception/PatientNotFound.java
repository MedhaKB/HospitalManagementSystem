package com.example.demo.exception;

public class PatientNotFound extends RuntimeException {
	public PatientNotFound(String message) {
		super(message);
	}

}
