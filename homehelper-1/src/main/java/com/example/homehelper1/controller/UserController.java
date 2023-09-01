package com.example.homehelper1.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.homehelper1.entity.UserDetails;
import com.example.homehelper1.service.UserService;


@RestController
public class UserController {
	Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	UserService userService;
	
	@GetMapping("/show")
	public List<UserDetails> showinfo()
	{
		return userService.getproducts();
	}
	@PostMapping("/post")
	public List<UserDetails> putinfo(@RequestBody List<UserDetails> products)
	{
		return userService.saveinfo(products);
	}
	@PutMapping("/Update")
	public List<UserDetails> UpdateInfo(@RequestBody List<UserDetails> st1) {
		return userService.UpdateDetails(st1);
	}
	@DeleteMapping("/delete/{id}")
	public String deleteInfo(@PathVariable("id") String id) {
		userService.deleteDetails(id);
		return "Deleted details";
	}
	@GetMapping(path="/loggerdemo")
	public String loggerDemo() {
		logger.info("Logger info");
		logger.warn("Logger warn");
		logger.error("logger error");
		return "Hello from logger demo";
	}
	
//	@GetMapping("sort/{name}")
//    public List<UserDetails> getsortinfo(@PathVariable String name)
//    {
//   	 return userService.sortinfo(name);
//    }
//@GetMapping("paging/{pageno}/{pagesize}")
//	public List<UserDetails> showpageinfo(@PathVariable int pageno,@PathVariable int pagesize)
//	{
//		return userService.getbypage(pageno, pagesize);
//	}
//	@GetMapping("/")
//	public List<UserDetails> displayAllProducts(){
//		return userService.showinfo();
//	
//	}
}
