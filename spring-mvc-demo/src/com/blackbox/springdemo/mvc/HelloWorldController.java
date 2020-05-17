package com.blackbox.springdemo.mvc;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/hello")
public class HelloWorldController {
	
	//need a controller method to show the initial HTML form
	@RequestMapping("/showForm")
	public String showForm() {
		return "helloworld-form";
	}
	
	
	//Need a Controller method to process the HTML form
	@RequestMapping("/processForm")
	public String processForm() {
		return "helloworld";
	}

	@RequestMapping("/processFormVersion2")
	public String letsShoutDude(HttpServletRequest request, Model model) {
		
		//read the request parameters from the HTML form
		String name = request.getParameter("studentName");
		
		//Convert the data into Caps
		name = name.toUpperCase();
		
		//Create the message
		String result = "Yo Yo! " + name;
		
		//add message to model
		model.addAttribute("message", result);
		
		return "helloworld";
	}
	
	@RequestMapping("/processFormRequestParam")
	public String letShoutDudeByRequestParam(@RequestParam("studentName") String name, Model model) {
		
		//Convert the name to upper case
		name = name.toUpperCase();
		
		name = "Yo Oy! "+ name;
		
		model.addAttribute("message", name);
		
		return "helloworld";
	}
}
