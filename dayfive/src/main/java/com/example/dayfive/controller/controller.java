package com.example.dayfive.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.dayfive.entity.books;
import com.example.dayfive.service.service;

public class controller {
	@Autowired
	service bookservice;
	@GetMapping("/")
	public List<books> showinfo()
	{
		return bookservice.getinfo();
	}
	@PostMapping("/")
	public List<books> putinfo(@RequestBody List<books> bookentity)
	{
		return bookservice.saveinfo(bookentity);
	}
	@PutMapping("/{id}")
	public books updateinfo(@RequestBody books bookentity)
	{
		return bookservice.putinfo(bookentity);
	}
	@DeleteMapping("/{id}")
	public String delete(books bookentity)
	{
		bookservice.delete(bookentity);
		return "Deleted the data SUCCESSFULLY";
	}

}