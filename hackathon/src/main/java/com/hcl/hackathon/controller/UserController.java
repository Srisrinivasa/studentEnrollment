package com.hcl.hackathon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.hackathon.dao.UserDao;
import com.hcl.hackathon.domain.Login;
import com.hcl.hackathon.domain.UserDetails;
import com.hcl.hackathon.response.GenericResponse;

@RestController
@RequestMapping(value="/user")
public class UserController {
	
	@Autowired
	private UserDao userDao;
	
	@PostMapping()
	public GenericResponse login(@RequestBody Login login) {
		String role = userDao.login(login);
		return new GenericResponse(role != null ? "User Login Successful" : "User Login Failed", role);
	}

	@PostMapping("/register")
	public ResponseEntity<?> registerUser(@RequestBody UserDetails user) {
		System.out.println(user.getFirstName());
		userDao.saveUserDetails(user);
		return ResponseEntity.ok("User Registered successfully");
	}
	
	@GetMapping("test")
	public String test() {
		return "success";
	}
}
