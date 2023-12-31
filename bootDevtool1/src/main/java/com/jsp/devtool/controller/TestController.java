package com.jsp.devtool.controller;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;



@Controller

public class TestController {
	
	
	@GetMapping("/test")
	@ResponseBody
	public String getMethodName() {
		return "This is a \t string Raja t";
	}
	
	
}
