package com.careem.engine.core.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Entity
@Table(name = "DRIVER")
@JsonInclude(Include.NON_EMPTY)
public class Driver extends AbstractEntity {

	private static final long serialVersionUID = -1547980297528908216L;

	@Column(name = "BOOKINGSTATUS", length = 250)
	public String bookingStatus;

	@Column(name = "LASTDRIVEFINISHEDDATE")
	private Date lastDriveFinishedDate;

	@OneToOne
	@JoinColumn(name = "USERID")
	private User user;
	
	@OneToOne(targetEntity=Cab.class,cascade=CascadeType.ALL)
	@JoinColumn(name="CABID",referencedColumnName="ID")
	private Cab cab;
	
	@Column(name = "GENDER", length = 250)
	public String gender;

	@Column(name = "RATING", length = 250)
	public String rating;

	@Column(name = "LATITUDE")
	public Double latitude;
	
	@Column(name = "LONGITUDE")
	public Double longitude;

	@OneToMany(mappedBy="driver")
	private Set<Booking> bookings;
	
	public Set<Booking> getBookings() {
		return bookings;
	}

	public void setBookings(Set<Booking> bookings) {
		this.bookings = bookings;
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Cab getCab() {
		return cab;
	}

	public void setCab(Cab cab) {
		this.cab = cab;
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
}