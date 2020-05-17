package com.blackbox.aopdemo.aspect;

import org.aspectj.lang.annotation.Pointcut;

public class PointCutExpressions {
	
	@Pointcut("execution(* com.blackbox.aopdemo.dao.*.*(..))")
	public void forDaoPackage() {};
	
	@Pointcut("execution(* com.blackbox.aopdemo.dao.*.get*(..))")
	public void getters(){};
	
	@Pointcut("execution(* com.blackbox.aopdemo.dao.*.set*(..))")
	public void setters(){};
	
	@Pointcut("forDaoPackage() && !(getters() || setters())")
	public void forPackageDaoWithNoSetget() {}

}
