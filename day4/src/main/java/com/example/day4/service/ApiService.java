package com.example.day4.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.day4.models.Student;
import com.example.day4.repository.StudentRepo;

@Service
public class ApiService {
	@Autowired
	StudentRepo repository;
	public Student saveinfo(Student ss)
	{
		return repository.save(ss);
	}
	public List<Student> showinfo()
	{
		return repository.findAll();
	}
	public Optional<Student> sow(int id)
	{
		return repository.findById(id);
	}
	public String changeinfoid(int id,Student ss)
	{
		repository.saveAndFlush(ss);
		if(repository.existsById(id))
		{
			return "Updated";
		}
		else
		{
			return "Enter valid Id";
		}
	}
	public void deleteid(int id)
	{
		repository.deleteById(id);
	}
	public Optional<Student> save(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
