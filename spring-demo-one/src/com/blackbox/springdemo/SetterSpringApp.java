package com.blackbox.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SetterSpringApp {

	public static void main(String[] args) {

		//Load the spring configuration file
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("applicationContext.xml");
		
		//retrieve bean from spring container
		CricketCoach theCoach = context.getBean("myCricketCoach", CricketCoach.class);
		
		//call the methods on bean
		System.out.println(theCoach.getDailyWorkout());
		
		System.out.println(theCoach.getFortuneService());
		
		System.out.println("Team: " + theCoach.getTeam());
		
		System.out.println("Email Address: " + theCoach.getEmailAddress());
		
		//close the context
		context.close();

	}

}
