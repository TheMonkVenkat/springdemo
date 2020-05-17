package com.blackbox.springboot.crudappdemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.blackbox.springboot.crudappdemo.dao.EmployeeDAOSpringHJPARepository;
import com.blackbox.springboot.crudappdemo.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
//	@Autowired
//	@Qualifier("employeeDAOJPAImpl")
//	private EmployeeDAO emplyeeDAO;
	
	private EmployeeDAOSpringHJPARepository employeeRepository;
	
	@Autowired
	public EmployeeServiceImpl(EmployeeDAOSpringHJPARepository theEmployeeRepository) {
		this.employeeRepository = theEmployeeRepository;
	}

	@Override
//	@Transactional
	public List<Employee> findAll() {
//		return this.emplyeeDAO.findAll();
		return this.employeeRepository.findAll();
	}

	@Override
//	@Transactional
	public Employee findByID(int id) {
//		return this.emplyeeDAO.findByID(id);
		Optional<Employee> result = this.employeeRepository.findById(id);
		Employee theEmployee = null;
		if(result.isPresent()) {
			theEmployee =  result.get();
		}
		else {
			throw new RuntimeException("Didn't find the employee id - " + id);
		}
		return theEmployee;
	}

	@Override
//	@Transactional
	public void save(Employee theEmployee) {
//		this.emplyeeDAO.save(theEmployee);
		this.employeeRepository.save(theEmployee);
	}

	@Override
//	@Transactional
	public void deleteById(int id) {
//		this.emplyeeDAO.deleteById(id);
		this.employeeRepository.deleteById(id);
	}

}
