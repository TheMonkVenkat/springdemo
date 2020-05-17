package com.blcakbox.mycoolapp.rest;

import java.time.LocalDateTime;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {
	
	
	@GetMapping("/")
	public String sayHello() {
		return "Hello World! The current server time is:  " + LocalDateTime.now();
	}
	
	@GetMapping("/hello")
	public String hello() {
		return "Hello !";
	}

}
