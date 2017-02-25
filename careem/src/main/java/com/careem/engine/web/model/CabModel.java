package com.careem.engine.web.model;

import com.careem.engine.core.model.CabType;

public class CabModel {

	Long cabId;
	
	public Long getCabId() {
		return cabId;
	}

	public void setCabId(Long cabId) {
		this.cabId = cabId;
	}

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
