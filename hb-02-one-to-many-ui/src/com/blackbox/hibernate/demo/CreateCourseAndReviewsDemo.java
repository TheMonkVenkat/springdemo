package com.blackbox.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.blackbox.hibernate.demo.entity.Course;
import com.blackbox.hibernate.demo.entity.Instructor;
import com.blackbox.hibernate.demo.entity.InstructorDetail;
import com.blackbox.hibernate.demo.entity.Review;

public class CreateCourseAndReviewsDemo {

	public static void main(String[] args) {

		//Create a session factory
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Instructor.class)
									.addAnnotatedClass(InstructorDetail.class)
									.addAnnotatedClass(Course.class)
									.addAnnotatedClass(Review.class)
									.buildSessionFactory();
		
		//create session
		Session session = factory.getCurrentSession();
		
		try {
			//start a transaction
			session.beginTransaction();
			
			//create a course
			Course theCourse = new Course("Java - Complete Guid");
			
			//add reviews
			theCourse.addReview(new Review("Awesome course..."));
			theCourse.addReview(new Review("Speechless Course..."));
			theCourse.addReview(new Review("What a dumb course..."));
			
			//save the course along with reviews
			System.out.println("\n\n**********************Saving the Course***********************");
			session.save(theCourse);
			System.out.println("\n\n the Couse: " + theCourse);
			
			System.out.println("\n\n the reviews: " + theCourse.getReviews());

			//commit the transaction
			session.getTransaction().commit();
			
			System.out.println("Done!!!");

		}finally {
			session.close();
			factory.close();
		}
	}

}
