package com.example.demo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.After;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspectAfter {

	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

	@After("execution(* com.example.demo.service.DoctorServiceImpl.*(..))")
	public void logAfterAllDoctorServiceMethods(JoinPoint joinPoint) {
		LOGGER.info("****LoggingAspectAfter.logAfterAllDoctorServiceMethods() : " + joinPoint.getSignature().getName());
	}

	@After("execution(* com.example.demo.service.DoctorServiceImpl.addDoctor(..))")
	public void logAfterAddDoctor(JoinPoint joinPoint) {
		LOGGER.info("****LoggingAspectAfter.logAfterAddDoctor() : " + joinPoint.getSignature().getName());
	}

	@After("execution(* com.example.demo.service.DoctorServiceImpl.updateDoctor(..))")
	public void logAfterUpdateDoctor(JoinPoint joinPoint) {
		LOGGER.info("****LoggingAspectAfter.logAfterUpdateDoctor() : " + joinPoint.getSignature().getName());
	}

	@After("execution(* com.example.demo.service.DoctorServiceImpl.deleteDoctor(..))")
	public void logAfterDeleteDoctor(JoinPoint joinPoint) {
		LOGGER.info("****LoggingAspectAfter.logAfterDeleteDoctor() : " + joinPoint.getSignature().getName());
	}

	@After("execution(* com.example.demo.service.DoctorServiceImpl.findBySpecialization(..))")
	public void logAfterFindBySpecialization(JoinPoint joinPoint) {
		LOGGER.info("****LoggingAspectAfter.logAfterFindBySpecialization() : " + joinPoint.getSignature().getName());
	}

	@After("execution(* com.example.demo.service.DoctorServiceImpl.findById(..))")
	public void logAfterFindById(JoinPoint joinPoint) {
		LOGGER.info("****LoggingAspectAfter.logAfterFindById() : " + joinPoint.getSignature().getName());
	}
}
