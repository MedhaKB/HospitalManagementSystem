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

	@After("execution(* com.example.demo.service.AppointmentServiceImpl.*(..))")
	public void logAfterAllAppointmentServiceMethods(JoinPoint joinPoint) {
		LOGGER.info("****LoggingAspectAfter.logAfterAllAppointmentServiceMethods() : "
				+ joinPoint.getSignature().getName());
	}

	@After("execution(* com.example.demo.service.AppointmentServiceImpl.findById(..))")
	public void logAfterFindById(JoinPoint joinPoint) {
		LOGGER.info("****LoggingAspectAfter.logAfterFindById() : " + joinPoint.getSignature().getName());
	}

	@After("execution(* com.example.demo.service.AppointmentServiceImpl.save(..))")
	public void logAfterSave(JoinPoint joinPoint) {
		LOGGER.info("****LoggingAspectAfter.logAfterSave() : " + joinPoint.getSignature().getName());
	}

	@After("execution(* com.example.demo.service.AppointmentServiceImpl.deleteById(..))")
	public void logAfterDeleteById(JoinPoint joinPoint) {
		LOGGER.info("****LoggingAspectAfter.logAfterDeleteById() : " + joinPoint.getSignature().getName());
	}

	@After("execution(* com.example.demo.service.AppointmentServiceImpl.findByDoctorId(..))")
	public void logAfterFindByDoctorId(JoinPoint joinPoint) {
		LOGGER.info("****LoggingAspectAfter.logAfterFindByDoctorId() : " + joinPoint.getSignature().getName());
	}

	@After("execution(* com.example.demo.service.AppointmentServiceImpl.accept(..))")
	public void logAfterAccept(JoinPoint joinPoint) {
		LOGGER.info("****LoggingAspectAfter.logAfterAccept() : " + joinPoint.getSignature().getName());
	}

	@After("execution(* com.example.demo.service.AppointmentServiceImpl.decline(..))")
	public void logAfterDecline(JoinPoint joinPoint) {
		LOGGER.info("****LoggingAspectAfter.logAfterDecline() : " + joinPoint.getSignature().getName());
	}

	@After("execution(* com.example.demo.service.AppointmentServiceImpl.findByPatientId(..))")
	public void logAfterFindByPatientId(JoinPoint joinPoint) {
		LOGGER.info("****LoggingAspectAfter.logAfterFindByPatientId() : " + joinPoint.getSignature().getName());
	}
}
