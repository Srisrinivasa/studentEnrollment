package com.hcl.hackathon.response;

/**
 * 
 * @author nitin
 *
 */
public class GenericResponse {
	
	/**
	 * response message
	 */
	private String message;
	
	/**
	 * user role
	 */
	private String role;
	
	/**
	 * 
	 * @param message
	 * @param role
	 */
	public GenericResponse(final String message, final String role) {
		this.message = message;
		this.role = role;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getMessage() {
		return message;
	}
	
	/**
	 * 
	 * @param message
	 */
	public void setMessage(final String message) {
		this.message = message;
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
