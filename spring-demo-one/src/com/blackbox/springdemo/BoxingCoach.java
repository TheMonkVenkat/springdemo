package com.blackbox.springdemo;

public class BoxingCoach implements Coach {
	
	private FortuneService fortunerService;
	
	public BoxingCoach(FortuneService theFortuneService) {
		this.fortunerService = theFortuneService;
	}

	@Override
	public String getDailyWorkout() {
		return "Spend 30 min boxing practice";
	}

	@Override
	public String getFortuneService() {
		return this.fortunerService.getFortune();
	}

}
