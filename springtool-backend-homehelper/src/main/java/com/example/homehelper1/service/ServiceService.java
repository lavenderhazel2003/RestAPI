package com.example.homehelper1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.homehelper1.entity.HelperDetails;
import com.example.homehelper1.entity.ServiceCategories;
import com.example.homehelper1.repository.ServiceRepo;


@Service
public class ServiceService {
	@Autowired
	ServiceRepo Repo;

	public ServiceCategories saveDetails(ServiceCategories e) {
		return Repo.save(e);
	}	
	public List<ServiceCategories> getDetails()
	{
		return Repo.findAll();

	}
	public ServiceCategories getDetailsById(String category) {
		return Repo.findById(category).get();
	}	
	public ServiceCategories UpdateDetails(ServiceCategories e1) {
		return Repo.save(e1);
	}
	public void deleteDetails(String category) {
		Repo.deleteById(category);
	}
	public List<HelperDetails> getHelperDetails(String category) {
		ServiceCategories sc =Repo.findById(category).get();
		 List<HelperDetails> hd = sc.getDetails();
		return hd;
	}

}