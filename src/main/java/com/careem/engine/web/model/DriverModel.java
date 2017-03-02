package com.careem.engine.web.model;

import java.util.Date;

import com.careem.engine.core.model.CabType;

public class DriverModel {

	public Long driverId;
	
	public String bookingStatus;

	private Date lastDriveFinishedDate;

	public Long userId;
	
	public String name;
	
	public String email;

	private Long cabid;
	
	private Long seatsCount;
	
	public Long getSeatsCount() {
		return seatsCount;
	}

	public void setSeatsCount(Long seatsCount) {
		this.seatsCount = seatsCount;
	}

	private CabType cabType;
	
	public String gender;

	public String rating;

	public Double latitude;
	
	public Double longitude;

	public Long getDriverId() {
		return driverId;
	}

	public void setDriverId(Long driverId) {
		this.driverId = driverId;
	}

	public String getBookingStatus() {
		return bookingStatus;
	}

	public void setBookingStatus(String bookingStatus) {
		this.bookingStatus = bookingStatus;
	}

	public Date getLastDriveFinishedDate() {
		return lastDriveFinishedDate;
	}

	public void setLastDriveFinishedDate(Date lastDriveFinishedDate) {
		this.lastDriveFinishedDate = lastDriveFinishedDate;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
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

	public Long getCabid() {
		return cabid;
	}

	public void setCabid(Long cabid) {
		this.cabid = cabid;
	}

	public CabType getCabType() {
		return cabType;
	}

	public void setCabType(CabType cabType) {
		this.cabType = cabType;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}
}