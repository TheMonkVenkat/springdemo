package com.blackbox.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("myLovelyVolleyballCoach")
public class VolleyballCoach implements Coach {
	
	private FortuneService fortuneService;
	
	
	@Autowired
	@Qualifier("randomFortuneService")
	private FortuneService goodFortuneService;
	
	public VolleyballCoach() {
		System.out.println("Constructor - Volleyball Coach");
	}
	

	@Autowired
	@Qualifier("happyFortuneService")
	public void doSomeCrazyStuff(FortuneService fortuneService) {
		System.out.println("Autowired any method injection");
		this.fortuneService = fortuneService;
	}
	
	@Override
	public String getDailyWorkout() {
		return "Practice Jump for 15 min";
	}

	@Override
	public String getDailyFortune() {
		return this.fortuneService.getFortune();
	}
	

}
