package com.example.day4.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.day4.models.Student;

@Repository
public interface StudentRepo extends JpaRepository<Student, Integer>{

}
