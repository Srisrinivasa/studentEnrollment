package com.hcl.hackathon.dao.impl;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.hcl.hackathon.constants.Constants;
import com.hcl.hackathon.dao.UserDao;
import com.hcl.hackathon.domain.Login;
import com.hcl.hackathon.domain.UserDetails;
import com.hcl.hackathon.domain.UserRowMapper;

/**
 * Dao class to perform Dao operations
 * @author admin
 *
 */
@Component
public class UserDaoImpl implements UserDao{
	
	/**
	 * JdbcTemplate used to execute database queries
	 */
	private final JdbcTemplate jdbcTemplate;  
	
	/**
	 * 
	 * @param jdbcTemplate
	 */
	@Autowired
	public UserDaoImpl(final JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate=jdbcTemplate;
	}
	
	/**
	 * Method to get login data
	 * @param login
	 * @return
	 */
	public String login(final Login login){  
		String query="select u.role from t_user u where u.userId = ? and u.password = ?";
	    final List<String> roles = jdbcTemplate.queryForList(query, new Object[] {login.getUserId(), login.getPassword()},String.class); 
	    return roles.isEmpty() ? "" : roles.get(0);
	}

	/**
	 * Method to save user data
	 * @param user
	 * @throws ParseException
	 */
	public void saveUserDetails(final UserDetails user) throws ParseException{  
		final java.util.Date dateStr = new SimpleDateFormat("yyyy-MM-dd").parse(user.getDob());
		final java.sql.Date dateDB = new java.sql.Date(dateStr.getTime());
	    final String userDetailsData="insert into t_userdetails values(null,'"+user.getFirstName()+"','"+user.getMiddleName()+"','"+user.getLastName()+"','"+
	     user.getAddressLine1()+"','"+ user.getAddressLine2()+"','"+ user.getCity()+"','" +user.getState()+"','" +user.getPincode()+
	     "','" +user.getContactNo()+"','"+dateDB+"','" +user.getEmailId()+"','" +user.getGender()+"','" +user.getKYCStatus()+"');";
	    jdbcTemplate.update(userDetailsData);  //inserting registration data in user details
	    final String loginDetailsData="insert into t_user values('"+user.getEmailId()+"','"+user.getPassword()+"','USER');";
	    jdbcTemplate.update(loginDetailsData);  //inserting login data
	}  
	
	/**
	 * Method is used to get all pending kyc user details
	 * @return List<UserDetails>
	 */
	public List<UserDetails> findPendingKycUsers(){  
		String query="select * from t_userdetails ud where ud.kycStatus = ?";
	    return jdbcTemplate.query(query, new Object[] {Constants.PENDING}, new UserRowMapper()); 
	}
	
	/**
	 * 
	 * @param kycStatus
	 * @param id
	 */
	public void updateKycStatus(final String kycStatus, final Long userId){  
		String query="update t_userdetails ud set ud.kycStatus = ? where ud.id = ?";
	    jdbcTemplate.update(query, new Object[] {kycStatus, userId}); 
	}
	
	/**
	 * Method to find User Details
	 * @param emailId
	 * @return UserDetails
	 */
	public UserDetails findByUserId(final String emailId){
		String query="select * from t_userdetails ud where ud.emailId = ?";
		final List<UserDetails> userDetails = jdbcTemplate.query(query, new Object[] {emailId}, new UserRowMapper()); 
		if(userDetails!=null && !userDetails.isEmpty()){
			 return userDetails.get(0);
		}else{
			return null;
		}
	}
	
}
