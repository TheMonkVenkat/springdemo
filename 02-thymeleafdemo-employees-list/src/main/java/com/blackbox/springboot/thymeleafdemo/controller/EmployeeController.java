package com.blackbox.springboot.thymeleafdemo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.blackbox.springboot.thymeleafdemo.model.Employee;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
	
	List<Employee> theEmployees;
	
	@PostConstruct
	private void loadData() {
		
		theEmployees = new ArrayList<Employee>();
		
		Employee tempEmployee1 = new Employee("101", "Jennifer", "Lawrence", "jennifer.lawrence@mail.com");
		Employee tempEmployee2 = new Employee("102", "Alicia", "Vikander", "alicia.vikander@mail.com");
		Employee tempEmployee3 = new Employee("103", "Drew", "Barrymore", "drew.barrymore@mail.com");
		Employee tempEmployee4 = new Employee("104", "Demi", "Moore", "demi.moore@mail.com");
		
		theEmployees.add(tempEmployee1);
		theEmployees.add(tempEmployee2);
		theEmployees.add(tempEmployee3);
		theEmployees.add(tempEmployee4);
	}
	
	@GetMapping("/list")
	public String listEmployees(Model theModel){
		
		theModel.addAttribute("theEmployees", theEmployees);
		
		return "employee-list";
	}

}
