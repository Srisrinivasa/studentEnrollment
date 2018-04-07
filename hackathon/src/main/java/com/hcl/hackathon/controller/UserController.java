package com.hcl.hackathon.controller;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.hackathon.dao.UserDao;
import com.hcl.hackathon.dao.UserDaoImpl;
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
	 * 
	 * @param userDetails
	 * @return
	 */
	@PostMapping("/updateKycStatus")
	public ResponseEntity<String> updateKYCStatus(@RequestBody UserDetails userDetails) {
		userDao.updateKycStatus(userDetails.getKYCStatus(), userDetails.getId());
		return ResponseEntity.ok("KYC status updated successfully");
	}
	
	/**
	 * Method is used to
	 * @param user
	 * @return ResponseEntity
	 * @throws ParseException
	 */
	@PostMapping("/register")
	public ResponseEntity<?> registerUser(@RequestBody UserDetails user) throws ParseException {
		return isUserAlreadyExists(user.getEmailId())?ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User already exists"):saveUserDetails(user);
	}
	
	private ResponseEntity<?> saveUserDetails(UserDetails user) {
		ResponseEntity<?> response =null;
		try {
			userDao.saveUserDetails(user);
			response = ResponseEntity.ok("User Registered Successfully");
		} catch (ParseException e) {
			response = ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Date parsing failed: "+e.toString());
		}
		return response;
	}
	
	private boolean isUserAlreadyExists(String emailId){
		return (userDao.findByUserId(emailId)==null)? false:true;
	}

	@GetMapping("test")
	public String test() {
		return "success";
	}
}
