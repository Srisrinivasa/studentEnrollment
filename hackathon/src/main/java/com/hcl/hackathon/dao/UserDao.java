package com.hcl.hackathon.dao;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.hcl.hackathon.domain.Login;
import com.hcl.hackathon.domain.UserDetails;

/**
 * Dao class to perform Dao operations
 * @author admin
 *
 */
@Component
public class UserDao {
	
	private final JdbcTemplate jdbcTemplate;  
	  
	@Autowired
	public UserDao( JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate=jdbcTemplate;
	}
	
	/**
	 * Method to get login data
	 * @param login
	 * @return
	 */
	public String login(Login login){  
		String query="select u.role from t_user u where u.userId = ? and u.password = ?";
	    //return jdbcTemplate.queryForObject(query, new Object[] {login.getUserId(), login.getPassword()}, String.class);
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
	
	
	
}
