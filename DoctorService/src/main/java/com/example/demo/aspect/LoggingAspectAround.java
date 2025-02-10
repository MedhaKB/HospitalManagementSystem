package com.example.demo.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspectAround {

	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

	@Around("execution(* com.example.demo.service.DoctorServiceImpl.*(..))")
	public Object logAroundAllDoctorServiceMethods(ProceedingJoinPoint joinPoint) throws Throwable {
		LOGGER.info("****LoggingAspectAround.logAroundAllDoctorServiceMethods() - Before : "
				+ joinPoint.getSignature().getName());
		Object result = joinPoint.proceed();
		LOGGER.info("****LoggingAspectAround.logAroundAllDoctorServiceMethods() - After : "
				+ joinPoint.getSignature().getName());
		return result;
	}

	@Around("execution(* com.example.demo.service.DoctorServiceImpl.addDoctor(..))")
	public Object logAroundAddDoctor(ProceedingJoinPoint joinPoint) throws Throwable {
		LOGGER.info("****LoggingAspectAround.logAroundAddDoctor() - Before : " + joinPoint.getSignature().getName());
		Object result = joinPoint.proceed();
		LOGGER.info("****LoggingAspectAround.logAroundAddDoctor() - After : " + joinPoint.getSignature().getName());
		return result;
	}

	@Around("execution(* com.example.demo.service.DoctorServiceImpl.updateDoctor(..))")
	public Object logAroundUpdateDoctor(ProceedingJoinPoint joinPoint) throws Throwable {
		LOGGER.info("****LoggingAspectAround.logAroundUpdateDoctor() - Before : " + joinPoint.getSignature().getName());
		Object result = joinPoint.proceed();
		LOGGER.info("****LoggingAspectAround.logAroundUpdateDoctor() - After : " + joinPoint.getSignature().getName());
		return result;
	}

	@Around("execution(* com.example.demo.service.DoctorServiceImpl.deleteDoctor(..))")
	public Object logAroundDeleteDoctor(ProceedingJoinPoint joinPoint) throws Throwable {
		LOGGER.info("****LoggingAspectAround.logAroundDeleteDoctor() - Before : " + joinPoint.getSignature().getName());
		Object result = joinPoint.proceed();
		LOGGER.info("****LoggingAspectAround.logAroundDeleteDoctor() - After : " + joinPoint.getSignature().getName());
		return result;
	}

	@Around("execution(* com.example.demo.service.DoctorServiceImpl.findBySpecialization(..))")
	public Object logAroundFindBySpecialization(ProceedingJoinPoint joinPoint) throws Throwable {
		LOGGER.info("****LoggingAspectAround.logAroundFindBySpecialization() - Before : "
				+ joinPoint.getSignature().getName());
		Object result = joinPoint.proceed();
		LOGGER.info("****LoggingAspectAround.logAroundFindBySpecialization() - After : "
				+ joinPoint.getSignature().getName());
		return result;
	}

	@Around("execution(* com.example.demo.service.DoctorServiceImpl.getAppointmentById(..))")
	public Object logAroundGetAppointmentById(ProceedingJoinPoint joinPoint) throws Throwable {
		LOGGER.info("****LoggingAspectAround.logAroundGetAppointmentById() - Before : "
				+ joinPoint.getSignature().getName());
		Object result = joinPoint.proceed();
		LOGGER.info("****LoggingAspectAround.logAroundGetAppointmentById() - After : "
				+ joinPoint.getSignature().getName());
		return result;
	}

}