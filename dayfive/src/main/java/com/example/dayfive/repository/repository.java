package com.example.dayfive.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.dayfive.entity.books;

@Repository
public interface repository extends JpaRepository<books, Integer>{

}
