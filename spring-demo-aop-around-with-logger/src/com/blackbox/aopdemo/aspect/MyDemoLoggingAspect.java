package com.blackbox.aopdemo.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(1)
public class MyDemoLoggingAspect {
	
	private Logger myLogger = Logger.getLogger(MyDemoLoggingAspect.class.getName());
	
	@Before("com.blackbox.aopdemo.aspect.PointCutExpressions.forPackageDaoWithNoSetget()")
	public void beforeAddAccount(JoinPoint theJoinPoint) {
		myLogger.info("\n ====================> Log in log files \\n");
		
		MethodSignature signature = (MethodSignature)theJoinPoint.getSignature();
		
		myLogger.info("Method Signature: " + signature);
		
		Object[] args = theJoinPoint.getArgs();
		for (Object object : args) {
			myLogger.info("Param: " + object);
		}
	}
	
	@Around("execution(String com.blackbox.aopdemo.service.*.getFortuneService(..))")
	public Object aroundGetFortuneService(
				ProceedingJoinPoint theProceedingJoinPoint
			) throws Throwable {
		
		//Print out the method we are advicing on
		String method = theProceedingJoinPoint.getSignature().toShortString();
		myLogger.info("\n********* \t @Around advice for method: " + method + " \t ************");
		
		//get the begin timestamp
		long begin = System.currentTimeMillis();
		
		//Now, lets execute the method
		String result = (String) theProceedingJoinPoint.proceed();
		
		//Get the end timestamp, compute duration and dispaly it
		myLogger.info("\n The Elapsed Time: " + (System.currentTimeMillis() - begin)/1000.0 + " seconds");
		
		return result;
	}

}
