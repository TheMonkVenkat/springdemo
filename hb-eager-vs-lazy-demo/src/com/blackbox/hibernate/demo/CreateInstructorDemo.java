package com.blackbox.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.blackbox.hibernate.demo.entity.Course;
import com.blackbox.hibernate.demo.entity.Instructor;
import com.blackbox.hibernate.demo.entity.InstructorDetail;

public class CreateInstructorDemo {

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
			//Create the objects
			
			Instructor tempInstructor = 
					new Instructor("Instructor2", "Ins2", "instructor2@gmail.com");
			
			InstructorDetail tempInstructorDetail = 
					new InstructorDetail("www.balckbox.com/instructor2","Gaming");
			
			Course tempCourse = new Course("Java");
			
			tempInstructor.addCourse(tempCourse);
			
			//Associate the objects
			tempInstructor.setInstructorDetail(tempInstructorDetail);
			
			//start a transaction
			session.beginTransaction();
			
			//save the Instructor
			//Note: It will also save the instructorDetail object 
			//because cascadetype is ALL
			
			System.out.println("Saving the instructor: " + tempInstructor);
			
			session.save(tempInstructor);
			session.save(tempCourse);
			
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
