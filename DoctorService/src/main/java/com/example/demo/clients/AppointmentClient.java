package com.example.demo.clients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.DTO.PatientDoctorAppointmentDto;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;


@FeignClient(name="appointment", url="http://localhost:1002/appointment")
public interface AppointmentClient {
	@GetMapping("/findById/{id}")
	@CircuitBreaker(name = "findById", fallbackMethod = "fallbackFindMethod")
	public ResponseEntity<PatientDoctorAppointmentDto> findById(@PathVariable int id);
	
	default ResponseEntity<PatientDoctorAppointmentDto> fallbackFindMethod(Throwable t) {
        System.out.println("Fallback method called");
        PatientDoctorAppointmentDto res = new  PatientDoctorAppointmentDto();
        return new ResponseEntity<>(res, HttpStatus.OK); 
    }
}
