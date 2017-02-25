package com.careem.engine.core.service;

import java.util.List;

import com.careem.engine.core.model.Booking;

public interface BookingService {
	public Booking save(Booking Booking);
	public void delete(Booking Booking);
	public List<Booking> findAll();
	public Booking findById(Long id);
}
