package com.hcl.hackathon.dao;

import java.util.List;

import com.hcl.hackathon.domain.LoanDetails;

/**
 * Dao interface for Loan detail operations
 * @author admin
 */
public interface LoanDao {
	
	/**
	 * 
	 * @param loanDetails
	 */
	void saveLoanDetails(LoanDetails loanDetails);
	
	/**
	 * 
	 * @param userId
	 * @return List<LoanDetails>
	 */
	List<LoanDetails> findLoanDetailsByUserId(String userId);
	
	/**
	 * 
	 * @param loanStatus
	 * @param loanId
	 */
	void updateLoanStatus(String loanStatus, Long loanId);
}
