package com.blackbox.aopdemo.service;

import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Service;

@Service
public class TrafficFortuneService {
	
	public String getFortuneService() {
		
		//Simulate a delay
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "Expect Heavy Traffic this evening !";
	}

	public String getFortuneService(boolean tripWire) {
		if(!tripWire) {
			throw new RuntimeException("Major accident! Highway is closed... ");
		}
		return getFortuneService();
	}

}
