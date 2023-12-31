package com.jsp.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
//@ResponseBody
public class MainController {
	
	@GetMapping("/")
	public String home() {
		System.out.println("This is home");
		return "home";
	}
	@GetMapping("/contact")
	public String contact() {
		System.out.println("This is contact");
		return "contact";
	}

}
