package com.blackbox.springboot.crudappdemo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blackbox.springboot.crudappdemo.entity.Employee;
import com.blackbox.springboot.crudappdemo.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
	
	private EmployeeService employeeService;
	
	//Inject Employee dao
	@Autowired
	public EmployeeRestController(EmployeeService theEmployeeService) {
		this.employeeService = theEmployeeService;
	}
	
	//expose "/employees" and return list of employees
	@GetMapping("/employees")
	public List<Employee> finaAll(){
		return this.employeeService.findAll();
	}
	
	@GetMapping("/employees/{employeeId}")
	public Employee findByID(@PathVariable("employeeId") int id) {
		Employee theEmployee = this.employeeService.findByID(id);
		if(theEmployee == null) {
			throw new RuntimeException("Employee id is not found - " + id);
		}
	
		return theEmployee;
	}
	
	@PostMapping("/employees")
	public Employee addEmployee(@RequestBody Employee theEmployee) {
		theEmployee.setID(0);
		
		this.employeeService.save(theEmployee);
		
		return theEmployee;
	}
	
	@PutMapping("/employees")
	public Employee updateEmployee(@RequestBody Employee theEmployee) {
		this.employeeService.save(theEmployee);
		return theEmployee;
	}
	
	@DeleteMapping("/employees/{employeeId}")
	public String deleteEmployee(@PathVariable("employeeId") int theId) {
		this.employeeService.deleteById(theId);
		return "Deleted employee id: " + theId;
	}

}
