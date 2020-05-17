package com.blackbox.springdemo.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CRMLoggingAspect {
	
	//set up logger
	private Logger crmLogger = Logger.getLogger(com.blackbox.springdemo.aspect.CRMLoggingAspect.class.getName());
	
	//Set up Pointcut declarations
	@Pointcut("execution(* com.blackbox.springdemo.controller.*.*(..))")
	public void forControllerPackage() {}
	
	@Pointcut("execution(* com.blackbox.springdemo.service.*.*(..))")
	public void forServicePackage() {}
	
	@Pointcut("execution(* com.blackbox.springdemo.dao.*.*(..))")
	public void forDAOPackage() {}
	
	@Pointcut("forControllerPackage() || forServicePackage() || forDAOPackage()")
	public void forAppFlow() {};
	
	
	//Add @Before advice
	
	@Before("forAppFlow()")
	public void before(JoinPoint theJoinPoint) {
		
		//Display the method we are calling
		MethodSignature methodSignature = (MethodSignature) theJoinPoint.getSignature();
		crmLogger.info("\n ********** @Before:: Calling the method" + methodSignature);
		
		//Display the arguments to the method
		Object[] args = theJoinPoint.getArgs();
		
		//Loop through and display the arguments
		for (Object object : args) {
			crmLogger.info("\n **************** Argument: " + object);
		}
		
	}
	
	//Add @AfterReturning advice
	
	@AfterReturning(
				pointcut="forAppFlow()",
				returning="theResult"
			)
	public void afterReturn(JoinPoint theJoinPoint, Object theResult) {
		
		//Display the method we are calling
		MethodSignature methodSignature = (MethodSignature) theJoinPoint.getSignature();
		crmLogger.info("\n ********** in @AfterReturning:: from the method" + methodSignature);
		
		crmLogger.info("\n ********** The Result: " + theResult);
	}
}
