package com.blackbox.springdemo;

public class MyApp {

	public static void main(String[] args) {

		//create an object
		Coach theCoach = new BoxingCoach(new GoodFortuneService());
		
		//use the object
		System.out.println(theCoach.getDailyWorkout());
	}

}
