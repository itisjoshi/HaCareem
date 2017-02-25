package com.careem.engine.core.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Entity
@Table(name = "CAB")
@JsonInclude(Include.NON_EMPTY)
public class Cab extends AbstractEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6478353021149710915L;


	@Enumerated(value = EnumType.STRING)
	@Column(name = "CABTYPE")
	protected CabType cabType;
	
	@Column(name = "SEATSCOUNT")
	public Long seatsCount;

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

	
}
