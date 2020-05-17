package com.blackbox.springdemo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blackbox.springdemo.dao.CustomerDAO;
import com.blackbox.springdemo.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	//Need to inject Customer DAO
	@Autowired
	private CustomerDAO customerDAO;

	@Override
	@Transactional
	public List<Customer> getCustomers() {
		return this.customerDAO.getCustomers();
	}

	@Override
	@Transactional
	public void saveCustomer(Customer theCustomer) {
		this.customerDAO.saveCustomer(theCustomer);
		
	}

	@Override
	@Transactional
	public Customer GetCustomer(int customerId) {
		return this.customerDAO.getCustomer(customerId);
	}

	@Override
	@Transactional
	public void deleteCustomer(int customerId) {
		this.customerDAO.deleteCustomer(customerId);
		
	}

	@Override
	@Transactional
	public List<Customer> searchCustomers(String theSearchName) {
		return this.customerDAO.searchCustomers(theSearchName);
	}

}
