package com.example.demo.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Around;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspectAround {

	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

	/**
	 * Logs around any method execution in PrescriptionServiceImpl.
	 * 
	 * @param joinPoint provides reflective access to both the state and the
	 *                  location of the join point
	 * @return the result of the method execution
	 * @throws Throwable if any error occurs during method execution
	 */
	@Around("execution(* com.example.demo.service.PrescriptionServiceImpl.*(..))")
	public Object logAroundAllPrescriptionServiceMethods(ProceedingJoinPoint joinPoint) throws Throwable {
		LOGGER.info("****LoggingAspectAround.logAroundAllPrescriptionServiceMethods() - Before : "
				+ joinPoint.getSignature().getName());
		Object result = joinPoint.proceed();
		LOGGER.info("****LoggingAspectAround.logAroundAllPrescriptionServiceMethods() - After : "
				+ joinPoint.getSignature().getName());
		return result;
	}

	/**
	 * Logs around the addMedicine method execution in PrescriptionServiceImpl.
	 * 
	 * @param joinPoint provides reflective access to both the state and the
	 *                  location of the join point
	 * @return the result of the method execution
	 * @throws Throwable if any error occurs during method execution
	 */
	@Around("execution(* com.example.demo.service.PrescriptionServiceImpl.addMedicine(..))")
	public Object logAroundAddMedicine(ProceedingJoinPoint joinPoint) throws Throwable {
		LOGGER.info("****LoggingAspectAround.logAroundAddMedicine() - Before : " + joinPoint.getSignature().getName());
		Object result = joinPoint.proceed();
		LOGGER.info("****LoggingAspectAround.logAroundAddMedicine() - After : " + joinPoint.getSignature().getName());
		return result;
	}

	/**
	 * Logs around the findMedicneById method execution in PrescriptionServiceImpl.
	 * 
	 * @param joinPoint provides reflective access to both the state and the
	 *                  location of the join point
	 * @return the result of the method execution
	 * @throws Throwable if any error occurs during method execution
	 */
	@Around("execution(* com.example.demo.service.PrescriptionServiceImpl.findMedicneById(..))")
	public Object logAroundFindMedicneById(ProceedingJoinPoint joinPoint) throws Throwable {
		LOGGER.info(
				"****LoggingAspectAround.logAroundFindMedicneById() - Before : " + joinPoint.getSignature().getName());
		Object result = joinPoint.proceed();
		LOGGER.info(
				"****LoggingAspectAround.logAroundFindMedicneById() - After : " + joinPoint.getSignature().getName());
		return result;
	}

	/**
	 * Logs around the addPrescription method execution in PrescriptionServiceImpl.
	 * 
	 * @param joinPoint provides reflective access to both the state and the
	 *                  location of the join point
	 * @return the result of the method execution
	 * @throws Throwable if any error occurs during method execution
	 */
	@Around("execution(* com.example.demo.service.PrescriptionServiceImpl.addPrescription(..))")
	public Object logAroundAddPrescription(ProceedingJoinPoint joinPoint) throws Throwable {
		LOGGER.info(
				"****LoggingAspectAround.logAroundAddPrescription() - Before : " + joinPoint.getSignature().getName());
		Object result = joinPoint.proceed();
		LOGGER.info(
				"****LoggingAspectAround.logAroundAddPrescription() - After : " + joinPoint.getSignature().getName());
		return result;
	}

	/**
	 * Logs around the deletePrescription method execution in
	 * PrescriptionServiceImpl.
	 * 
	 * @param joinPoint provides reflective access to both the state and the
	 *                  location of the join point
	 * @return the result of the method execution
	 * @throws Throwable if any error occurs during method execution
	 */
	@Around("execution(* com.example.demo.service.PrescriptionServiceImpl.deletePrescription(..))")
	public Object logAroundDeletePrescription(ProceedingJoinPoint joinPoint) throws Throwable {
		LOGGER.info("****LoggingAspectAround.logAroundDeletePrescription() - Before : "
				+ joinPoint.getSignature().getName());
		Object result = joinPoint.proceed();
		LOGGER.info("****LoggingAspectAround.logAroundDeletePrescription() - After : "
				+ joinPoint.getSignature().getName());
		return result;
	}

	/**
	 * Logs around the findByPatientId method execution in PrescriptionServiceImpl.
	 * 
	 * @param joinPoint provides reflective access to both the state and the
	 *                  location of the join point
	 * @return the result of the method execution
	 * @throws Throwable if any error occurs during method execution
	 */
	@Around("execution(* com.example.demo.service.PrescriptionServiceImpl.findByPatientId(..))")
	public Object logAroundFindByPatientId(ProceedingJoinPoint joinPoint) throws Throwable {
		LOGGER.info(
				"****LoggingAspectAround.logAroundFindByPatientId() - Before : " + joinPoint.getSignature().getName());
		Object result = joinPoint.proceed();
		LOGGER.info(
				"****LoggingAspectAround.logAroundFindByPatientId() - After : " + joinPoint.getSignature().getName());
		return result;
	}

}