package com.example.homehelper1.entity;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="UserDetails")
public class UserDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String category;
	private long contact;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_id")
	private List<ServiceCategories> categories;
	
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
//	public int getAge() {
//		return age;
//	}
//	public void setAge(int age) {
//		this.age = age;
//	}
//	
	public long getContact() {
		return contact;
	}
	public void setContact(long contact) {
		this.contact = contact;
	}
	
	
	public UserDetails(String category, int id, String name, int age, long contact ) {
		this.category = category;
		this.id = id;
		this.name = name;
		//this.age = age;
		this.contact = contact;
	}
	public List<ServiceCategories> getCategories() {
		return categories;
	}
	public void setCategories(List<ServiceCategories> categories) {
		this.categories = categories;
	}
	public UserDetails()
	{
		
	}
}
