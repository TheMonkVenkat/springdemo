package com.blackbox.springdemo;

public class GoodFortuneService implements FortuneService {

	@Override
	public String getFortune() {
		return "Today is your lucky day!";
	}

}


