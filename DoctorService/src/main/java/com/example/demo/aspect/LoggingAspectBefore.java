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

	@Before("execution(* com.example.demo.service.DoctorServiceImpl.*(..))")
	public void logBeforeAllDoctorServiceMethods(JoinPoint joinPoint) {
		LOGGER.info(
				"****LoggingAspectBefore.logBeforeAllDoctorServiceMethods() : " + joinPoint.getSignature().getName());
	}

	@Before("execution(* com.example.demo.service.DoctorServiceImpl.addDoctor(..))")
	public void logBeforeAddDoctor(JoinPoint joinPoint) {
		LOGGER.info("****LoggingAspectBefore.logBeforeAddDoctor() : " + joinPoint.getSignature().getName());
	}

	@Before("execution(* com.example.demo.service.DoctorServiceImpl.updateDoctor(..))")
	public void logBeforeUpdateDoctor(JoinPoint joinPoint) {
		LOGGER.info("****LoggingAspectBefore.logBeforeUpdateDoctor() : " + joinPoint.getSignature().getName());
	}

	@Before("execution(* com.example.demo.service.DoctorServiceImpl.deleteDoctor(..))")
	public void logBeforeDeleteDoctor(JoinPoint joinPoint) {
		LOGGER.info("****LoggingAspectBefore.logBeforeDeleteDoctor() : " + joinPoint.getSignature().getName());
	}

	@Before("execution(* com.example.demo.service.DoctorServiceImpl.findBySpecialization(..))")
	public void logBeforeFindBySpecialization(JoinPoint joinPoint) {
		LOGGER.info("****LoggingAspectBefore.logBeforeFindBySpecialization() : " + joinPoint.getSignature().getName());
	}

	@Before("execution(* com.example.demo.service.DoctorServiceImpl.findById(..))")
	public void logBeforeFindById(JoinPoint joinPoint) {
		LOGGER.info("****LoggingAspectBefore.logBeforeFindById() : " + joinPoint.getSignature().getName());
	}
}
