package com.blackbox.springdemo.service;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.blackbox.springdemo.model.Customer;

@Service
public class CustomerServiceRestClientImpl implements CustomerService {

	private RestTemplate restTemplate;
	private String crmRestUrl;
	private Logger logger = Logger.getLogger(getClass().getName());

	@Autowired
	public CustomerServiceRestClientImpl(RestTemplate theRestTemplate, @Value("${crm.rest.url}") String theUrl) {
		restTemplate = theRestTemplate;
		crmRestUrl = theUrl;
		logger.info("Loaded property: crm.rest.url=" + crmRestUrl);
	}

	@Override
	public List<Customer> getCustomers() {
		logger.info("in getCustomers(): Calling REST API " + crmRestUrl);
		
		//Make rest call
		
		ResponseEntity<List<Customer>> response 
							= this.restTemplate.exchange(crmRestUrl, HttpMethod.GET
														, null, new ParameterizedTypeReference<List<Customer>>() {});
		
		//Get the list of customers from the response
		List<Customer> theCustomers = response.getBody();

		return theCustomers;
	}

	@Override
	public void saveCustomer(Customer theCustomer) {
		logger.info("in saveCustomer(): Calling REST API " + crmRestUrl);
		
		int customerId = theCustomer.getId();
		
		if(customerId == 0) {
			this.restTemplate.postForEntity(crmRestUrl, theCustomer, String.class);
		}else {
			this.restTemplate.put(crmRestUrl, theCustomer);
		}
		
		logger.info("in saveCustomer(): theCustomer=" + theCustomer);

	}

	@Override
	public Customer GetCustomer(int customerId) {
		logger.info("in getCustomer(): Calling REST API " + crmRestUrl);
		// make REST call
		Customer theCustomer = restTemplate.getForObject(crmRestUrl + "/" + customerId, Customer.class);
		logger.info("in getCustomer(): theCustomer=" + theCustomer);
		return theCustomer;
	}

	@Override
	public void deleteCustomer(int customerId) {
		logger.info("in deleteCustomer(): Calling REST API " + crmRestUrl);
		
		this.restTemplate.delete(this.crmRestUrl+"/"+ customerId);

	}

}
