package com.blackbox.aopdemo;

import java.util.logging.Logger;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.blackbox.aopdemo.service.TrafficFortuneService;

public class AroundAspectWithLoggerDemoApp {
	
	private static Logger myLogger = Logger.getLogger(AroundAspectWithLoggerDemoApp.class.getName());

	public static void main(String[] args) {
		
		//Read Spring configuration java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		//Get the bean
		TrafficFortuneService trafficFortuneService = context.getBean("trafficFortuneService", TrafficFortuneService.class);
		
		myLogger.info("Main Method: Calling GetFortune Service method \n");
		
		//Call the methods on the traffic service
		String fortune = trafficFortuneService.getFortuneService();
		
		myLogger.info("\nMy Fortune: " + fortune);
		//close the context
		context.close();
	}

}
