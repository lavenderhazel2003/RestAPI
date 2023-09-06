package com.example.homehelper1.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.homehelper1.entity.UserDetails;

public interface Repo extends JpaRepository<UserDetails, String> {
	@Query("SELECT u FROM UserDetails u WHERE u.email = :email")
	   public UserDetails findByEmail(@Param("email") String email);
}
