package com.example.demo.exception;

public class AppointmentNotFoundException extends RuntimeException {
	public AppointmentNotFoundException(String message) {
		super(message);
	}

}
