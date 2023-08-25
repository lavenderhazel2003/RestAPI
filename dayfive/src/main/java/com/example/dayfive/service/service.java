package com.example.dayfive.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.dayfive.entity.books;
import com.example.dayfive.repository.repository;

@Service
public class service {
	@Autowired
	repository bookrepository;
	public List<books> getinfo()
	{
		return bookrepository.findAll();
		
	}
	public List<books> saveinfo(@RequestBody List<books> bookentity)
	{
		return bookrepository.saveAll(bookentity);
	}
	public books putinfo(@RequestBody books bookentity)
	{
		return bookrepository.saveAndFlush(bookentity);
	}
	public void delete(books bookentity)
	{
		bookrepository.delete(bookentity);
	}

}