package com.blackbox.springdemo.rest;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blackbox.springdemo.entity.Student;
import com.blackbox.springdemo.exception.StudentNotFoundException;

@RestController
@RequestMapping("/api")
public class StudentRestController {
	
	private List<Student> theStudents;
	
	@PostConstruct
	public void loadData() {
		theStudents = new ArrayList<>();
		
		theStudents.add(new Student("Iron","Man"));
		theStudents.add(new Student("Pepper","Potts"));
		theStudents.add(new Student("Jarvis","AI"));
		theStudents.add(new Student("Tony","Stark"));
	}
 	
	
	@GetMapping("/students")
	public List<Student> getStudents(){
		return theStudents;
	}
	
	//define end point for "/students/{studentid}"
	
	@GetMapping("/students/{indexId}")
	public Student getStudent(@PathVariable int indexId) {
		
		if(this.theStudents.size() <= indexId || indexId < 0)
			throw new StudentNotFoundException("Student id is not Found - " + indexId);
		return theStudents.get(indexId);
		
	}
	
}




