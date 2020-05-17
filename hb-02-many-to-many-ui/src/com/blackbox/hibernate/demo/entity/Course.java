package com.blackbox.hibernate.demo.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Course")
public class Course {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	private int id;
	
	@Column(name="Title")
	private String title;
	
	@ManyToOne(cascade= {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinColumn(name="InstructorID")
	private Instructor instructor;
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	@JoinColumn(name="COURSE_ID")
	private List<Review> reviews;
	
	@ManyToMany(
		fetch=FetchType.LAZY
		, cascade= {
				CascadeType.DETACH, CascadeType.MERGE
				, CascadeType.PERSIST, CascadeType.REFRESH
		}
	)
	@JoinTable(
			name="JON_COURSE_STUDENT",
			joinColumns=@JoinColumn(name="COURSE_ID"),
			inverseJoinColumns=@JoinColumn(name="STUDENT_ID")
			)
	private List<Student> students;

	public Course(String title) {
		this.title = title;
	}
	
	public Course() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Instructor getInstructor() {
		return instructor;
	}

	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}
	
	public void addReview(Review theReview) {
		if(reviews == null)
			this.reviews = new ArrayList<Review>();
		this.reviews.add(theReview);
	}

	@Override
	public String toString() {
		return "Course [id=" + id + ", title=" + title + ", instructor=" + instructor + "]";
	}

	public List<Review> getReviews() {
		return reviews;
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}
	
	public void addStudent(Student theStudent) {
		if(this.students == null)
			this.students = new ArrayList<>();
		this.students.add(theStudent);
	}
	
}
