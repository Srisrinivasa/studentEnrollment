package com.hcl.hackathon.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;

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
	
	public int saveUserDetails(UserDetails user) throws ParseException{  
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd"); 
		java.util.Date dateStr = formatter.parse(user.getDob());
		java.sql.Date dateDB = new java.sql.Date(dateStr.getTime());
	    String query="insert into bankDB.t_userdetails values(null,'"+user.getFirstName()+"','"+user.getMiddleName()+"','"+user.getLastName()+"','"+
	     user.getAddressLine1()+"','"+ user.getAddressLine2()+"','"+ user.getCity()+"','" +user.getState()+"','" +user.getPincode()+
	     "','" +user.getContactNo()+"','"+dateDB+"','" +user.getEmailId()+"','" +user.getGender()+"','" +user.getPassword()+"');";
	    
	    System.out.println("===>"+query);
	    return jdbcTemplate.update(query);  
	}  
}
