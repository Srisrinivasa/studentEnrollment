package com.hcl.hackathon.domain;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Domain class for Loan Details
 * @author admin
 *
 */
public class LoanDetails {

	Long id;
	String userId;
	String interestRate;
	String tenure;
	String amount;
	String university_name;
	String loan_status;
	
	Date loan_apply_date;
	
	public Long getId() {
		return id;
	}
	
	@JsonIgnore
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getInterestRate() {
		return interestRate;
	}
	public void setInterestRate(String interestRate) {
		this.interestRate = interestRate;
	}
	public String getTenure() {
		return tenure;
	}
	public void setTenure(String tenure) {
		this.tenure = tenure;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getUniversity_name() {
		return university_name;
	}
	public void setUniversity_name(String university_name) {
		this.university_name = university_name;
	}
	public String getLoan_status() {
		return loan_status;
	}
	
	public void setLoan_status(String loan_status) {
		this.loan_status = loan_status;
	}
	
	public Date getLoan_apply_date() {
		return loan_apply_date;
	}
	
	@JsonIgnore
	public void setLoan_apply_date(Date loan_apply_date) {
		this.loan_apply_date = loan_apply_date;
	}
	
}
