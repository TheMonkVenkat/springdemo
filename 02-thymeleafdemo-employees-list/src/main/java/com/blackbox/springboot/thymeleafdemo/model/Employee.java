package com.blackbox.springboot.thymeleafdemo.model;

public class Employee {
	
	private String employeeNo;
	
	private String firstName;
	
	private String lastName;
	
	private String email;
	
	public Employee() {
		
	}

	public Employee(String employeeNo, String firstName, String lastName, String email) {
		super();
		this.employeeNo = employeeNo;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}

	public String getEmployeeNo() {
		return employeeNo;
	}

	public void setEmployeeNo(String employeeNo) {
		this.employeeNo = employeeNo;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Employee [employeeNo=" + employeeNo + ", firstName=" + firstName + ", lastName=" + lastName + ", email="
				+ email + "]";
	}
	
	

}
