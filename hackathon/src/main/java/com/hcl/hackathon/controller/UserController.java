package com.hcl.hackathon.controller;

import java.text.ParseException;
import java.util.List;

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
import com.hcl.hackathon.response.GenericResponse;

@CrossOrigin
@RestController
@RequestMapping(value="/user")
public class UserController {
	
	@Autowired
	private UserDao userDao;
	
	/**
	 * Method is used to check login credentials 
	 * @param Login(userId, password) 
	 * @return GenericResponse(message, role)
	 **/
	@PostMapping()
	public GenericResponse login(@RequestBody Login login) {
		String role = userDao.login(login);
		return new GenericResponse(role != null ? "User Login Successful" : "User Login Failed", role);
	}

	/**
	 * Method is used to find all users having kyc status as pending 
	 * @return List<UserDetails>
	 **/
	@GetMapping("/pendingKycUsers")
	public List<UserDetails> pendingKYCUser() {
		return userDao.findPendingKycUsers();
	}
	
	/**
	 * Method is used to
	 * @param user
	 * @return ResponseEntity.ok("User Registered successfully");
	 * @throws ParseException
	 */
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
