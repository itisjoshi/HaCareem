package com.careem.engine.core.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.careem.engine.core.model.Driver;

public interface DriverRepository extends CrudRepository<Driver, Long> {

	@Query("SELECT driver FROM "
			+ "Driver driver "
			+ "LEFT JOIN FETCH driver.user user "
			+ "LEFT JOIN FETCH driver.cab cab "
			+ "WHERE driver.id = ?1")
	public Driver findById(Long id);
	
	@Query("SELECT driver FROM "
			+ "Driver driver "
			+ "LEFT JOIN FETCH driver.user user "
			+ "LEFT JOIN FETCH driver.cab cab")
	List<Driver> findAll();

}
