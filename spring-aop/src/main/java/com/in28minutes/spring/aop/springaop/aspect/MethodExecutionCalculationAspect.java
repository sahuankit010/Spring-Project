package com.in28minutes.spring.aop.springaop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Configuration
@Aspect
public class MethodExecutionCalculationAspect {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Around("com.in28minutes.spring.aop.springaop.aspect.CommonJoinPoint.trackTimeAnnotation()")
	public void afterReturning(ProceedingJoinPoint joinPoint) throws Throwable {
		//x
		// process
		//y
		long startTime = System.currentTimeMillis();
		
		joinPoint.proceed();
		
		long timeTaken = System.currentTimeMillis() - startTime;
		logger.info("Time Taken by {} is {}" , joinPoint, timeTaken);

	}


}
