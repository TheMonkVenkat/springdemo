package com.blackbox.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.blackbox.hibernate.demo.entity.Student;
import com.blackbox.hibernate.util.DateUtil;

public class CreateStudentDemo {

	public static void main(String[] args) {

		//Create a session factory
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Student.class)
									.buildSessionFactory();
		
		//create session
		Session session = factory.getCurrentSession();
		
		try {
			
			//Create a Student object
			System.out.println("Creating the student object...");
			Student theStudent = new Student("Venkat", "Ramana","ifixprograms@blackbox.com");
			theStudent.setDateOfBirth(DateUtil.parseDate("01/09/1990"));
			
			//start a transaction
			session.beginTransaction();
			
			//Save the Student object
			System.out.println("Saving the student object...");
			session.save(theStudent);
			
			//commit the transaction
			session.getTransaction().commit();
			
			System.out.println("Done!!!");
			
			session.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			factory.close();
		}
	}

}
