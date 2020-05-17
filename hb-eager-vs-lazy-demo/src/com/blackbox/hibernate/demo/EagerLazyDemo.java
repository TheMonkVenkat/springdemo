package com.blackbox.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.blackbox.hibernate.demo.entity.Course;
import com.blackbox.hibernate.demo.entity.Instructor;
import com.blackbox.hibernate.demo.entity.InstructorDetail;

public class EagerLazyDemo {

	public static void main(String[] args) {

		//Create a session factory
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Instructor.class)
									.addAnnotatedClass(InstructorDetail.class)
									.addAnnotatedClass(Course.class)
									.buildSessionFactory();
		
		//create session
		Session session = factory.getCurrentSession();
		
		try {
			//start a transaction
			session.beginTransaction();
			
			//Get the Instructor by primary key id 2
			int theId = 1;
			Instructor theInstructor = session.get(Instructor.class, theId);
			
			if(theInstructor != null) {
				//print the course
				System.out.println("BlackBox: the Instructor: "+ theInstructor);
				
			}

			//Call getter method before session close
			System.out.println("BlackBox: Associated Courses: " + theInstructor.getCourseList());
			
			//commit the transaction
			session.getTransaction().commit();
			
			//close the session
			session.close();
			
			System.out.println("\n Now session is closed \n\n");
			
			//Get the courses of the instructor
			System.out.println("BlackBox: Associated Courses: " + theInstructor.getCourseList());
			
			System.out.println("Done!!!");
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
			
			factory.close();
		}
	}

}
