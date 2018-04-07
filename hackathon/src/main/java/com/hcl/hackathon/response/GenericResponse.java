package com.hcl.hackathon.response;

/**
 * 
 * @author nitin
 *
 */
public class GenericResponse {
	private String message;
	private String role;
	
	public GenericResponse(String message, String role) {
		this.message = message;
		this.role = role;
	}
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	
}
