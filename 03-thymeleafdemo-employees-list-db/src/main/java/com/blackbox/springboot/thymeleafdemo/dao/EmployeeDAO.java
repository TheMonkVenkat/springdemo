package com.blackbox.springboot.thymeleafdemo.dao;

import java.util.List;

import com.blackbox.springboot.thymeleafdemo.entity.Employee;

public interface EmployeeDAO {
	
	public List<Employee> findAll();
	
	public Employee findByID(int id);
	
	public void save(Employee theEmployee);
	
	public void deleteById(int id);

}
