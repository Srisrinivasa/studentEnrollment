package com.hcl.hackathon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.hackathon.dao.LoanDao;
import com.hcl.hackathon.domain.LoanDetails;


/**
 * REST Controller for Loan REST APIs
 * @author admin
 *
 */
@CrossOrigin
@RestController
@RequestMapping(value="/loan")
public class LoanController {
	
	private final LoanDao loanDao;
	
	@Autowired
	public LoanController(LoanDao loanDao) {
		this.loanDao=loanDao;
	}
	
	/**
	 * Method to capture Loan details
	 * @param loanDetails
	 * @return
	 */
	@PostMapping("/captureDetails")
	public ResponseEntity<?> captureLoanDetails(@RequestBody LoanDetails loanDetails) {
		loanDao.saveLoanDetails(loanDetails);//inserting loan details for a user
		return ResponseEntity.status(HttpStatus.CREATED).body("Loan application submitted !");
	}
	
	/**
	 * Method to get Loan details for user
	 * @param loanDetails
	 * @return
	 */
   @GetMapping("/details")
   public ResponseEntity<?> getLoanDetails(@RequestHeader(value="userId") String userId) {
		return ResponseEntity.ok(loanDao.findLoanDetailsByUserId(userId));//getting all loan details of user
	}

}
