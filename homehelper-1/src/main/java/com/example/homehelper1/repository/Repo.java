package com.example.homehelper1.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.homehelper1.entity.UserDetails;

public interface Repo extends JpaRepository<UserDetails, String> {

}
