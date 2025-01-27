package com.blackbox.springboot.thymeleafdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
		
		return "employees/employee-list";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		
		Employee theEmployee = new Employee();
		
		theModel.addAttribute("employee", theEmployee);
		
		return "employees/employee-form";
	}
	
	@PostMapping("/save")
	public String addEmployee(@ModelAttribute("employee") Employee theEmployee) {
		
		this.theEmployeeService.save(theEmployee);
		
		return "redirect:/employees/list";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("employeeId") int employeeId, Model theModel) {
		
		Employee theEmployee = this.theEmployeeService.findByID(employeeId);
		
		theModel.addAttribute("employee", theEmployee);
		
		return "employees/employee-form";
	}
	
	@GetMapping("/delete")
	public String deleteEmpoloyee(@RequestParam("employeeId") int theId) {
		
		this.theEmployeeService.deleteById(theId);
		return "redirect:/employees/list";
	}

}
