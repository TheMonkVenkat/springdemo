package com.blackbox.springboot.thymeleafdemo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.blackbox.springboot.thymeleafdemo.entity.Employee;
import com.blackbox.springboot.thymeleafdemo.service.EmployeeService;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
	
	List<Employee> theEmployees;
	
	@Autowired
	private EmployeeService theEmployeeService;
	
	
	@GetMapping("/list")
	public String listEmployees(Model theModel){
		
		this.theEmployees = this.theEmployeeService.findAll();
		
		theModel.addAttribute("theEmployees", theEmployees);
		
		return "employee-list";
	}

}
