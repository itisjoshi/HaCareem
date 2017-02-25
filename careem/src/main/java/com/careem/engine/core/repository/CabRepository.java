package com.careem.engine.core.repository;

import org.springframework.data.repository.CrudRepository;

import com.careem.engine.core.model.Cab;

public interface CabRepository extends CrudRepository<Cab, Long> {

	public Cab findById(Long id);
	
}
