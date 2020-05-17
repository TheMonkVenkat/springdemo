package com.blackbox.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationScopeSpringDemo {

	public static void main(String[] args) {

		//Load spring config file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		//Get the bean from the context
		AnnotationScope scope1 = context.getBean("annotationScope", AnnotationScope.class);
		
		System.out.println(scope1);
		
		AnnotationScope scope2 = context.getBean("annotationScope", AnnotationScope.class);
		
		System.out.println(scope2);
		
		System.out.println("Is Equal: " + (scope1 == scope2));
		
		//close the context
		context.close();
		
		
		
		
	}

}
