package com.hcl.hackathon.dao;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.hcl.hackathon.constants.Constants;
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
	
	private final JdbcTemplate jdbcTemplate;  
	  
	@Autowired
	public UserDaoImpl( JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate=jdbcTemplate;
	}
	
	/**
	 * Method to get login data
	 * @param login
	 * @return
	 */
	public String login(Login login){  
		String query="select u.role from t_user u where u.userId = ? and u.password = ?";
	    List<String> roles = jdbcTemplate.queryForList(query, new Object[] {login.getUserId(), login.getPassword()},String.class); 
	    if (roles.isEmpty()) {
	        return null;
	    } else {
	        return roles.get(0);
	    }
	}

	/**
	 * Method to save user data
	 * @param user
	 * @throws ParseException
	 */
	public void saveUserDetails(UserDetails user) throws ParseException{  
		final java.util.Date dateStr = new SimpleDateFormat("yyyy-MM-dd").parse(user.getDob());
		final java.sql.Date dateDB = new java.sql.Date(dateStr.getTime());
	    final String userDetailsData="insert into t_userdetails values(null,'"+user.getFirstName()+"','"+user.getMiddleName()+"','"+user.getLastName()+"','"+
	     user.getAddressLine1()+"','"+ user.getAddressLine2()+"','"+ user.getCity()+"','" +user.getState()+"','" +user.getPincode()+
	     "','" +user.getContactNo()+"','"+dateDB+"','" +user.getEmailId()+"','" +user.getGender()+"','" +user.getKYCStatus()+"');";
	    jdbcTemplate.update(userDetailsData);  //inserting registration data in user details
	    System.out.println("userdetails===>"+userDetailsData);//TODO to be removed
	    final String loginDetailsData="insert into t_user values('"+user.getEmailId()+"','"+user.getPassword()+"','USER');";
	    System.out.println("logindetailsdata===>"+loginDetailsData);//TODO to be removed
	    jdbcTemplate.update(loginDetailsData);  //inserting login data
	}  
	
	/**
	 * Method is used to get all pending kyc user details
	 * @return List<UserDetails>
	 */
	public List<UserDetails> findPendingKycUsers(){  
		String query="select * from t_userdetails ud where ud.KYCStatus = ?";
	    return jdbcTemplate.query(query, new Object[] {Constants.PENDING}, new UserRowMapper()); 
	}
	
	/**
	 * 
	 * @param kycStatus
	 * @param id
	 */
	public void updateKycStatus(String kycStatus, Long id){  
		String query="update t_userdetails ud set ud.KYCStatus = ? where ud.id = ?";
	    jdbcTemplate.update(query, new Object[] {kycStatus, id}); 
	}
	
	/**
	 * Method to find User Details
	 * @param emailId
	 * @return UserDetails
	 */
	public UserDetails findByUserId(String emailId){
		String query="select * from t_userdetails ud where ud.emailId = ?";
		List<UserDetails> userDetails = jdbcTemplate.query(query, new Object[] {emailId}, new UserRowMapper()); 
		if(userDetails!=null && !userDetails.isEmpty()){
			 return userDetails.get(0);
		}else{
			return null;
		}
	}
	
}
