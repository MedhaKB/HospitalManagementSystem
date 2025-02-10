package com.example.demo.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.dto.PatientDto;

@FeignClient("PATIENTSERVICE")
public interface PatientInterface {

	@GetMapping("patient/findByPatientId/{id}")
	public PatientDto findByPatientId(@PathVariable int id);

}
