package com.blackbox.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationsPropertiesSpringDemo {

	public static void main(String[] args) {

		//Load the Spring config file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		//Get the bean from the container
		Person person = context.getBean("person", Person.class);
		
		//call the properties
		System.out.println("Name: " + person.name);
		
		System.out.println("Age: " + person.age);
		
		//close the context
		context.close();
	}

}
