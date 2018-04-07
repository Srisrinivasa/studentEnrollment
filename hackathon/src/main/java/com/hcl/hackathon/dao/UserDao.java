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

	public String login(Login login);
	public void saveUserDetails(UserDetails user) throws ParseException;
	public List<UserDetails> findPendingKycUsers();
	public void updateKycStatus(String kycStatus, Long id);
	public UserDetails findByUserId(String emailId);
}
