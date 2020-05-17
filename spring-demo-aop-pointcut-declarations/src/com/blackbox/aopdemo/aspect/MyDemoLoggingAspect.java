package com.blackbox.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyDemoLoggingAspect {
	
	@Pointcut("execution(* com.blackbox.aopdemo.dao.*.*(..))")
	private void forDaoPackage() {};
	
	@Pointcut("execution(* com.blackbox.aopdemo.dao.*.get*(..))")
	private void getters(){};
	
	@Pointcut("execution(* com.blackbox.aopdemo.dao.*.set*(..))")
	private void setters(){};
	
	@Pointcut("forDaoPackage() && !(getters() || setters())")
	private void forPackageDaoWithNoSetget() {}
	
	
	//This is where we add all of our related advices for logging
	
	//Lets start with an @Before advice
	
//	@Before("execution(public void addAccount())")
//	@Before("execution(public void com.blackbox.aopdemo.dao.MembershipDAO.addAccount())")
//	@Before("execution(public void addAccount(com.blackbox.aopdemo.Account))")
//	@Before("execution(public void addAccount(com.blackbox.aopdemo.Account,..))")
//	@Before("execution(public void addAccount(..))")
//	@Before("forDaoPackage()")
	@Before("forPackageDaoWithNoSetget()")
	public void beforeAddAccount() {
		System.out.println("\n=======> Executing @Before advice on addAccount() ================================> \n");
	}

}
