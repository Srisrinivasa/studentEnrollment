package com.hcl.hackathon.domain;

/**
 * 
 * @author admin
 *
 */
public class Login {
	private String userId;
	private String password;
	private String role;
	
	/**
	 * 
	 * @return
	 */
	public String getUserId() {
		return userId;
	}
	
	/**
	 * 
	 * @param userId
	 */
	public void setUserId(final String userId) {
		this.userId = userId;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getPassword() {
		return password;
	}
	
	/**
	 * 
	 * @param password
	 */
	public void setPassword(final String password) {
		this.password = password;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getRole() {
		return role;
	}
	
	/**
	 * 
	 * @param role
	 */
	public void setRole(final String role) {
		this.role = role;
	}
	
	
}
