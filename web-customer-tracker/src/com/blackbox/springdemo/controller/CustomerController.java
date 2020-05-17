package com.blackbox.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.blackbox.springdemo.entity.Customer;
import com.blackbox.springdemo.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	
	//Need to inject the Customer Service
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/list")
	public String listCustomers(Model theModel) {
		
		//Get the customers from the Service
		List<Customer> theCustomers =  customerService.getCustomers();
		
		//Add the customers to the model
		theModel.addAttribute("customers", theCustomers);
		
		return "list-customers";
	}
	
	@GetMapping("/showFormForAdd")
	public String showCustomerForm(Model model) {
		
		//Add the model attribute  to bind form data
		Customer theCustomer = new Customer();
		
		model.addAttribute("customer", theCustomer);
		
		return "customer-form";
	}
	
	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer theCustomer, Model theModel) {
		
		//Save the customer using Customer service
		customerService.saveCustomer(theCustomer);
		
		return "redirect:/customer/list";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("customerId") int customerId
									,Model theModel) {
		
		//Get the customer from the database
		Customer theCustomer = this.customerService.GetCustomer(customerId);
		
		//Set customer asa model attribute to pre-populate the form
		theModel.addAttribute("customer", theCustomer);
		
		//send over to the form
		
		return "customer-form";
		
	}
	
	@GetMapping("/delete")
	public String deleteCustomer(@RequestParam("customerId") int customerId, Model theModel) {
		
		//Delete the customer 
		this.customerService.deleteCustomer(customerId);
		
		return "redirect:/customer/list";
	}
	
	
	@GetMapping("search")
	public String searchCustomers(@RequestParam("theSearchName") String theSearchName, Model theModel) {
		
		List<Customer> theCustomers = this.customerService.searchCustomers(theSearchName);
		
		theModel.addAttribute("customers", theCustomers);
		
		return "list-customers";
	}

}
