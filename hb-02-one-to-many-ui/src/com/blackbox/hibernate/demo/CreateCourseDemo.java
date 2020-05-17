package com.blackbox.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.blackbox.hibernate.demo.entity.Course;
import com.blackbox.hibernate.demo.entity.Instructor;
import com.blackbox.hibernate.demo.entity.InstructorDetail;

public class CreateCourseDemo {

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
			
			//Get the instructor id 1
			int theId = 1;
			
			Instructor theInstructor = session.get(Instructor.class, theId);
			
			Course tempCourse1 = new Course("C#");
			Course tempCourse2 = new Course("Php");
			
			theInstructor.addCourse(tempCourse1);
			theInstructor.addCourse(tempCourse2);
			
			session.save(tempCourse1);
			session.save(tempCourse2);
			
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
