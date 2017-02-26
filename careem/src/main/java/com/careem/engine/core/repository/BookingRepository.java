package com.careem.engine.core.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.careem.engine.core.model.Booking;
import com.careem.engine.core.model.Driver;

public interface BookingRepository extends CrudRepository<Booking, Long> {

	@Query("SELECT booking FROM "
			+ "Booking booking "
			+ "LEFT JOIN FETCH booking.driver driver "
			+ "LEFT JOIN FETCH driver.cab cab "
			+ "LEFT JOIN FETCH booking.customer customer "
			+ "WHERE booking.id = ?1")
	public Booking findById(Long id);
	
	@Query("SELECT booking FROM "
			+ "Booking booking "
			+ "LEFT JOIN FETCH booking.driver driver "
			+ "LEFT JOIN FETCH driver.cab cab "
			+ "LEFT JOIN FETCH booking.customer customer "
			+ "WHERE driver.id = ?2 "
			+ "AND booking.lastDriveFinishedDate = ?1")
	public List<Booking> getDriverCurrentDayWage(Date date, Long driverId);

	@Query("SELECT booking FROM "
			+ "Booking booking "
			+ "LEFT JOIN FETCH booking.driver driver "
			+ "LEFT JOIN FETCH driver.cab cab "
			+ "LEFT JOIN FETCH booking.customer customer "
			+ "WHERE driver = ?1")
	public List<Booking> findByDriver(Driver driver);
	
}