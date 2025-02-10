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

	/**
	 * Logs after any method execution in PrescriptionServiceImpl.
	 * 
	 * @param joinPoint provides reflective access to both the state and the
	 *                  location of the join point
	 */
	@After("execution(* com.example.demo.service.PrescriptionServiceImpl.*(..))")
	public void logAfterAllPrescriptionServiceMethods(JoinPoint joinPoint) {
		LOGGER.info("****LoggingAspectAfter.logAfterAllPrescriptionServiceMethods() : "
				+ joinPoint.getSignature().getName());
	}

	/**
	 * Logs after the addMedicine method execution in PrescriptionServiceImpl.
	 * 
	 * @param joinPoint provides reflective access to both the state and the
	 *                  location of the join point
	 */
	@After("execution(* com.example.demo.service.PrescriptionServiceImpl.addMedicine(..))")
	public void logAfterAddMedicine(JoinPoint joinPoint) {
		LOGGER.info("****LoggingAspectAfter.logAfterAddMedicine() : " + joinPoint.getSignature().getName());
	}

	/**
	 * Logs after the findMedicneById method execution in PrescriptionServiceImpl.
	 * 
	 * @param joinPoint provides reflective access to both the state and the
	 *                  location of the join point
	 */
	@After("execution(* com.example.demo.service.PrescriptionServiceImpl.findMedicneById(..))")
	public void logAfterFindMedicneById(JoinPoint joinPoint) {
		LOGGER.info("****LoggingAspectAfter.logAfterFindMedicneById() : " + joinPoint.getSignature().getName());
	}

	/**
	 * Logs after the addPrescription method execution in PrescriptionServiceImpl.
	 * 
	 * @param joinPoint provides reflective access to both the state and the
	 *                  location of the join point
	 */
	@After("execution(* com.example.demo.service.PrescriptionServiceImpl.addPrescription(..))")
	public void logAfterAddPrescription(JoinPoint joinPoint) {
		LOGGER.info("****LoggingAspectAfter.logAfterAddPrescription() : " + joinPoint.getSignature().getName());
	}

	/**
	 * Logs after the deletePrescription method execution in
	 * PrescriptionServiceImpl.
	 * 
	 * @param joinPoint provides reflective access to both the state and the
	 *                  location of the join point
	 */
	@After("execution(* com.example.demo.service.PrescriptionServiceImpl.deletePrescription(..))")
	public void logAfterDeletePrescription(JoinPoint joinPoint) {
		LOGGER.info("****LoggingAspectAfter.logAfterDeletePrescription() : " + joinPoint.getSignature().getName());
	}

	/**
	 * Logs after the findByPatientId method execution in PrescriptionServiceImpl.
	 * 
	 * @param joinPoint provides reflective access to both the state and the
	 *                  location of the join point
	 */
	@After("execution(* com.example.demo.service.PrescriptionServiceImpl.findByPatientId(..))")
	public void logAfterFindByPatientId(JoinPoint joinPoint) {
		LOGGER.info("****LoggingAspectAfter.logAfterFindByPatientId() : " + joinPoint.getSignature().getName());
	}

	/**
	 * Logs after the findByAid method execution in PrescriptionServiceImpl.
	 * 
	 * @param joinPoint provides reflective access to both the state and the
	 *                  location of the join point
	 */
	@After("execution(* com.example.demo.service.PrescriptionServiceImpl.findByAid(..))")
	public void logAfterFindByAid(JoinPoint joinPoint) {
		LOGGER.info("****LoggingAspectAfter.logAfterFindByAid() : " + joinPoint.getSignature().getName());
	}
}
