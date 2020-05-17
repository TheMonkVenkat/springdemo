package com.blackbox.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.blackbox.hibernate.demo.entity.Student;

public class QueryStudentDemo {

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
			
			//Query the students
			List<Student> theStudents = session.createQuery(" from Student").getResultList();
			
			//Display the students
			displayStudents(theStudents);
			
			//query Students: last name "alba"
			theStudents = session.createQuery("from Student s where s.lastName = 'Alba'").getResultList();
			
			displayStudents(theStudents);
			
			//query Students: last name "alba" or "moore"
			theStudents = session.createQuery("from Student s where s.lastName = 'Alba' or s.lastName = 'Moore' ").getResultList();
			
			displayStudents(theStudents);
			
			//query Students: email like '%blackbox.com'
			theStudents = session.createQuery("from Student s where s.email like '%blackbox.com' ").getResultList();
			
			displayStudents(theStudents);
			
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

	private static void displayStudents(List<Student> theStudents) {
		System.out.println("\n\n");
		for (Student student : theStudents) {
			System.out.println(student);
		}
	}

}
