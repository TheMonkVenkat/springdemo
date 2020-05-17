package com.blackbox.springdemo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Person {
	
	@Value("${name}")
	public String name;
	
	
	@Value("${age}")
	public int age;

}
