package com.icin.auth;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class RegistrationResponse {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long applicationNumber;
	private String message;
	public long getApplicationNumber() {
		return applicationNumber;
	}
	public void setApplicationNumber(long applicationNumber) {
		this.applicationNumber = applicationNumber;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
