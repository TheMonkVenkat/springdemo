package com.blackbox.springsecurity.demo.config;

import java.beans.PropertyVetoException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.sun.istack.logging.Logger;

/***
 * @EnableWebMvc enables <!-- Add support for conversion, formatting and validation support -->
	<mvc:annotation-driven />
 *
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages="com.blackbox.springsecurity.demo")
@PropertySource("classpath:persistence-sqlserver.properties")
public class DemoAppConfig {
	
	//Set up a variable to hold the properties
	
	@Autowired
	private Environment env;
	
	//Set up a logger for daignostics
	private Logger logger = Logger.getLogger(DemoAppConfig.class);
	
	

	
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
	
	
	//define a bean for Security bean source
	@Bean
	public DataSource securityDataSource() {
		
		//create a connection pool
		ComboPooledDataSource secuirtyDataSource 
									= new ComboPooledDataSource();
		
		
		//set the Jdbc driver class
		try {
			secuirtyDataSource.setDriverClass(env.getProperty("jdbc.driver"));
		} catch (PropertyVetoException e) {
			throw new RuntimeException(e);
		}
		
		//log the connection props
		logger.info("\n>>>>>> jdbc:url =  " + env.getProperty("jdbc.url"));
		logger.info("\n>>>>>> jdbc:user " + env.getProperty("jdbc.user"));
		
		//set the database connection props
		
		secuirtyDataSource.setJdbcUrl(env.getProperty("jdbc.url"));
		secuirtyDataSource.setUser(env.getProperty("jdbc.user"));
		secuirtyDataSource.setPassword(env.getProperty("jdbc.password"));
		
		//set the connection pool props
		secuirtyDataSource
				.setInitialPoolSize(Integer.parseInt(env.getProperty("connection.pool.intialPoolSize")));
		secuirtyDataSource
				.setMinPoolSize(Integer.parseInt(env.getProperty("connection.pool.minPoolSize")));
		secuirtyDataSource
				.setMaxPoolSize(Integer.parseInt(env.getProperty("connection.pool.maxPoolSize")));
		secuirtyDataSource
				.setMaxIdleTime(Integer.parseInt(env.getProperty("connection.pool.maxIdleTime")));
		
		
		return secuirtyDataSource;
	}
	
}
