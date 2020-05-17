package com.blackbox.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanScopeDempApp {

	public static void main(String[] args) {

		//Load the spring configuration file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beanScope-applicationContext.xml");
		
		//retrieve bean from the container
		BaseballCoach theCoach = context.getBean("myCoach", BaseballCoach.class);
		
		System.out.println(theCoach);
		
		System.out.println("The Coach service cost: " + theCoach.getServiceCost());
		
		//set the service cost to $1000
		
		theCoach.setServiceCost(1000);
		
		System.out.println("The Coach service cost: " + theCoach.getServiceCost());
		
		BaseballCoach theNewCoach = context.getBean("myCoach", BaseballCoach.class);
		
		System.out.println(theNewCoach);
		
		System.out.println("The New Coach service cost: " + theNewCoach.getServiceCost());
		
		System.out.println("These two objects are equal ? Ans: " + theCoach.equals(theNewCoach));
		
		//Call the methods on the bean
		System.out.println(theCoach.getDailyWorkout());
		
		//close the bean
		context.close();
	}

}
