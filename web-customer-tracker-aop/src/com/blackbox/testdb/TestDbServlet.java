package com.blackbox.testdb;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestDbServlet
 */
@WebServlet("/TestDbServlet")
public class TestDbServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//setup connection variables
		
		String username ="sa";
		String password ="123";
		
		String jdbcUrl = "jdbc:sqlserver://localhost:1433;database=Hibernate";
		String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
		
		try {
			PrintWriter out = response.getWriter();
			out.println("Connecting to database: " + jdbcUrl);
						
			Class.forName(driver);
			
			Connection myConnection = DriverManager.getConnection(jdbcUrl, username, password);
			out.println("Successfully Connected!");
			myConnection.close();
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
	
	
	
	
	}

}
