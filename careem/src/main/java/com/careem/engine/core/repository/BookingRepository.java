package com.careem.engine.core.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.careem.engine.core.model.Booking;
import com.careem.engine.core.model.Driver;

public interface BookingRepository extends CrudRepository<Booking, Long> {

	public Booking findById(Long id);
	
	@Query("SELECT booking FROM "
			+ "Booking booking "
			+ "LEFT JOIN FETCH booking.driver driver "
			+ "WHERE driver.id = ?2 "
			+ "AND booking.lastDriveFinishedDate = ?1")
	public List<Booking> getDriverCurrentDayWage(Date date, Long driverId);

	public List<Driver> findByDriver(Driver driver);
	
}
