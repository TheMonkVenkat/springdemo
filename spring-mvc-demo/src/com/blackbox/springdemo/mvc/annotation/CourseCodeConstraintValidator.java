package com.blackbox.springdemo.mvc.annotation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CourseCodeConstraintValidator implements ConstraintValidator<CourseCode, String> {
	
	private String coursePrefix;
	
	@Override
	public void initialize(CourseCode theCourseCode) {
		this.coursePrefix = theCourseCode.value();
	}

	@Override
	public boolean isValid(String theCourseCode, ConstraintValidatorContext theConstraintValidatorContext) {

		boolean result;
		if(theCourseCode != null)
			result= theCourseCode.startsWith(coursePrefix);
		else
			result = true;
		
		return result;
	}

}
