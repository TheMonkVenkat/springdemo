package com.blackbox.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJDBC {

	public static void main(String[] args) {
		
		String jdbcUrl = "jdbc:sqlserver://localhost:1433;databaseName=Hibernate";
		String username = "sa";
		String password = "123";

		try {
			System.out.println("Connecting to database: " + jdbcUrl);
			Connection conn = DriverManager.getConnection(jdbcUrl, username, password);
			System.out.println("Connection successful");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
