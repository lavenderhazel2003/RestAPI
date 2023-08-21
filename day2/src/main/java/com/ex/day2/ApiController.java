package com.ex.day2;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {

	@Value("${defaultname}")
	private String defaultname;

	@GetMapping("/display")
	public String display() {

		return "My name is " + defaultname;
	}
}
