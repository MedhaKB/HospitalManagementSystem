package com.example.demo.exception;

public class PrescriptionNotFound extends RuntimeException {

	public PrescriptionNotFound(String msg) {
		super(msg);
	}
}
