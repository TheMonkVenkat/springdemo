package com.blackbox.springdemo.datatypes;

import java.util.LinkedHashMap;
import java.util.List;

public class Student {
	
	private String firstName;
	
	private String lastName;
	
	private String country;
	
	private String favoriteLanguage;
	
	private List<String> operatingSystems;
	
	private LinkedHashMap<String, String> countryOptions;
	
	private LinkedHashMap<String, String> favoriteLanguageOptions;
	
	public Student() {
		
		//initializa country options
		this.countryOptions = new LinkedHashMap<>();
		this.countryOptions.put("IN", "India");
		this.countryOptions.put("US", "United States Of America");
		this.countryOptions.put("FR", "France");
		this.countryOptions.put("EN", "England");
		this.countryOptions.put("NW", "Newzealand");
		this.countryOptions.put("AU", "Australia");
		
		this.favoriteLanguageOptions = new LinkedHashMap<>();
		this.favoriteLanguageOptions.put("Java", "Java");
		this.favoriteLanguageOptions.put("C#", "C#");
		this.favoriteLanguageOptions.put("AI", "AI");
		this.favoriteLanguageOptions.put("Python", "Python");
		this.favoriteLanguageOptions.put("Ruby", "Ruby");
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

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public LinkedHashMap<String, String> getCountryOptions() {
		return countryOptions;
	}

	public String getFavoriteLanguage() {
		return favoriteLanguage;
	}

	public void setFavoriteLanguage(String favoriteLanguage) {
		this.favoriteLanguage = favoriteLanguage;
	}

	public LinkedHashMap<String, String> getFavoriteLanguageOptions() {
		return favoriteLanguageOptions;
	}

	public List<String> getOperatingSystems() {
		return operatingSystems;
	}

	public void setOperatingSystems(List<String> operatingSystems) {
		this.operatingSystems = operatingSystems;
	}

	
	

}
