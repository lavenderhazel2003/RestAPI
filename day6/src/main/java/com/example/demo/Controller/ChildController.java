package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.example.demo.Model.ChildModel;
import com.example.demo.Service.ChildService;

@RestController
public class ChildController {
	@Autowired
	ChildService bser;
	@PostMapping("add")
	public ChildModel add(@RequestBody ChildModel gs)
	{
		return bser.saveinfo(gs);
	}
	@GetMapping("show")
	public List<ChildModel> show(){
		return bser.showinfo();
	}
	@PutMapping("map")
	public ChildModel modify(@RequestBody ChildModel ss)
	{
		return bser.changeinfo(ss);
	}
	@DeleteMapping("del")
	public String delete(@RequestBody ChildModel ss)
	{
		bser.delete(ss);
		return "Deleted successfully";
	}
	@DeleteMapping("delid")
	public String deleteEmployee(@RequestParam int id) {
	    bser.deleteid(id);  
	    return "deleted beauttifully";
	}
	@GetMapping("sort/{name}")
	public List<ChildModel> getsortinfo(@PathVariable String name)
	{
		return bser.sortinfo(name);
	}
	@GetMapping("paging/{pageno}/{pagesize}")
	public List<ChildModel> showpage(@PathVariable int pageno,@PathVariable int pagesize)
	{
		return bser.pagination(pageno,pagesize);
	}
}
