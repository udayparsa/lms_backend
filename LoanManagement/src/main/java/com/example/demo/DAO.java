package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DAO {
	
	@Autowired
	UserInterface repo;
	@Autowired
	AdminInterface repo2;
	
	public void insert(User u1) {
		repo.save(u1);
	}
	public User findUser(String email) {
		//System.out.println(email);
		return repo.findByEmail(email);
	}
	
	public Admin findAdmin(String email) {
		return repo2.findByEmail(email);
	}
	
	
}
