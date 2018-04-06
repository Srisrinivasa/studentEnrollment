package com.hcl.hackathon.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.hackathon.model.User;

@RestController
public class RegistrationController {
	
	@GetMapping("test")
	public String test() {
		return "success";
	}
	
	@PostMapping("registerUser")
	public String registerUser(User user) {
		System.out.println(user.getFirstName());
		return "success";
	}

}
