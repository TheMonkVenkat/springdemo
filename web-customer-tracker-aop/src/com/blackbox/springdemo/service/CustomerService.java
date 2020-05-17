package com.blackbox.springdemo.service;

import java.util.List;

import com.blackbox.springdemo.entity.Customer;

public interface CustomerService {

	public List<Customer> getCustomers();

	public void saveCustomer(Customer theCustomer);

	public Customer GetCustomer(int customerId);

	public void deleteCustomer(int customerId);

	public List<Customer> searchCustomers(String theSearchName);
}

