package com.hcl.hackathon.dao;

import com.hcl.hackathon.domain.LoanDetails;

/**
 * Dao interface for Loan detail operations
 * @author admin
 */
public interface LoanDao {
	
	public void saveLoanDetails(LoanDetails loanDetails);
}
