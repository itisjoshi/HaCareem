package com.careem.engine.web.model;

public class CustomerModel {

	public String preference;

	public Long customerId;
	
	public String name;
	
	public String email;

	public String gender;

	public Long userId;

	public String driverGender;

	public String getDriverGender() {
		return driverGender;
	}

	public void setDriverGender(String driverGender) {
		this.driverGender = driverGender;
	}

	public String getPreference() {
		return preference;
	}

	public void setPreference(String preference) {
		this.preference = preference;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}
}