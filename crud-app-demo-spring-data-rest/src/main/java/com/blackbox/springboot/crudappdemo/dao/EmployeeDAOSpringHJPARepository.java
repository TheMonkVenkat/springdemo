package com.blackbox.springboot.crudappdemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.blackbox.springboot.crudappdemo.entity.Employee;

@RepositoryRestResource(path="/slaves")
public interface EmployeeDAOSpringHJPARepository extends JpaRepository<Employee, Integer> {

}
