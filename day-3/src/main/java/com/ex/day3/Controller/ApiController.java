package com.ex.day3.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ex.day3.Models.Employee;
import com.ex.day3.Service.ApiService;

@RestController
public class ApiController {
	
	@Autowired
	ApiService aser;
	
	@PostMapping("addEmp")
	public Employee add(@RequestBody Employee am) {
		return aser.saveinfo(am);
	}
	
	@GetMapping("showemp")
	public List<Employee> show(){
		return aser.showinfo();
	}
}