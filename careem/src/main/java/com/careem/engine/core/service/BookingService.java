package com.careem.engine.core.service;

import java.util.Date;
import java.util.List;

import com.careem.engine.core.model.Booking;
import com.careem.engine.core.model.Driver;

public interface BookingService {
	public Booking save(Booking Booking);
	public void delete(Booking Booking);
	public List<Booking> findAll();
	public Booking findById(Long id);
	public double getDriverCurrentDayWage(Date date, Long driverId);
	public List<Booking> findByDriver(Driver driver);
}