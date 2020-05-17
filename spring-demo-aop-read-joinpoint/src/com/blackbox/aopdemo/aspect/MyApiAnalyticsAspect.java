package com.blackbox.aopdemo.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.blackbox.aopdemo.Account;

@Component
@Aspect
@Order(2)
public class MyApiAnalyticsAspect {

		
	
	@Before("com.blackbox.aopdemo.aspect.PointCutExpressions.forPackageDaoWithNoSetget()")
	public void logApiAnalytics() {
		System.out.println("\n ====================> Log API Analytics \n");
	}
	
	
	@AfterReturning(pointcut="execution(* findAccounts(..))", returning="result")
	public void afterReturningFindResults(JoinPoint theJointpoint, List<Account> result) {
		System.out.println("==============> After returning ");
		for (Account account : result) {
			System.out.println(account);
		}
	}
	

}
