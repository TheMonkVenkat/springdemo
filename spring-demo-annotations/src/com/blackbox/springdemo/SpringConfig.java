package com.blackbox.springdemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
//@ComponentScan("com.blackbox.springdemo")
@PropertySource("classpath:random.properties")
public class SpringConfig {
	
	//Define bean for Happy Fortune Service
	@Bean
	public FortuneService happyFortuneService() {
		return  new HappyFortuneService();
	}
	
	
	//Define Bean for our swim coach and inject dependencies
	@Bean
	public Coach swimCoach() {
		return new SwimCoach(happyFortuneService());
	}

}
