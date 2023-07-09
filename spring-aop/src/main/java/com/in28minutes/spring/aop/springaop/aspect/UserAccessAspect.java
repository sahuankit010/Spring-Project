package com.in28minutes.spring.aop.springaop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Configuration
@Aspect
public class UserAccessAspect {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
		
	@Before("com.in28minutes.spring.aop.springaop.aspect.CommonJoinPoint.dataLayerExecution()")
	public void after(JoinPoint joinPoint) {
		logger.info("allow execution for {}" , joinPoint);

	}

}
