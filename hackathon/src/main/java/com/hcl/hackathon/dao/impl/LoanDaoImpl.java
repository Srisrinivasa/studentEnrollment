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

	/**
	 * JdbcTemplate used to execute database queries
	 */
	private final JdbcTemplate jdbcTemplate; 
	
	/**
	 * 
	 * @param jdbcTemplate
	 */
	@Autowired
	public LoanDaoImpl(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate=jdbcTemplate;
	}
	
	/**
	 * Method to save Load details 
	 */
	@Override
	public void saveLoanDetails(final LoanDetails loanDetails) {
		 final java.sql.Date dateDB = new java.sql.Date(new Date().getTime());
		 final String loanDetailsData="insert into t_loan_details values(null,'"+loanDetails.getUserId()+"','"+loanDetails.getType()+"','"+loanDetails.getInterestRate()+"','"+
			     loanDetails.getTenure()+"','"+ loanDetails.getAmount()+"','"+ loanDetails.getUniversityName()+"','" +Constants.PENDING+"','"+dateDB+"','"+loanDetails.getEmi()+"');";
	     jdbcTemplate.update(loanDetailsData);  //inserting loan data in t_loan_details		
	}

	/**
	 *  Method to get all loan details applied by user
	 */
	@Override
	public List<LoanDetails> findLoanDetailsByUserId(final String userId) {
		String query= "";
		String parameter = "";
		if (userId != null && !userId.isEmpty()) {
			query="select * from t_loan_details ud where ud.user_id = ?";
			parameter = userId;
		} else {
			query="select * from t_loan_details ud where ud.loan_status = ?";
			parameter = Constants.PENDING;
		}
	    return jdbcTemplate.query(query, new Object[] {parameter}, new LoanRowMapper()); 
	}

	/**
	 * Method to update loan status
	 * @param loanStatus
	 * @param loanId
	 */
	@Override
	public void updateLoanStatus(final String loanStatus, final Long loanId) {
		String query="update t_loan_details ld set ld.loan_status = ? where ld.id = ?";
	    jdbcTemplate.update(query, new Object[] {loanStatus, loanId});
	}

}
