package com.example.demo.exception;

public class SpecializationNotFound extends RuntimeException{
	
	public SpecializationNotFound(String message) {
		super(message);
	}

}