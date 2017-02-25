package com.careem.engine.core.repository;

import org.springframework.data.repository.CrudRepository;

import com.careem.engine.core.model.Booking;

public interface BookingRepository extends CrudRepository<Booking, Long> {

	public Booking findById(Long id);
	
}
