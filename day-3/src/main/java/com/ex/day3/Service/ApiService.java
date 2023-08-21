package com.ex.day3.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ex.day3.Models.Employee;
import com.ex.day3.Repositories.EmployeeRepo;

@Service
public class ApiService {
	
	@Autowired
	EmployeeRepo ar;
	
	public Employee saveinfo(Employee am) {
		return ar.save(am);
	}
	
	public List<Employee> showinfo(){
		return ar.findAll();
	}
}