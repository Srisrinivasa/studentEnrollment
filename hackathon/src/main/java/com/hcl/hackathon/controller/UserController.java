package com.hcl.hackathon.controller;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.hackathon.dao.UserDao;
import com.hcl.hackathon.domain.Login;
import com.hcl.hackathon.domain.UserDetails;

@CrossOrigin
@RestController
@RequestMapping(value="/user")
public class UserController {
	
	@Autowired
	private UserDao userDao;
	
	@PostMapping()
	public String login(@RequestBody Login login) {
		if (login.getUserId() != null && login.getUserId().equals("nitin") &&
				login.getPassword() != null && login.getPassword().equals("nitin123")) {
			return "success";
		}
		return "fail";
	}

	@PostMapping("/register")
	public ResponseEntity<?> registerUser(@RequestBody UserDetails user) throws ParseException {
		System.out.println(user.getFirstName());
		userDao.saveUserDetails(user);
		return ResponseEntity.ok("User Registered successfully");
	}
	
	@GetMapping("test")
	public String test() {
		return "success";
	}
}
