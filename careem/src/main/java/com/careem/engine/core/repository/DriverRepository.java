package com.careem.engine.core.repository;

import org.springframework.data.repository.CrudRepository;

import com.careem.engine.core.model.Driver;

public interface DriverRepository extends CrudRepository<Driver, Long> {

	public Driver findById(Long id);
	
}
