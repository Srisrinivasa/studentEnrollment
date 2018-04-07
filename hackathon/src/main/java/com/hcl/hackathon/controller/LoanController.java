package com.hcl.hackathon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.hackathon.dao.UserDao;
import com.hcl.hackathon.domain.LoanDetails;

@CrossOrigin
@RestController
@RequestMapping(value="/loan")
public class LoanController {
	
	@Autowired
	private UserDao userDao;
	
	@PostMapping("/captureDetails")
	public ResponseEntity<?> captureLoanDetails(@RequestBody LoanDetails loanDetails) {
		
		
		return ResponseEntity.ok("Loan application submitted");
	}


}
