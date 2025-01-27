package com.blackbox.springboot.thymeleafdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.blackbox.springboot.thymeleafdemo.dao.EmployeeDAO;
import com.blackbox.springboot.thymeleafdemo.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	private EmployeeDAO emplyeeDAO;
	
	@Autowired
	public EmployeeServiceImpl(EmployeeDAO theEmployeeRepository) {
		this.emplyeeDAO = theEmployeeRepository;
	}

	@Override
	@Transactional
	public List<Employee> findAll() {
		return this.emplyeeDAO.findAll();
	}

	@Override
	@Transactional
	public Employee findByID(int id) {
		return this.emplyeeDAO.findByID(id);
	}

	@Override
	@Transactional
	public void save(Employee theEmployee) {
		this.emplyeeDAO.save(theEmployee);
	}

	@Override
	@Transactional
	public void deleteById(int id) {
		this.emplyeeDAO.deleteById(id);
	}

}
