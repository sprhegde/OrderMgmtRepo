package com.ordermgmt.notification.domain;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

public class User {

	@NotNull
	@Length(min = 3, max = 20)
	private String username;
	
	private String customerName;
	
	private String email;
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
