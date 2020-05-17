package com.blackbox.demo;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Task1 {

	public static void main(String[] args) throws IOException {
		
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		
		//Read the file name
		System.out.print("Enter file name >>  ");
		String filename = scanner.nextLine();
		
		if(!validateFile(filename)) {
			return;
		}
		
		//Read the airport code
		System.out.print("Enter airport code >>  ");
		String stateCode = scanner.nextLine();
		
		Airport airPortData = findAirportCode(filename, stateCode);
		
		if(airPortData != null) {
			System.out.println(airPortData);
		}
		else {
			System.out.println("No Airport was found with the code " + stateCode);
		}
		
	}

	private static boolean validateFile(String filename) throws IOException {

		File file = new File(filename);
		if(file.length() == 0) {
			System.out.println("\""+ filename +"\" is an empty file, program is closing");
			return false;
		}
		return true;
	}

	private static Airport findAirportCode(String fileName, String airCode) throws IOException {
		
		File file = new File(fileName);
		Scanner myReader = new Scanner(file);
		Airport airPortData = null;
		while (myReader.hasNextLine()) {
			String line = myReader.nextLine();
			String[] tokens = line.split("\\|");
			if(tokens[1].equals(airCode)) {
				airPortData = new Airport(tokens[1],tokens[0],tokens[3],tokens[2],tokens[4]);
				break;
			}
		}
		return airPortData;
	}

}

class Airport{
	
	private String code;
	
	private String country;
	
	private String state;
	
	private String city;
	
	private String name;
	

	public Airport() {
		
	}
	
	public Airport(String code, String country, String state, String city, String name) {
		this.code = code;
		this.country = country;
		this.state = state;
		this.city = city;
		this.name = name;
	}

	@Override
	public String toString() {
		return "Code = " + code + "\nCountry = " + country + "\nState = " + state + "\nCity = " + city + "\nAirport = "
				+ name + "\n";
	}
	
	
	
}
