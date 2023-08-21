package com.ex.day3.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ex.day3.Models.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Integer>{

}