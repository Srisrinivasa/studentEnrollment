package com.hcl.hackathon.domain;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

/**
 * LoanRowMapper for LoanDetails
 * @author admin
 *
 */

public class LoanRowMapper implements RowMapper<LoanDetails> {

	@Override
	public LoanDetails mapRow(ResultSet rs, int arg1) throws SQLException {
		
		LoanDetails loanDetails = new LoanDetails();
		loanDetails.setId(rs.getLong("id"));
		loanDetails.setAmount(rs.getString("amount"));
		loanDetails.setEmi(rs.getString("emi"));
		loanDetails.setInterestRate(rs.getString("interest_rate"));
		loanDetails.setLoanApplyDate(rs.getDate("loan_apply_date"));
		loanDetails.setLoanStatus(rs.getString("loan_status"));
		loanDetails.setTenure(rs.getString("tenure"));
		loanDetails.setUserId(rs.getString("user_id"));
		loanDetails.setUniversityName(rs.getString("university_name"));
		loanDetails.setType(rs.getString("type"));
		return loanDetails;
	}

}