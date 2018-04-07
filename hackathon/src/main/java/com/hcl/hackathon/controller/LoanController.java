package com.hcl.hackathon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.hackathon.dao.LoanDao;
import com.hcl.hackathon.domain.LoanDetails;

@CrossOrigin
@RestController
@RequestMapping(value="/loan")
public class LoanController {
	
	@Autowired
	private LoanDao loanDao;
	
	@PostMapping("/captureDetails")
	public ResponseEntity<?> captureLoanDetails(@RequestBody LoanDetails loanDetails) {
		loanDao.saveLoanDetails(loanDetails);
		return ResponseEntity.ok("Loan application submitted");
	}


}
