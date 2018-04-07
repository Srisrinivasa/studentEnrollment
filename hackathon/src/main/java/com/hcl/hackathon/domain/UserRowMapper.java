package com.hcl.hackathon.domain;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

/**
 * Store user related details
 * @author nitin
 *
 */
public class UserRowMapper implements RowMapper<UserDetails> {

	/**
	 * @param ResultSet
	 * @param int
	 */
	@Override
	public UserDetails mapRow(final ResultSet result, final int arg1) throws SQLException {
		
		final UserDetails user = new UserDetails();
		user.setId(result.getLong("id"));
		user.setFirstName(result.getString("firstName"));
		user.setMiddleName(result.getString("middleName"));
		user.setLastName(result.getString("lastName"));
		user.setGender(result.getString("gender"));
		user.setEmailId(result.getString("emailId"));
		user.setContactNo(result.getString("contactNo"));
		user.setAddressLine1(result.getString("addressLine1"));
		user.setAddressLine2(result.getString("addressLine2"));
		user.setCity(result.getString("city"));
		user.setState(result.getString("state"));
		user.setPincode(result.getString("pincode"));
		user.setDob(result.getString("dob"));
		user.setKycStatus(result.getString("kycStatus"));
		
		return user;
	}

}
