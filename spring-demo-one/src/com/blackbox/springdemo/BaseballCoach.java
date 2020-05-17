package com.blackbox.springdemo;

import org.springframework.beans.factory.DisposableBean;

public class BaseballCoach implements Coach,DisposableBean {
	
	private FortuneService fortuneService;
	
	private int serviceCost;
	
	public void setServiceCost(int serviceCost) {
		this.serviceCost = serviceCost;
	}
	
	public int getServiceCost() {
		return this.serviceCost;
	}
	
	public BaseballCoach(FortuneService fortuneService) {
		System.out.println("BaseballCoach: Constructor");
		this.fortuneService = fortuneService;
	}
	
	public String getDailyWorkout() {
		return "Spend 30 min batting practice";
	}

	@Override
	public String getFortuneService() {
		return this.fortuneService.getFortune();
	}
	
	public void doMyPublicStartupStuff() {
		System.out.println("Public: Init-method BaseballCoach");
	}
	
	public void doMyPublicCleanupStuff() {
		System.out.println("Public: Destory-method Baseball Coach");
	}
	
	private void doMyPrivateStartupStuff() {
		System.out.println("Private: Init-method BaseballCoach");
	}
	
	private void doMyPrivateCleanupStuff() {
		System.out.println("Private: Destory-method Baseball Coach");
	}
	
	protected void doMyProtectedStartupStuff() {
		System.out.println("Protected: Init-method BaseballCoach");
	}
	
	protected void doMyProtectedCleanupStuff() {
		System.out.println("Protected: Destory-method Baseball Coach");
	}
	
	@Override
	public void destroy() throws Exception {
		System.out.println("BaseballCoach: Destory-method scope prototype doMyCleanupStuffYoYo");		
	}

}
