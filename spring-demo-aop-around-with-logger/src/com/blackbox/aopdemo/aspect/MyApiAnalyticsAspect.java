package com.blackbox.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(2)
public class MyApiAnalyticsAspect {

		
	
	@Before("com.blackbox.aopdemo.aspect.PointCutExpressions.forPackageDaoWithNoSetget()")
	public void logApiAnalytics() {
		System.out.println("\n ====================> Log API Analytics \n");
	}

}
