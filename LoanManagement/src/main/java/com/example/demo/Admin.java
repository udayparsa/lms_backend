package com.example.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity(name = "adminlogin")
public class Admin {
	@Id
	String email;
	String password;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
