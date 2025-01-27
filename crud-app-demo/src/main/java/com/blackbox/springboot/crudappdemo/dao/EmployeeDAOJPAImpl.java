package com.blackbox.springboot.crudappdemo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.blackbox.springboot.crudappdemo.entity.Employee;

@Repository
public class EmployeeDAOJPAImpl implements EmployeeDAO {
	
	private EntityManager entityManager;
	
	@Autowired
	public EmployeeDAOJPAImpl(EntityManager theEntityManager) {
		this.entityManager = theEntityManager;
	}

	@Override
	public List<Employee> findAll() {

		//Create a query
		TypedQuery<Employee> theQuery = this.entityManager.createQuery("FROM Employee", Employee.class);
		
		List<Employee> theEmployees = theQuery.getResultList();
		
		return theEmployees;
	}

	@Override
	public Employee findByID(int id) {

		Employee theEmployee = this.entityManager.find(Employee.class, id);
		if(theEmployee == null) {
			throw new RuntimeException("Employee Id is not found. ID - " + id);
		}

		return theEmployee;
	}

	@Override
	public void save(Employee theEmployee) {
		Employee updatedEmployee = this.entityManager.merge(theEmployee);
		theEmployee.setID(updatedEmployee.getID());

	}

	@Override
	public void deleteById(int id) {
		//this.entityManager.remove(id);
		Query theQuery = this.entityManager.createQuery("DELETE FROM Employee where ID=:employeeId");
		
		theQuery.setParameter("employeeId", id);
		
		theQuery.executeUpdate();

	}

}
