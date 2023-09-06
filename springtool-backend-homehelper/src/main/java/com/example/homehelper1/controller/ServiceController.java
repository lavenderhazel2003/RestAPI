package com.example.homehelper1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.homehelper1.entity.ServiceCategories;
import com.example.homehelper1.service.ServiceService;

@RestController
public class ServiceController {
	@Autowired
	ServiceService service;

	@PostMapping("/postc")
	public ServiceCategories addInfo(@RequestBody ServiceCategories st) {
		return service.saveDetails(st);
	}
	
	@GetMapping("/getc")
	public List<ServiceCategories> fetchDetails1() {
		return service.getDetails();
	}
	
	@GetMapping("/{id}c")
	public ServiceCategories getDetailsById(@PathVariable String category) {
		return service.getDetailsById(category);
	}
	
	@PutMapping("/Updatec")
	public ServiceCategories UpdateInfo(@RequestBody ServiceCategories st1) {
		return service.UpdateDetails(st1);
	}
	
	@DeleteMapping("/delete/{id}c")
	public String deleteInfo(@PathVariable("id") String id) {
		service.deleteDetails(id);
		return "Deleted details";
	}
}