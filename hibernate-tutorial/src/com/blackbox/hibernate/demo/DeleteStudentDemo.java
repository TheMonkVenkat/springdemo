package com.blackbox.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.blackbox.hibernate.demo.entity.Student;

public class DeleteStudentDemo {

	public static void main(String[] args) {

		//Create a session factory
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Student.class)
									.buildSessionFactory();
		
		//create session
		Session session = factory.getCurrentSession();
		
		try {
			
			//start a transaction
			session.beginTransaction();
			
			//Retrieve the Student having ID 1
			int studentId = 1;
			
			Student theStudent = session.get(Student.class, studentId);
			if(theStudent != null) {
				System.out.println("Student ID 1 details: " + theStudent);
				System.out.println("Updating the student...");
				theStudent.setFirstName("Angelina");
				theStudent.setLastName("Jolie");
				theStudent.setEmail("angelina@gmail.com");
			}
			
			//commit the transaction
			session.getTransaction().commit();
			
			System.out.println("Student ID 1 details: " + theStudent);
			
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			//Update Email for all students
			session.createQuery("Update Student set email = 'blackbox@gmail.com'")
					.executeUpdate();
			
			session.getTransaction().commit();
			
			
			System.out.println("\n\nDone!!!");
			
			session.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			factory.close();
		}
	}

}
