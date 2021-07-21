package com.spring.springweb;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(LoggingAspect.class);
	
	@Before("execution(public * com.spring.springweb.controller.AlienController.getAliens())")
	public void logBefore() {
		LOGGER.info("getAliens() called");
	}
	
	@AfterReturning("execution(public * com.spring.springweb.controller.AlienController.getAliens())")
	public void logAfter() {
		LOGGER.info("getAliens() executed");
	}
	@After("execution(public * com.spring.springweb.controller.AlienController.getAliens())")
	public void logAfterReturning() {
		LOGGER.info("getAliens() executed");
	}	
	@AfterThrowing("execution(public * com.spring.springweb.controller.AlienController.getAliens())")
	public void logAfterThrowing() {
		LOGGER.info("getAliens() not executed");
	}
}
