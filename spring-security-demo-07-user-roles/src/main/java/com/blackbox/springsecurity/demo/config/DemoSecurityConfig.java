package com.blackbox.springsecurity.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;

@Configuration
@EnableWebSecurity
public class DemoSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		//Add our users for in memory authentication
		UserBuilder users = User.withDefaultPasswordEncoder();
		
		auth.inMemoryAuthentication()
				.withUser(users.username("jarvis").password("123").roles("EMPLOYEE","ADMIN"))
				.withUser(users.username("ironman").password("123").roles("EMPLOYEE","MANAGER"))
				.withUser(users.username("potts").password("123").roles("EMPLOYEE"));
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.authorizeRequests()
		        .antMatchers("/").hasRole("EMPLOYEE")
		        .antMatchers("/leaders/**").hasRole("MANAGER")
		        .antMatchers("/systems/**").hasRole("ADMIN")
			.and()
			.formLogin()
				.loginPage("/showMyLoginPage")
				.loginProcessingUrl("/authenticateUser")
				.permitAll()
			.and()
			.logout()
				.permitAll()
			.and()
			.exceptionHandling()
				.accessDeniedPage("/access-denied");
	}
	
	
	
	

	
}
