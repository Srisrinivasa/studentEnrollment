package com.hcl.hackathon.dao.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.hcl.hackathon.constants.Constants;
import com.hcl.hackathon.dao.LoanDao;
import com.hcl.hackathon.domain.LoanDetails;

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
	
	@Override
	public void saveLoanDetails(LoanDetails loanDetails) {
		 final java.sql.Date dateDB = new java.sql.Date(new Date().getTime());
		 final String loanDetailsData="insert into t_loan_details values(null,'"+loanDetails.getUserId()+"','"+loanDetails.getType()+"','"+loanDetails.getInterestRate()+"','"+
			     loanDetails.getTenure()+"','"+ loanDetails.getAmount()+"','"+ loanDetails.getUniversityName()+"','" +Constants.PENDING+"','"+dateDB+"');";
	     jdbcTemplate.update(loanDetailsData);  //inserting loan data in t_loan_details		
	}

}
