package com.blackbox.springdemo;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")
public class AnnotationScope {
	
	public String scopeName;
	
	public AnnotationScope() {
		this.scopeName = "";
	}
	
	@PostConstruct
	private void doStuffAfterInitiate() {
		System.out.println("I am crazy");
	}
	
	
	@PreDestroy
	protected void doStuffBeforeDestroy() {
		System.out.println("My crazy is gone");
	}

}
