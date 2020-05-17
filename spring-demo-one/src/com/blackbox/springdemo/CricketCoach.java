package com.blackbox.springdemo;

public class CricketCoach implements Coach {
	
	private FortuneService fortuneService2;
	
	private String emailAddress;
	
	private String team;
	
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public void setTeam(String team) {
		this.team = team;
	}

	public void setFortuneService(FortuneService fortuneService) {
		System.out.println("Cricket Coach: Inside setter method - setter Fortune ");
		this.fortuneService2 = fortuneService;
	}

	@Override
	public String getDailyWorkout() {
		return "Practice Bat/Bowl for half an hour";
	}


	@Override
	public String getFortuneService() {
		return this.fortuneService2.getFortune();
	}
	
	public CricketCoach() {
		System.out.println("Cricket Coach: Inside Constructor");
	}
	
	public String getTeam() {
		return this.team;
	}
	
	public String getEmailAddress() {
		return this.emailAddress;
	}
	

}
