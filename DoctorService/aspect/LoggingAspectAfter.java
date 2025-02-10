
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

	@After("execution(* com.example.demo.service.PatientServiceImpl.*(..))")
	public void logAfterAllPatientServiceMethods(JoinPoint joinPoint) {
		LOGGER.info(
				"****LoggingAspectAfter.logAfterAllPatientServiceMethods() : " + joinPoint.getSignature().getName());
	}

	@After("execution(* com.example.demo.service.PatientServiceImpl.addPatient(..))")
	public void logAfterAddPatient(JoinPoint joinPoint) {
		LOGGER.info("****LoggingAspectAfter.logAfterAddPatient() : " + joinPoint.getSignature().getName());
	}

	@After("execution(* com.example.demo.service.PatientServiceImpl.updatePatientDetails(..))")
	public void logAfterUpdatePatientDetails(JoinPoint joinPoint) {
		LOGGER.info("****LoggingAspectAfter.logAfterUpdatePatientDetails() : " + joinPoint.getSignature().getName());
	}

	@After("execution(* com.example.demo.service.PatientServiceImpl.deletePatient(..))")
	public void logAfterDeletePatient(JoinPoint joinPoint) {
		LOGGER.info("****LoggingAspectAfter.logAfterDeletePatient() : " + joinPoint.getSignature().getName());
	}

	@After("execution(* com.example.demo.service.PatientServiceImpl.save(..))")
	public void logAfterSave(JoinPoint joinPoint) {
		LOGGER.info("****LoggingAspectAfter.logAfterSave() : " + joinPoint.getSignature().getName());
	}

	@After("execution(* com.example.demo.service.PatientServiceImpl.findByPatientId(..))")
	public void logAfterFindByPatientId(JoinPoint joinPoint) {
		LOGGER.info("****LoggingAspectAfter.logAfterFindByPatientId() : " + joinPoint.getSignature().getName());
	}

	@After("execution(* com.example.demo.service.PatientServiceImpl.findById(..))")
	public void logAfterFindById(JoinPoint joinPoint) {
		LOGGER.info("****LoggingAspectAfter.logAfterFindById() : " + joinPoint.getSignature().getName());
	}

	@After("execution(* com.example.demo.service.PatientServiceImpl.show(..))")
	public void logAfterShow(JoinPoint joinPoint) {
		LOGGER.info("****LoggingAspectAfter.logAfterShow() : " + joinPoint.getSignature().getName());
	}
}
