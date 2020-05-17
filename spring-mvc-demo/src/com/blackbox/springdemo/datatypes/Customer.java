package com.blackbox.springdemo.datatypes;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.blackbox.springdemo.mvc.annotation.MultiCourseCode;

public class Customer {
	
	private String firstName;
	
	@NotNull(message="is Required")
	@Size(min=1, message="is Required")
	private String lastName;
	
	@NotNull(message="is Required")
	@Min(value=0, message="Must be greater than or equal to zero")
	@Max(value=10, message="Must be less than or equal to 10")
	private Integer freePasses = 0;
	
	
	@Pattern(regexp="^[a-zA-z0-9]{6}", message="Only allow 6 chars/digits")
	private String postalCode;
	
	@NotNull(message="is Required")
	@MultiCourseCode(value= {"TOPS", "COUR"}, message="Must starts with TOPS or COUR")
	private String courseCode;

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

	public Integer getFreePasses() {
		return freePasses;
	}

	public void setFreePasses(Integer freePasses) {
		this.freePasses = freePasses;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getCourseCode() {
		return courseCode;
	}

	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}
	
	
	

}
