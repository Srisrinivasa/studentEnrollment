package com.hcl.hackathon.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.hackathon.domain.Login;
import com.hcl.hackathon.domain.UserDetails;

@RestController
@RequestMapping(value="/user")
public class UserController {
	
	@PostMapping()
	public String login(@RequestBody Login login) {
		if (login.getUserId() != null && login.getUserId().equals("nitin") &&
				login.getPassword() != null && login.getPassword().equals("nitin123")) {
			return "success";
		}
		return "fail";
	}

	@PostMapping("/register")
	public String registerUser(@RequestBody UserDetails user) {
		System.out.println(user.getFirstName());
		return "success";
	}
	
	@GetMapping("test")
	public String test() {
		return "success";
	}
}
