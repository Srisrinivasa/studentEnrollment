package com.hcl.hackathon.dao.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.hcl.hackathon.constants.Constants;
import com.hcl.hackathon.dao.LoanDao;
import com.hcl.hackathon.domain.LoanDetails;
import com.hcl.hackathon.domain.LoanRowMapper;

/**
 * Implementation of Loan Dao 
 * @author admin
 *
 */
@Component
public class LoanDaoImpl implements LoanDao{

	private final JdbcTemplate jdbcTemplate; 
	
	@Autowired
	public LoanDaoImpl(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate=jdbcTemplate;
	}
	
	/**
	 * Method to save Load details 
	 */
	@Override
	public void saveLoanDetails(LoanDetails loanDetails) {
		 final java.sql.Date dateDB = new java.sql.Date(new Date().getTime());
		 final String loanDetailsData="insert into t_loan_details values(null,'"+loanDetails.getUserId()+"','"+loanDetails.getType()+"','"+loanDetails.getInterestRate()+"','"+
			     loanDetails.getTenure()+"','"+ loanDetails.getAmount()+"','"+ loanDetails.getUniversityName()+"','" +Constants.PENDING+"','"+dateDB+"');";
	     jdbcTemplate.update(loanDetailsData);  //inserting loan data in t_loan_details		
	}

	/**
	 *  Method to get all loan details applied by user
	 */
	@Override
	public List<LoanDetails> findLoanDetailsByUserId(String userId) {
		String query="select * from t_loan_details ud where ud.user_id = ?";
	    return jdbcTemplate.query(query, new Object[] {userId}, new LoanRowMapper()); 
	}

}
