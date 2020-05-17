package com.blcakbox.mycoolapp.rest;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {
	
	@Value("${coach.name}")
	private String coachName;
	
	@Value("${coach.team}")
	private String coachTeam;
	
	
	@GetMapping("/")
	public String sayHello() {
		return "Hello "+ this.coachName +"("+ this.coachTeam + ")! The current server time is:  " + LocalDateTime.now();
	}
	
	@GetMapping("/hello")
	public String hello() {
		return "Hello !";
	}

}
