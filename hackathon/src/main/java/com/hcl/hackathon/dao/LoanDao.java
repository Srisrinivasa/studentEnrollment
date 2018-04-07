package com.hcl.hackathon.dao;

import java.util.List;

import com.hcl.hackathon.domain.LoanDetails;

/**
 * Dao interface for Loan detail operations
 * @author admin
 */
public interface LoanDao {
	
	public void saveLoanDetails(LoanDetails loanDetails);
	public List<LoanDetails> findLoanDetailsByUserId(String userId);
}
