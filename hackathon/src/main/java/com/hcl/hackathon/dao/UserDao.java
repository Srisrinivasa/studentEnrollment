package com.hcl.hackathon.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.hcl.hackathon.domain.UserDetails;

@Component
public class UserDao {
	
	private final JdbcTemplate jdbcTemplate;  
	  
	@Autowired
	public UserDao( JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate=jdbcTemplate;
	}
	
	public int saveUserDetails(UserDetails user){  
		
	    String query="insert into t_userdetails values('"+user.getFirstName()+"','"+user.getMiddleName()+"','"+user.getLastName()+"','"+
	     user.getAddressLine1()+"','"+ user.getAddressLine2()+"','"+ user.getCity()+"','" +user.getState()+"','" +user.getPincode()+
	     "','" +user.getContactNo()+"','" +user.getDob()+"','" +user.getEmailId()+"','" +user.getGender()+"','" +user.getPassword()+"');";
	    
	    System.out.println("===>"+query);
	    return jdbcTemplate.update(query);  
	}  
}
