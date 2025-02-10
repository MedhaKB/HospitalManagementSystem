package com.example.demo.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.dto.DoctorDto;

@FeignClient("DOCTORSERVICE")
public interface DoctorInterface {
	
	@GetMapping("doctor/findbyId/{doctorId}") // Endpoint to get doctor details by ID
	public DoctorDto getDoctorById(@PathVariable int doctorId) ;

}
