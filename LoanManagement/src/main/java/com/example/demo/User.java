package com.example.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity(name = "userregisters")
public class User {
	String name;
	int age;
	@Id()
	String email;
	String aadharno;
	String password;
	String jobtitle;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAadharno() {
		return aadharno;
	}
	public void setAadharno(String aadharno) {
		this.aadharno = aadharno;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getJobtitle() {
		return jobtitle;
	}
	public void setJobtitle(String jobtitle) {
	    this.jobtitle = jobtitle;
	}

	
	
	@Override
	public String toString() {
		return "User [name=" + name + ", age=" + age + ", email=" + email + ", aadharno=" + aadharno + ", password="
				+ password + ", jobtitle=" + jobtitle + "]";
	}
	
	
	
	
	
	

}
