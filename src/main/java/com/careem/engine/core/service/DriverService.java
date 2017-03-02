package com.careem.engine.core.service;

import java.util.List;

import com.careem.engine.core.model.Driver;

public interface DriverService {
	public Driver save(Driver Driver);
	public void delete(Driver Driver);
	public List<Driver> findAll();
	public Driver findById(Long id);
}
