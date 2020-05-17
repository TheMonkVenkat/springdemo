package com.blackbox.springdemo.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("/silly")
public class SillyController {
	
	
	@RequestMapping("/showForm")
	public String displayForm() {
		return "silly";
	}

}
