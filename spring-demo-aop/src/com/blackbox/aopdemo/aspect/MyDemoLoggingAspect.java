package com.blackbox.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyDemoLoggingAspect {
	
	//This is where we add all of our related advices for logging
	
	//Lets start with an @Before advice
	
//	@Before("execution(public void addAccount())")
//	@Before("execution(public void com.blackbox.aopdemo.dao.MembershipDAO.addAccount())")
//	@Before("execution(public void addAccount(com.blackbox.aopdemo.Account))")
//	@Before("execution(public void addAccount(com.blackbox.aopdemo.Account,..))")
	@Before("execution(public void addAccount(..))")
	public void beforeAddAccount() {
		System.out.println("\n=======> Executing @Before advice on addAccount() ================================> \n");
	}

}
