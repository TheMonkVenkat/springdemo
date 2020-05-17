package com.blackbox.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.blackbox.hibernate.demo.entity.Instructor;
import com.blackbox.hibernate.demo.entity.InstructorDetail;

public class GetInstructoeDetailDemo {

	public static void main(String[] args) {

		//Create a session factory
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Instructor.class)
									.addAnnotatedClass(InstructorDetail.class)
									.buildSessionFactory();
		
		//create session
		Session session = factory.getCurrentSession();
		
		try {
			//start a transaction
			session.beginTransaction();
			
			//Get the Instructor by primary key id 2
			int theId = 3;
			InstructorDetail theInstructorDetail = session.get(InstructorDetail.class, theId);
			
			if(theInstructorDetail != null) {
				//Delete the Instructor details
				session.delete(theInstructorDetail);
				
				//Associcated instructor
				System.out.println("Associated Instructor: " + theInstructorDetail.getInstructor());
			}
			
			
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
