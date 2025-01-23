package com.jdbc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
public class TestController {
	
	@RequestMapping("/test")
	public String firstHandler() {
		//Here we return string but as before we return jsp view page
		//So for returning string we should add @RequestBody above the class
		return "Just for testing";
	}
	
}
