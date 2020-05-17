package com.blackbox.jackson.json.demo;

import java.io.File;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Driver {

	public static void main(String[] args) {

		try {
			
			//Create Object Mapper
			ObjectMapper objectMapper = new ObjectMapper();
			
			//Create JSON file and map/convert to Java POJO
			//data: sample-lite.json
			Student theStudent = objectMapper.readValue(new File("data/sample-full.json"), Student.class);
			
			//print first name, last name
			System.out.println(">>> First name: " + theStudent.getFirstName());
			System.out.println(">>> Last name: " + theStudent.getLastName());
			
			System.out.println(">>> Stree: " + theStudent.getAddress().getStreet());
			for (String string : theStudent.getLanguages()) {
				System.out.println(">>> languague: " + string );
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
