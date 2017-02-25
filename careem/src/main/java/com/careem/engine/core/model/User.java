package com.careem.engine.core.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Entity
@Table(name = "USER")
@JsonInclude(Include.NON_EMPTY)
public class User extends AbstractEntity {
	
	private static final long serialVersionUID = 144659313932704942L;
	
	@Column(name = "NAME", length = 250)
	public String name;
	
	@Column(name = "EMAIL", length = 250)
	public String email;

	@Column(name = "GENDER", length = 250)
	public String gender;

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
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
}