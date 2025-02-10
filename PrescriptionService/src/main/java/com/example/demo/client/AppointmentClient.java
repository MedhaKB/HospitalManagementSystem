package com.example.demo.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.dto.AppointmentDto;


@FeignClient("APPOINTMENTSERVICE")
public interface AppointmentClient {
	@GetMapping("/appointment/getById/{id}")
	public ResponseEntity<AppointmentDto> getById(@PathVariable int id);

}
