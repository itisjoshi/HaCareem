package com.careem.engine.web.model;

import com.careem.engine.core.model.CabType;

public class CabModel {

	protected CabType cabType;
	
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
