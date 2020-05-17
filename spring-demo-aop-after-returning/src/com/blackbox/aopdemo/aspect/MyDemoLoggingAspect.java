package com.blackbox.aopdemo.aspect;

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
	
	@Before("com.blackbox.aopdemo.aspect.PointCutExpressions.forPackageDaoWithNoSetget()")
	public void beforeAddAccount(JoinPoint theJoinPoint) {
		System.out.println("\n ====================> Log in log files \\n");
		
		MethodSignature signature = (MethodSignature)theJoinPoint.getSignature();
		
		System.out.println("Method Signature: " + signature);
		
		Object[] args = theJoinPoint.getArgs();
		for (Object object : args) {
			System.out.println("Param: " + object);
		}
	}

}
