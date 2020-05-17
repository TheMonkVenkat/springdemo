package com.blackbox.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.blackbox.aopdemo.dao.AccountDAO;
import com.blackbox.aopdemo.dao.MembershipDAO;
import com.blackbox.aopdemo.service.TrafficFortuneService;

public class AroundAspectDemoApp {

	public static void main(String[] args) {

		//Read Spring configuration java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		//Get the bean
		TrafficFortuneService trafficFortuneService = context.getBean("trafficFortuneService", TrafficFortuneService.class);
		
		System.out.println("Main Method: Calling GetFortune Service method \n");
		
		//Call the methods on the traffic service
		String fortune = trafficFortuneService.getFortuneService();
		
		System.out.println("\nMy Fortune: " + fortune);
		//close the context
		context.close();
	}

}
