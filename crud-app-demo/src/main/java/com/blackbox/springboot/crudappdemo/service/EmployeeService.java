package com.blackbox.springboot.crudappdemo.service;

import java.util.List;

import com.blackbox.springboot.crudappdemo.entity.Employee;

public interface EmployeeService {

	public List<Employee> findAll();
	
	public Employee findByID(int id);
	
	public void save(Employee theEmployee);
	
	public void deleteById(int id);
}
