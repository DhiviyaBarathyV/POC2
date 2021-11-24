package com.dhiviyaBookStore.model;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Size;

@Entity
public class User 
{
	@Column
	@Size(min=3,message="min 3 characters")
	private String name;
	@Id
	private String email;
	@Column
	private int age;
	@Column
	private String city;
	@Column
	@Size(min=10,max=10,message="10 characters")
	private String phoneNo;
	@Column
	private String passWord;
	public User()
	{
		super();
		// TODO Auto-generated constructor stub
	}
	public User(String name, String email, int age, String city, String phoneNo, String passWord)
	{
		super();
		this.name = name;
		this.email = email;
		this.age = age;
		this.city = city;
		this.phoneNo = phoneNo;
		this.passWord = passWord;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	@Override
	public String toString() {
		return "User [name=" + name + ", email=" + email + ", age=" + age + ", city=" + city + ", phoneNo=" + phoneNo
				+ ", passWord=" + passWord + "]";
	}
	
}
