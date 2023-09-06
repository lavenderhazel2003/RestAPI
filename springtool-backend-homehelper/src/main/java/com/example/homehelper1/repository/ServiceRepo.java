package com.example.homehelper1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.homehelper1.entity.ServiceCategories;

public interface ServiceRepo extends JpaRepository<ServiceCategories, String> {


}
