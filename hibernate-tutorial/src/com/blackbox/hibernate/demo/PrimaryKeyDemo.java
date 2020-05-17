package com.blackbox.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.blackbox.hibernate.demo.entity.Student;

public class PrimaryKeyDemo {

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
					System.out.println("Creating 3 student objects...");
					Student theStudent1 = new Student("Alicia", "Vikander","alicia.vikander@blackbox.com");
					Student theStudent2 = new Student("Demo", "Moore","demo.moore@blackbox.com");
					Student theStudent3 = new Student("Drew", "Barrymore","drew.barrymore@blackbox.com");
					
					//start a transaction
					session.beginTransaction();
					
					//Save the Student object
					System.out.println("Saving the student object...");
					session.save(theStudent1);
					session.save(theStudent2);
					session.save(theStudent3);
					
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
