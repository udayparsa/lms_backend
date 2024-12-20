package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.websocket.server.PathParam;

@RestController
@CrossOrigin
public class Service {
	
	@Autowired
	DAO dao;
	
	@GetMapping("/")
	public String fun1() {
		return "This is home page";
	}	
	
	@PostMapping("/insert")
	public String fun2(@RequestBody User user) {
		dao.insert(user);
		return "User Inserted";
	}		
	
	 @PostMapping("/login")
	public String fun9(@RequestBody User user) {
		 User exist=dao.findUser(user.getEmail());
		   if(exist!=null&&exist.getPassword().equals(user.getPassword())) {
			   return "Login Successfull";
		   }
		   else {
			   return "Login Unsuccessfull";
		   }
	}
	@PostMapping("/adminlogin")
	public String fun3(@RequestBody Admin admin) {
		Admin exists=dao.findAdmin(admin.getEmail());
		if(exists!=null&&exists.getPassword().equals(admin.getPassword())) {
			return "Login Successfull";
		}
		else {
			return "Login Unsuccessfull";
		}
	}
	
	@GetMapping("/finduser/{email}")
	public ResponseEntity<User> findUser(@PathVariable String email) {
	    User exist = dao.findUser(email);
	    exist.setPassword(null);
	    if (exist != null) {
	        System.out.println(exist);
	        return ResponseEntity.ok(exist);
	    }
	    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
	}
}
