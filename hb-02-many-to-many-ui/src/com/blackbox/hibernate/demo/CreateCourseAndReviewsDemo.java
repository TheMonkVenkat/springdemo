package com.blackbox.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.blackbox.hibernate.demo.entity.Course;
import com.blackbox.hibernate.demo.entity.Instructor;
import com.blackbox.hibernate.demo.entity.InstructorDetail;
import com.blackbox.hibernate.demo.entity.Review;
import com.blackbox.hibernate.demo.entity.Student;

public class CreateCourseAndReviewsDemo {

	public static void main(String[] args) {

		//Create a session factory
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Instructor.class)
									.addAnnotatedClass(InstructorDetail.class)
									.addAnnotatedClass(Course.class)
									.addAnnotatedClass(Review.class)
									.addAnnotatedClass(Student.class)
									.buildSessionFactory();
		
		//create session
		Session session = factory.getCurrentSession();
		
		try {
			//start a transaction
			session.beginTransaction();
			
			//create a course
			Course theCourse = new Course("How to make fall in love in 15 days");
			
			//save the course along with reviews
			System.out.println("\n\n**********************Saving the Course***********************");
			session.save(theCourse);
			System.out.println("\n\n the Couse: " + theCourse);
			
			//create the students
			Student tempStudent1 = new Student("tom","hardy", "tom.hardy@blackbox.com");
			Student tempStudent2 = new Student("zim","cook", "zim.cook@blackbox.com");
			Student tempStudent3 = new Student("tamarin","elsa", "tamanran@blackbox.com");
			
			theCourse.addStudent(tempStudent1);
			theCourse.addStudent(tempStudent2);
			theCourse.addStudent(tempStudent3);
			
			//save the students
			session.save(tempStudent1);
			session.save(tempStudent2);
			session.save(tempStudent3);
			
			System.out.println("\n\n the Students: " + theCourse.getStudents());

			//commit the transaction
			session.getTransaction().commit();
			
			System.out.println("Done!!!");

		}finally {
			session.close();
			factory.close();
		}
	}

}
