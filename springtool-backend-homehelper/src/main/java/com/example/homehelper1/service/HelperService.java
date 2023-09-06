package com.example.homehelper1.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
//import org.springframework.web.bind.annotation.PathVariable;

import com.example.homehelper1.entity.HelperDetails;
import com.example.homehelper1.repository.HelperRepo;

@Service
public class HelperService {
	@Autowired
	HelperRepo Repo;

	public List<HelperDetails> getproducts() {
		return  Repo.findAll();
	}

	public List<HelperDetails> saveinfo(List<HelperDetails> product) {
		return  Repo.saveAll(product);
	}
	
//	public HelperDetails saveDetails(HelperDetails hd) {
//		return Repo.save(hd);
//	}	
//	public List<HelperDetails> getDetails()
//	{
//		return Repo.findAll();
//
//	}
//	public HelperDetails getDetailsById(String category) {
//		return Repo.findById(category).get();
//	}	
	public HelperDetails UpdateDetails(HelperDetails e1) {
		return Repo.save(e1);
	}
	public void deleteDetails(String category) {
		Repo.deleteById(category);
	}
	//sorting
	public List<HelperDetails> sortinfo(String s)
	{
		return  Repo.findAll(Sort.by(Sort.DEFAULT_DIRECTION,s));
	}
	//pagination
	public List<HelperDetails> getbypage(int pgno,int pgsize)
	{
		Page<HelperDetails> p= Repo.findAll(PageRequest.of(pgno, pgsize));
		return p.getContent();
	}
	
//	//sorting
//    public List<HelperDetails> getSorted(String field) {
//	return Repo.findAll(Sort.by(Sort.Direction.ASC,field));
//}
//
//    //pagination
//    public List<HelperDetails> getWithPagination(@PathVariable int offset, @PathVariable int pageSize) {
//    	Page<HelperDetails> page =Repo.findAll(PageRequest.of(offset, pageSize));
//    	return page.getContent();
//    }

    //display JPQL 
  	public List<HelperDetails> allHelper(){
  		return Repo.getAllHelper();
  	}
//  	//deletion in JPQL
//  	public Integer delete(int id ) {
//  		return Repo.deleteByHelperId(id);
//  	}
  	//updating in JPQL
//	public Integer update(String name,int id) {
//  		return Repo.updateByHelperId(name,id);
//  	}
}

