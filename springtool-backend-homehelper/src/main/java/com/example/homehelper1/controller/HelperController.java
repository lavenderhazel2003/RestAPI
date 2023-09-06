package com.example.homehelper1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.homehelper1.entity.HelperDetails;
import com.example.homehelper1.service.HelperService;

@RestController
public class HelperController {
	@Autowired
	HelperService helperService;
	@GetMapping("/showh")
	public List<HelperDetails> showinfo()
	{
		return helperService.getproducts();
	}
	@PostMapping("/posth")
	public List<HelperDetails> putinfo(@RequestBody List<HelperDetails> products)
	{
		return helperService.saveinfo(products);
	}
//	@PostMapping("/posth")
//	public HelperDetails addInfo(@RequestBody HelperDetails st) {
//		return helperService.saveDetails(st);
//	}
//	
//	@GetMapping("/geth")
//	public List<HelperDetails> fetchDetails1() {
//		return helperService.getDetails();
//	}
	
//	@GetMapping("/{id}h")
//	public HelperDetails getDetailsById(@PathVariable String category) {
//		return helperService.getDetailsById(category);
//	}
//	
	@PutMapping("/Updateh")
	public HelperDetails UpdateInfo(@RequestBody HelperDetails st1) {
		return helperService.UpdateDetails(st1);
	}
	
	@DeleteMapping("/delete/{id}h")
	public String deleteInfo(@PathVariable("id") String id) {
		helperService.deleteDetails(id);
		return "Deleted details";
	}
	//sorting
	@GetMapping("sort/{name}")
    public List<HelperDetails> getsortinfo(@PathVariable String name)
    {
   	 return helperService.sortinfo(name);
    }
	//pagination
	@GetMapping("paging/{pageno}/{pagesize}")
	public List<HelperDetails> showpageinfo(@PathVariable int pageno,@PathVariable int pagesize)
	{
		return helperService.getbypage(pageno, pagesize);
	}
	//display JPQL
		@GetMapping("/s")
		public List<HelperDetails> displayAllHelper(){
			return helperService.allHelper();
		}
//	//sorting
//		@GetMapping("/product/{field}")
//		public List<HelperDetails> getWithSort(@PathVariable String field) {
//			return helperService.getSorted(field);
//		}
//
//	// pagination
//	@GetMapping("/product/{offset}/{pageSize}")
//	public List<HelperDetails> productsWithPagination(@PathVariable int offset, @PathVariable int pageSize) {
//		return helperService.getWithPagination(offset, pageSize);
//	}
	
    
//	//deletion in JPQL
//	@DeleteMapping("/del/{helper_id}")
//	public Integer delete(@PathVariable ("helper_id")int helper_id) {
//		return helperService.delete(helper_id);
//	}
//	//updating in JPQL
//	@PutMapping("/update/{helper_id}/{helper_name}")
//	public String update(@PathVariable("helper_name")String helper_name,@PathVariable ("helper_id")int helper_id) {
//		return helperService.update(helper_name,helper_id)+" updated";
//	}

}