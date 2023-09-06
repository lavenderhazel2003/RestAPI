package com.example.homehelper1.repository;
//import java.util.List;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
//import org.springframework.data.jpa.repository.Modifying;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;
//import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.query.Param;

import com.example.homehelper1.entity.HelperDetails;

import jakarta.transaction.Transactional;

//import jakarta.transaction.Transactional;

//import jakarta.transaction.Transactional;

public interface HelperRepo extends JpaRepository<HelperDetails, String> {
	
	
	@Query("select h from HelperDetails h ")
	public List<HelperDetails> getAllHelper();
	//Deletion in JPQL
    @Modifying
	@Transactional
	@Query(value="DELETE FROM HelperDetails where helper_id = :i",nativeQuery = true)
	Integer deleteByHelperId(@Param("i")int helper_id);
//    //Updating in JPQL
//    @Modifying
//    @Transactional
//    @Query(value="UPDATE helper_details d set d.helper_name=:hn WHERE d.helper_id=:i",nativeQuery=true)
//    public Integer updateByHelperId(@Param("hn")String helper_name,@Param("i")int helper_id);
}

 
