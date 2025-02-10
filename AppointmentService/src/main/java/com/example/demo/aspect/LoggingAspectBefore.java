package com.example.demo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspectBefore {

	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

	@Before("execution(* com.example.demo.service.AppointmentServiceImpl.*(..))")
	public void logBeforeAllAppointmentServiceMethods(JoinPoint joinPoint) {
		LOGGER.info("****LoggingAspectBefore.logBeforeAllAppointmentServiceMethods() : "
				+ joinPoint.getSignature().getName());
	}

	@Before("execution(* com.example.demo.service.AppointmentServiceImpl.findById(..))")
	public void logBeforeFindById(JoinPoint joinPoint) {
		LOGGER.info("****LoggingAspectBefore.logBeforeFindById() : " + joinPoint.getSignature().getName());
	}

	@Before("execution(* com.example.demo.service.AppointmentServiceImpl.save(..))")
	public void logBeforeSave(JoinPoint joinPoint) {
		LOGGER.info("****LoggingAspectBefore.logBeforeSave() : " + joinPoint.getSignature().getName());
	}

	@Before("execution(* com.example.demo.service.AppointmentServiceImpl.deleteById(..))")
	public void logBeforeDeleteById(JoinPoint joinPoint) {
		LOGGER.info("****LoggingAspectBefore.logBeforeDeleteById() : " + joinPoint.getSignature().getName());
	}

	@Before("execution(* com.example.demo.service.AppointmentServiceImpl.findByDoctorId(..))")
	public void logBeforeFindByDoctorId(JoinPoint joinPoint) {
		LOGGER.info("****LoggingAspectBefore.logBeforeFindByDoctorId() : " + joinPoint.getSignature().getName());
	}

	@Before("execution(* com.example.demo.service.AppointmentServiceImpl.accept(..))")
	public void logBeforeAccept(JoinPoint joinPoint) {
		LOGGER.info("****LoggingAspectBefore.logBeforeAccept() : " + joinPoint.getSignature().getName());
	}

	@Before("execution(* com.example.demo.service.AppointmentServiceImpl.decline(..))")
	public void logBeforeDecline(JoinPoint joinPoint) {
		LOGGER.info("****LoggingAspectBefore.logBeforeDecline() : " + joinPoint.getSignature().getName());
	}

	@Before("execution(* com.example.demo.service.AppointmentServiceImpl.findByPatientId(..))")
	public void logBeforeFindByPatientId(JoinPoint joinPoint) {
		LOGGER.info("****LoggingAspectBefore.logBeforeFindByPatientId() : " + joinPoint.getSignature().getName());
	}
}
