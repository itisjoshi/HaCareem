package com.careem.engine.web.model;

import java.util.Date;

import com.careem.engine.core.model.CabType;
public class BookingModel {

	private Date lastDriveFinishedDate;

	private Long customerId;

	private Long driverId;

	public String preference;

	private Date lastDrive;

	public String bookingStatus;

	protected CabType cabType;
	
	public Long seatsCount;
		
	public String distanceTravelled;

	public String rating;

	public Double cost;

	public String costDenomination;

	public Double customerFromLatitude;
	
	public Double customerFromlongitude;

	public Double driverFromLatitude;
	
	public Double driverFromLongitude;

	public Double driverEndLatitude;
	
	public Double driverEndLongitude;

	public Date getLastDriveFinishedDate() {
		return lastDriveFinishedDate;
	}

	public void setLastDriveFinishedDate(Date lastDriveFinishedDate) {
		this.lastDriveFinishedDate = lastDriveFinishedDate;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public Long getDriverId() {
		return driverId;
	}

	public void setDriverId(Long driverId) {
		this.driverId = driverId;
	}

	public String getPreference() {
		return preference;
	}

	public void setPreference(String preference) {
		this.preference = preference;
	}

	public Date getLastDrive() {
		return lastDrive;
	}

	public void setLastDrive(Date lastDrive) {
		this.lastDrive = lastDrive;
	}

	public String getBookingStatus() {
		return bookingStatus;
	}

	public void setBookingStatus(String bookingStatus) {
		this.bookingStatus = bookingStatus;
	}

	public CabType getCabType() {
		return cabType;
	}

	public void setCabType(CabType cabType) {
		this.cabType = cabType;
	}

	public Long getSeatsCount() {
		return seatsCount;
	}

	public void setSeatsCount(Long seatsCount) {
		this.seatsCount = seatsCount;
	}

	public String getDistanceTravelled() {
		return distanceTravelled;
	}

	public void setDistanceTravelled(String distanceTravelled) {
		this.distanceTravelled = distanceTravelled;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public Double getCost() {
		return cost;
	}

	public void setCost(Double cost) {
		this.cost = cost;
	}

	public String getCostDenomination() {
		return costDenomination;
	}

	public void setCostDenomination(String costDenomination) {
		this.costDenomination = costDenomination;
	}

	public Double getCustomerFromLatitude() {
		return customerFromLatitude;
	}

	public void setCustomerFromLatitude(Double customerFromLatitude) {
		this.customerFromLatitude = customerFromLatitude;
	}

	public Double getCustomerFromlongitude() {
		return customerFromlongitude;
	}

	public void setCustomerFromlongitude(Double customerFromlongitude) {
		this.customerFromlongitude = customerFromlongitude;
	}

	public Double getDriverFromLatitude() {
		return driverFromLatitude;
	}

	public void setDriverFromLatitude(Double driverFromLatitude) {
		this.driverFromLatitude = driverFromLatitude;
	}

	public Double getDriverFromLongitude() {
		return driverFromLongitude;
	}

	public void setDriverFromLongitude(Double driverFromLongitude) {
		this.driverFromLongitude = driverFromLongitude;
	}

	public Double getDriverEndLatitude() {
		return driverEndLatitude;
	}

	public void setDriverEndLatitude(Double driverEndLatitude) {
		this.driverEndLatitude = driverEndLatitude;
	}

	public Double getDriverEndLongitude() {
		return driverEndLongitude;
	}

	public void setDriverEndLongitude(Double driverEndLongitude) {
		this.driverEndLongitude = driverEndLongitude;
	}

}
