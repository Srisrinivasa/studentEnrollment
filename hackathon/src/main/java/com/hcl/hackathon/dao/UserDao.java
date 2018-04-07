package com.hcl.hackathon.dao;

import java.text.ParseException;
import java.util.List;

import com.hcl.hackathon.domain.Login;
import com.hcl.hackathon.domain.UserDetails;

/**
 * Dao interface for User detail operations
 * @author admin
 */

public interface UserDao {

	/**
	 * 
	 * @param login
	 * @return
	 */
	String login(Login login);
	
	/**
	 * 
	 * @param user
	 * @throws ParseException
	 */
	void saveUserDetails(UserDetails user) throws ParseException;
	
	/**
	 * 
	 * @return
	 */
	List<UserDetails> findPendingKycUsers();
	
	/**
	 * 
	 * @param kycStatus
	 * @param userId
	 */
	void updateKycStatus(String kycStatus, Long userId);
	
	/**
	 * 
	 * @param emailId
	 * @return
	 */
	UserDetails findByUserId(String emailId);
}
