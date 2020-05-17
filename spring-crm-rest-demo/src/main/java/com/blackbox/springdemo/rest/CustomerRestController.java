package com.blackbox.springdemo.rest;

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

import com.blackbox.springdemo.entity.Customer;
import com.blackbox.springdemo.exceptions.CustomerNotFoundException;
import com.blackbox.springdemo.service.CustomerService;

@RestController
@RequestMapping("/api")
public class CustomerRestController {
	
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/customers")
	public List<Customer> getCustomers(){
		return this.customerService.getCustomers();
	}
	
	@GetMapping("/customers/{customerid}")
	public Customer getCustomer(@PathVariable int customerid){
		
		Customer customer = this.customerService.GetCustomer(customerid);
		
		if(customer == null)
			throw new CustomerNotFoundException("The Customer is not found for customer Id: " + customerid);
		
		return customer;
	}
	
	@PostMapping("/customers")
	public Customer createCustomer(@RequestBody Customer theCustomer) {
		
		theCustomer.setId(0);
		
		this.customerService.saveCustomer(theCustomer);
		
		return theCustomer;
	}
	
	@PutMapping("/customers")
	public Customer updateCustomer(@RequestBody Customer theCustomer) {
		
		this.customerService.saveCustomer(theCustomer);
		
		return theCustomer;
	}
	
	
	@DeleteMapping("/customers/{customerId}")
	public String deleteCustomer(@PathVariable int customerId) {
		
		Customer theCustomer = this.customerService.GetCustomer(customerId);
		if(theCustomer == null)
			throw new CustomerNotFoundException("The customer is not found: " + customerId);
		
		this.customerService.deleteCustomer(customerId);
		
		return "The Customer is deleted : "+ customerId;
	}

}
