package com.blackbox.springboot.crudappdemo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.blackbox.springboot.crudappdemo.entity.Employee;

@Repository
public class EmployeeDAOHibernateImpl implements EmployeeDAO {
	
	private EntityManager entityManager;
	
	//Set up constructor injection
	
	@Autowired
	public EmployeeDAOHibernateImpl(EntityManager theEntityManager) {
		this.entityManager = theEntityManager;
	}



	@Override
	public List<Employee> findAll() {

		//Get the current hibernate session
		Session theSession = this.entityManager.unwrap(Session.class);
		
		//Create the query
		Query<Employee> theQuery = theSession.createQuery("from  Employee", Employee.class);
		
		
		//Execute the query and get the results
		List<Employee> employees = theQuery.getResultList();
		
		//return resutls
		return employees;
	}



	@Override
	public Employee findByID(int id) {
		
		//Get the current Session
		Session theCurrentSession = this.entityManager.unwrap(Session.class);
		
		//Get the employee
		Employee theEmployee = theCurrentSession.get(Employee.class, id);
		
		//return the employee
		return theEmployee;
	}



	@Override
	public void save(Employee theEmployee) {
		
		//Get the current session
		Session theCurrentSession = this.entityManager.unwrap(Session.class);
		
		//save employee
		theCurrentSession.saveOrUpdate(theEmployee);
		
	}



	@Override
	public void deleteById(int id) {

		//Get the Current session
		Session theCurrentSession = this.entityManager.unwrap(Session.class);
		
//		//Get the employee
//		Employee theEmployee = theCurrentSession.get(Employee.class, id);
//		
//		//delete the Employee
//		theCurrentSession.delete(theEmployee);
		
		Query theQuery = theCurrentSession.createQuery(" delete from Employee where ID = :employeeId");
		theQuery.setParameter("employeeId", id);
		
		theQuery.executeUpdate();
		
	}

}
