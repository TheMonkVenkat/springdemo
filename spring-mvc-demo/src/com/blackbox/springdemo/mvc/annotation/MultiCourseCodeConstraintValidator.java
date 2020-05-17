package com.blackbox.springdemo.mvc.annotation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class MultiCourseCodeConstraintValidator implements ConstraintValidator<MultiCourseCode, String> {
	
	private String[] coursePrefixes;
	
	@Override
	public void initialize(MultiCourseCode theCourseCode) {
		this.coursePrefixes = theCourseCode.value();
	}

	@Override
	public boolean isValid(String theCode, ConstraintValidatorContext theConstraintValidator) {

		boolean result = false;
		if(theCode != null) {
			for (String coursePrefix : coursePrefixes) {
				result = theCode.startsWith(coursePrefix);
				if(result)
					break;
			}
		}
		else {
			result = true;
		}
		return result;
	}

}
