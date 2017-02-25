package com.careem.engine.core.repository;

import java.util.Date;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.careem.engine.core.model.Booking;

public interface BookingRepository extends CrudRepository<Booking, Long> {

	public Booking findById(Long id);
	
	@Query("SELECT SUM(COST) FROM "
			+ "Booking booking WHERE booking.driverId = ?2"
			+ "AND booking.lastDriveFinishedDate = ?1")
	public double getDriverCurrentDayWage(Date date, Long driverId);
	
}
