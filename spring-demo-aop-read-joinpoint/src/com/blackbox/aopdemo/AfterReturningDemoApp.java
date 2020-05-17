package com.blackbox.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.blackbox.aopdemo.dao.AccountDAO;
import com.blackbox.aopdemo.dao.MembershipDAO;

public class AfterReturningDemoApp {

	public static void main(String[] args) {

		//Read Spring configuration java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		//Get the  account dao bean
		AccountDAO accountDao = context.getBean("accountDAO", AccountDAO.class);
		
		System.out.println("\n Calling AccountDAO: findAccounts");
		accountDao.findAccounts();
		
		//close the context
		context.close();
	}

}
