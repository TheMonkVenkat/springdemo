package com.blackbox.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.blackbox.aopdemo.dao.AccountDAO;
import com.blackbox.aopdemo.dao.MembershipDAO;

public class MainDemoApp {

	public static void main(String[] args) {

		//Read Spring configuration java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		//Get the bean
		AccountDAO accountDao = context.getBean("accountDAO", AccountDAO.class);
		
		//Get the membership dao frm context
		MembershipDAO memebershipDao = context.getBean("membershipDAO", MembershipDAO.class);
		
		//use the methods on the bean
		accountDao.addAccount(new Account(1000,13453423),1000);
		
		System.out.println("\n	let call membership::addAccount\n");
		
		memebershipDao.addAccount();
		
		//close the context
		context.close();
	}

}
