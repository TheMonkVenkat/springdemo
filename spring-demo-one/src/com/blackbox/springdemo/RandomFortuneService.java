package com.blackbox.springdemo;

import java.util.Random;

public class RandomFortuneService implements FortuneService {
	
	private String[] fortunes = new String[] {"Today is a great day!","Today is an average day!","Today is a worst Day!"};
	
	private Random myRandom = new Random();

	@Override
	public String getFortune() {
		return fortunes[myRandom.nextInt(fortunes.length)];
	}

}
