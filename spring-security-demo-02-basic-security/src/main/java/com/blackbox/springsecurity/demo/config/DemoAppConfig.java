package com.blackbox.springsecurity.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/***
 * @EnableWebMvc enables <!-- Add support for conversion, formatting and validation support -->
	<mvc:annotation-driven />
 *
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages="com.blackbox.springsecurity.demo")
public class DemoAppConfig {

	
	//define a bean for ViewResolver
	
	/**
	 * 
	 * <bean class="org.springframework.web.servlet.view.InternalResourceViewResolver">
			<property name="prefix" value="/WEB-INF/view/" />
			<property name="suffix" value=".jsp" />
		</bean>
	 * @return
	 */
	
	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/view/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}
	
}
