package com.blackbox.springdemo.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.blackbox.springdemo.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {
	
	//Need to inject the session factory
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Customer> getCustomers() {

		//Get the session
		Session theSession = sessionFactory.getCurrentSession();
		
		//Create a query to get all the customers
		Query<Customer> theQuery = 
				theSession.createQuery("From Customer order by firstName", Customer.class);
		
		//execute query and get the results list
		List<Customer> theCustomers = theQuery.getResultList();
		
		//return the results
		return theCustomers;
	}

	@Override
	public void saveCustomer(Customer theCustomer) {
		//Get the session
		Session session = sessionFactory.getCurrentSession();
		
		//Save/update the Customer
		session.saveOrUpdate(theCustomer);
		
	}

	@Override
	public Customer getCustomer(int customerId) {

		//Get the current hibernate session
		Session session = this.sessionFactory.getCurrentSession();
		
		//Get the customer object by id
		return session.get(Customer.class, customerId);
	}

	@Override
	public void deleteCustomer(int customerId) {


		//Get the current hibernate session
		Session session = this.sessionFactory.getCurrentSession();
		
		//Delete object with primary key
		Query theQuery = session.createQuery("delete from Customer where id = :customerId");
		theQuery.setParameter("customerId", customerId);
		
		theQuery.executeUpdate();
		
//		//Get the customer based on primary key
//		Customer theCustomer = session.get(Customer.class, customerId);
//		
//		//Delete the customer
//		session.delete(theCustomer);
		
	}

	@Override
	public List<Customer> searchCustomers(String theSearchName) {
		
		//Get the current hibernate session
		Session session = this.sessionFactory.getCurrentSession();
		Query<Customer> theQuery = null;
		if(theSearchName != null && theSearchName != "") {
			theQuery = session.createQuery("from Customer where lower(firstName) like :theName or lower(lastName) like :theName", Customer.class);
			theQuery.setParameter("theName", theSearchName);
		}
		else {
			theQuery = session.createQuery("from Customer", Customer.class);
		}
		
		List<Customer> matchedCustomers = theQuery.getResultList();
		return matchedCustomers;
	}

}
