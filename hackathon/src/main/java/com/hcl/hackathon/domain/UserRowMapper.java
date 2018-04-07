package com.hcl.hackathon.domain;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class UserRowMapper implements RowMapper<UserDetails> {

	@Override
	public UserDetails mapRow(ResultSet rs, int arg1) throws SQLException {
		
		UserDetails user = new UserDetails();
		user.setId(rs.getLong("id"));
		user.setFirstName(rs.getString("firstName"));
		user.setMiddleName(rs.getString("middleName"));
		user.setFirstName(rs.getString("lastName"));
		user.setGender(rs.getString("gender"));
		user.setEmailId(rs.getString("emailId"));
		user.setContactNo(rs.getString("contactNo"));
		user.setAddressLine1(rs.getString("addressLine1"));
		user.setAddressLine2(rs.getString("addressLine2"));
		user.setCity(rs.getString("city"));
		user.setState(rs.getString("state"));
		user.setPincode(rs.getString("pincode"));
		user.setDob(rs.getString("dob"));
		user.setKYCStatus(rs.getString("KYCStatus"));
		
		return user;
	}

}
