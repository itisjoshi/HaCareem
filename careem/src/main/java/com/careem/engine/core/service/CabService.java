package com.careem.engine.core.service;

import java.util.List;

import com.careem.engine.core.model.Cab;

public interface CabService {
	public Cab save(Cab Cab);
	public void delete(Cab Cab);
	public List<Cab> findAll();
	public Cab findById(Long id);
}
