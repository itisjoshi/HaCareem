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
@Table(name = "CUSTOMER")
@JsonInclude(Include.NON_EMPTY)
public class Customer extends AbstractEntity {

	private static final long serialVersionUID = -1547980297528908216L;

	@Column(name = "PREFERENCE", length = 250)
	public String preference;

	@Column(name = "LASTDRIVE")
	private Date lastDrive;

	@OneToOne(targetEntity = User.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "USERID", referencedColumnName = "ID")
	private User user;
	
	@OneToMany(mappedBy="customer")
	private Set<Booking> bookings;
	
	public Set<Booking> getBookings() {
		return bookings;
	}

	public void setBookings(Set<Booking> bookings) {
		this.bookings = bookings;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
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
}