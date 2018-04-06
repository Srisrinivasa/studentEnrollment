package com.hcl.hackathon.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.hackathon.model.Login;

@RestController
public class LoginController {
	
	@PostMapping("user")
	public String login(@RequestBody Login login) {
		if (login.getUserId() != null && login.getUserId().equals("nitin") &&
				login.getPassword() != null && login.getPassword().equals("nitin123")) {
			return "success";
		}
		return "fail";
	}
}
