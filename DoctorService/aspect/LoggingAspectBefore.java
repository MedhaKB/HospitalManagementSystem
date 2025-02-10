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

	@Before("execution(* com.example.demo.service.PatientServiceImpl.*(..))")
	public void logBeforeAllPatientServiceMethods(JoinPoint joinPoint) {
		LOGGER.info(
				"****LoggingAspectBefore.logBeforeAllPatientServiceMethods() : " + joinPoint.getSignature().getName());
	}

	@Before("execution(* com.example.demo.service.PatientServiceImpl.addPatient(..))")
	public void logBeforeAddPatient(JoinPoint joinPoint) {
		LOGGER.info("****LoggingAspectBefore.logBeforeAddPatient() : " + joinPoint.getSignature().getName());
	}

	@Before("execution(* com.example.demo.service.PatientServiceImpl.updatePatientDetails(..))")
	public void logBeforeUpdatePatientDetails(JoinPoint joinPoint) {
		LOGGER.info("****LoggingAspectBefore.logBeforeUpdatePatientDetails() : " + joinPoint.getSignature().getName());
	}

	@Before("execution(* com.example.demo.service.PatientServiceImpl.deletePatient(..))")
	public void logBeforeDeletePatient(JoinPoint joinPoint) {
		LOGGER.info("****LoggingAspectBefore.logBeforeDeletePatient() : " + joinPoint.getSignature().getName());
	}

	@Before("execution(* com.example.demo.service.PatientServiceImpl.save(..))")
	public void logBeforeSave(JoinPoint joinPoint) {
		LOGGER.info("****LoggingAspectBefore.logBeforeSave() : " + joinPoint.getSignature().getName());
	}

	@Before("execution(* com.example.demo.service.PatientServiceImpl.findByPatientId(..))")
	public void logBeforeFindByPatientId(JoinPoint joinPoint) {
		LOGGER.info("****LoggingAspectBefore.logBeforeFindByPatientId() : " + joinPoint.getSignature().getName());
	}

	@Before("execution(* com.example.demo.service.PatientServiceImpl.findById(..))")
	public void logBeforeFindById(JoinPoint joinPoint) {
		LOGGER.info("****LoggingAspectBefore.logBeforeFindById() : " + joinPoint.getSignature().getName());
	}

	@Before("execution(* com.example.demo.service.PatientServiceImpl.show(..))")
	public void logBeforeShow(JoinPoint joinPoint) {
		LOGGER.info("****LoggingAspectBefore.logBeforeShow() : " + joinPoint.getSignature().getName());
	}
}
