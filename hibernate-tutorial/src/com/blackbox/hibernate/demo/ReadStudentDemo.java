package com.blackbox.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.blackbox.hibernate.demo.entity.Student;

public class ReadStudentDemo {

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
			Student theStudent = new Student("Disha", "Patani","disha.patani@blackbox.com");
			
			//start a transaction
			session.beginTransaction();

			//Save the Student object
			System.out.println("Saving the student object...");
			System.out.println(theStudent);
			session.save(theStudent);
			
			//commit the transaction
			session.getTransaction().commit();
			
			System.out.println("Saved Student ID: " + theStudent.getId());
			
			//Now get the session & start transaction
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			//retrieve the student based on ID: primary key
			System.out.println("Getting the Student with ID: " + theStudent.getId());
			Student myStudent = session.get(Student.class, theStudent.getId());
			
			System.out.println("Get Complete: " + myStudent);
			
			//Commit the transaction
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
