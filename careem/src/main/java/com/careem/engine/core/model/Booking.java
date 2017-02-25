package com.careem.engine.core.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Entity
@Table(name = "BOOKING")
@JsonInclude(Include.NON_EMPTY)
public class Booking extends AbstractEntity {

	private static final long serialVersionUID = -1547980297528908216L;

	@Column(name = "LASTDRIVEFINISHEDDATE")
	private Date lastDriveFinishedDate;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CUSTOMERID")
	@JsonBackReference(value="booking-customer")
	private Customer customer;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "DRIVERID")
	@JsonBackReference(value="booking-driver")
	private Driver driver;
	
	@Column(name = "DISTANCETRAVELLED", length = 250)
	public String distanceTravelled;

	@Column(name = "RATING", length = 250)
	public String rating;

	@Column(name = "COST")
	public Double cost;

	@Column(name = "COSTDENOMINATION", length = 250)
	public String costDenomination;

	@Column(name = "CUSTOMERFROMLATITUDE")
	public Double customerFromLatitude;
	
	@Column(name = "CUSTOMERFROMLONGITUDE")
	public Double customerFromlongitude;

	@Column(name = "DRIVERFROMLATITUDE")
	public Double driverFromLatitude;
	
	@Column(name = "DRIVERFROMLONGITUDE")
	public Double driverFromLongitude;

	@Column(name = "DRIVERENDLATITUDE")
	public Double driverEndLatitude;
	
	@Column(name = "DRIVERENDLONGITUDE")
	public Double driverEndLongitude;

	public Date getLastDriveFinishedDate() {
		return lastDriveFinishedDate;
	}

	public void setLastDriveFinishedDate(Date lastDriveFinishedDate) {
		this.lastDriveFinishedDate = lastDriveFinishedDate;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Driver getDriver() {
		return driver;
	}

	public void setDriver(Driver driver) {
		this.driver = driver;
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