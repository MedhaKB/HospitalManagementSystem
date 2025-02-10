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

	@Around("execution(* com.example.demo.service.AppointmentServiceImpl.*(..))")
	public Object logAroundAllAppointmentServiceMethods(ProceedingJoinPoint joinPoint) throws Throwable {
		LOGGER.info("****LoggingAspectAround.logAroundAllAppointmentServiceMethods() - Before : "
				+ joinPoint.getSignature().getName());
		Object result = joinPoint.proceed();
		LOGGER.info("****LoggingAspectAround.logAroundAllAppointmentServiceMethods() - After : "
				+ joinPoint.getSignature().getName());
		return result;
	}

	@Around("execution(* com.example.demo.service.AppointmentServiceImpl.findById(..))")
	public Object logAroundFindById(ProceedingJoinPoint joinPoint) throws Throwable {
		LOGGER.info("****LoggingAspectAround.logAroundFindById() - Before : " + joinPoint.getSignature().getName());
		Object result = joinPoint.proceed();
		LOGGER.info("****LoggingAspectAround.logAroundFindById() - After : " + joinPoint.getSignature().getName());
		return result;
	}

	@Around("execution(* com.example.demo.service.AppointmentServiceImpl.save(..))")
	public Object logAroundSave(ProceedingJoinPoint joinPoint) throws Throwable {
		LOGGER.info("****LoggingAspectAround.logAroundSave() - Before : " + joinPoint.getSignature().getName());
		Object result = joinPoint.proceed();
		LOGGER.info("****LoggingAspectAround.logAroundSave() - After : " + joinPoint.getSignature().getName());
		return result;
	}

	@Around("execution(* com.example.demo.service.AppointmentServiceImpl.deleteById(..))")
	public Object logAroundDeleteById(ProceedingJoinPoint joinPoint) throws Throwable {
		LOGGER.info("****LoggingAspectAround.logAroundDeleteById() - Before : " + joinPoint.getSignature().getName());
		Object result = joinPoint.proceed();
		LOGGER.info("****LoggingAspectAround.logAroundDeleteById() - After : " + joinPoint.getSignature().getName());
		return result;
	}

	@Around("execution(* com.example.demo.service.AppointmentServiceImpl.findByDoctorId(..))")
	public Object logAroundFindByDoctorId(ProceedingJoinPoint joinPoint) throws Throwable {
		LOGGER.info(
				"****LoggingAspectAround.logAroundFindByDoctorId() - Before : " + joinPoint.getSignature().getName());
		Object result = joinPoint.proceed();
		LOGGER.info(
				"****LoggingAspectAround.logAroundFindByDoctorId() - After : " + joinPoint.getSignature().getName());
		return result;
	}

	@Around("execution(* com.example.demo.service.AppointmentServiceImpl.accept(..))")
	public Object logAroundAccept(ProceedingJoinPoint joinPoint) throws Throwable {
		LOGGER.info("****LoggingAspectAround.logAroundAccept() - Before : " + joinPoint.getSignature().getName());
		Object result = joinPoint.proceed();
		LOGGER.info("****LoggingAspectAround.logAroundAccept() - After : " + joinPoint.getSignature().getName());
		return result;
	}

	@Around("execution(* com.example.demo.service.AppointmentServiceImpl.decline(..))")
	public Object logAroundDecline(ProceedingJoinPoint joinPoint) throws Throwable {
		LOGGER.info("****LoggingAspectAround.logAroundDecline() - Before : " + joinPoint.getSignature().getName());
		Object result = joinPoint.proceed();
		LOGGER.info("****LoggingAspectAround.logAroundDecline() - After : " + joinPoint.getSignature().getName());
		return result;
	}
}