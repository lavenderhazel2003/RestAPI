package com.example.day4.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.day4.models.Student;
import com.example.day4.service.ApiService;

@RestController
public class ApiController {
	@Autowired
	ApiService studentService;
	
	@GetMapping("/show")
	public List<Student> show()
	{
		return studentService.showinfo();
	}
	@GetMapping("get/{id}")
    public Optional<Student>getinfo(@PathVariable int id)
    {
 	   return studentService.save(id);
    }
	@PostMapping("save")
    public Student add(@RequestBody Student details)
    {
 	   return studentService.saveinfo(details);
    }
	 @PutMapping("update/{id}")
     public String modifybyid(@PathVariable int id,@RequestBody Student update)
 	{
 		return studentService.changeinfoid(id,update);
 	}
     @DeleteMapping("delete/{id}")
     public  void deletemyid(@PathVariable int id)
     {
    	 studentService.deleteid(id);
     }
}
