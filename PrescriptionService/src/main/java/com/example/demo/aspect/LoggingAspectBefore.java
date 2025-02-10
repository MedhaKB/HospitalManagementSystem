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

	/**
	 * Logs before any method execution in PrescriptionServiceImpl.
	 * 
	 * @param joinPoint provides reflective access to both the state and the
	 *                  location of the join point
	 */
	@Before("execution(* com.example.demo.service.PrescriptionServiceImpl.*(..))")
	public void logBeforeAllPrescriptionServiceMethods(JoinPoint joinPoint) {
		LOGGER.info("****LoggingAspectBefore.logBeforeAllPrescriptionServiceMethods() : "
				+ joinPoint.getSignature().getName());
	}

	/**
	 * Logs before the addMedicine method execution in PrescriptionServiceImpl.
	 * 
	 * @param joinPoint provides reflective access to both the state and the
	 *                  location of the join point
	 */
	@Before("execution(* com.example.demo.service.PrescriptionServiceImpl.addMedicine(..))")
	public void logBeforeAddMedicine(JoinPoint joinPoint) {
		LOGGER.info("****LoggingAspectBefore.logBeforeAddMedicine() : " + joinPoint.getSignature().getName());
	}

	/**
	 * Logs before the findMedicneById method execution in PrescriptionServiceImpl.
	 * 
	 * @param joinPoint provides reflective access to both the state and the
	 *                  location of the join point
	 */
	@Before("execution(* com.example.demo.service.PrescriptionServiceImpl.findMedicneById(..))")
	public void logBeforeFindMedicneById(JoinPoint joinPoint) {
		LOGGER.info("****LoggingAspectBefore.logBeforeFindMedicneById() : " + joinPoint.getSignature().getName());
	}

	/**
	 * Logs before the addPrescription method execution in PrescriptionServiceImpl.
	 * 
	 * @param joinPoint provides reflective access to both the state and the
	 *                  location of the join point
	 */
	@Before("execution(* com.example.demo.service.PrescriptionServiceImpl.addPrescription(..))")
	public void logBeforeAddPrescription(JoinPoint joinPoint) {
		LOGGER.info("****LoggingAspectBefore.logBeforeAddPrescription() : " + joinPoint.getSignature().getName());
	}

	/**
	 * Logs before the deletePrescription method execution in
	 * PrescriptionServiceImpl.
	 * 
	 * @param joinPoint provides reflective access to both the state and the
	 *                  location of the join point
	 */
	@Before("execution(* com.example.demo.service.PrescriptionServiceImpl.deletePrescription(..))")
	public void logBeforeDeletePrescription(JoinPoint joinPoint) {
		LOGGER.info("****LoggingAspectBefore.logBeforeDeletePrescription() : " + joinPoint.getSignature().getName());
	}

	/**
	 * Logs before the findByPatientId method execution in PrescriptionServiceImpl.
	 * 
	 * @param joinPoint provides reflective access to both the state and the
	 *                  location of the join point
	 */
	@Before("execution(* com.example.demo.service.PrescriptionServiceImpl.findByPatientId(..))")
	public void logBeforeFindByPatientId(JoinPoint joinPoint) {
		LOGGER.info("****LoggingAspectBefore.logBeforeFindByPatientId() : " + joinPoint.getSignature().getName());
	}

	/**
	 * Logs before the findByAid method execution in PrescriptionServiceImpl.
	 * 
	 * @param joinPoint provides reflective access to both the state and the
	 *                  location of the join point
	 */
	@Before("execution(* com.example.demo.service.PrescriptionServiceImpl.findByAid(..))")
	public void logBeforeFindByAid(JoinPoint joinPoint) {
		LOGGER.info("****LoggingAspectBefore.logBeforeFindByAid() : " + joinPoint.getSignature().getName());
	}
}
