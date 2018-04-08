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
import com.hcl.hackathon.domain.Login;
import com.hcl.hackathon.domain.UserDetails;
import com.hcl.hackathon.response.GenericResponse;

/**
 * Controller for user related services
 * @author admin
 *
 */
@CrossOrigin
@RestController
@RequestMapping(value="/user")
public class UserController {
	
	//UserDao service for database activity
	private final UserDao userDao;

	@Autowired
	public UserController(UserDao userDao) {
		this.userDao=userDao;
	}
	/**
	 * Method is used to check login credentials 
	 * @param Login(userId, password) 
	 * @return GenericResponse(message, role)
	 **/
	@PostMapping()
	public GenericResponse login(@RequestBody Login login) {
		String role = userDao.login(login);
		return new GenericResponse(role != null && !role.isEmpty() ? "User Login Successful" : "User Login Failed", role);
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
	public ResponseEntity<String> updateKYCStatus(final @RequestBody UserDetails userDetails) {
		userDao.updateKycStatus(userDetails.getKycStatus(), userDetails.getId());
		return ResponseEntity.ok("KYC Status Updated Successfully");
	}
	
	/**
	 * Method is used to register User
	 * @param user
	 * @return ResponseEntity
	 * @throws ParseException
	 */
	@PostMapping("/register")
	public ResponseEntity<?> registerUser(final @RequestBody UserDetails user) throws ParseException {
		return isUserAlreadyExists(user.getEmailId())?ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User already exists"):saveUserDetails(user);
	}
	
	private ResponseEntity<?> saveUserDetails(final UserDetails user) {
		ResponseEntity<?> response =null;
		try {
			userDao.saveUserDetails(user);
			response = ResponseEntity.status(HttpStatus.CREATED).body("User Registered Successfully");
		} catch (ParseException e) {
			response = ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Date parsing failed: "+e.toString());
		}
		return response;
	}
	
	private boolean isUserAlreadyExists(final String emailId){
		return (userDao.findByUserId(emailId)==null)? false:true;
	}

}
