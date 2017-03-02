package com.careem.engine.core.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.careem.engine.core.model.Driver;
import com.careem.engine.core.repository.DriverRepository;

@Service("DriverService")
@Repository
@Transactional

public class DriverServiceImpl implements DriverService {

	@Autowired
	private DriverRepository driverRepository;
	
	@Override
	public Driver save(Driver driver) {
		return driverRepository.save(driver);
	}

	@Override
	public void delete(Driver driver) {
		driverRepository.save(driver);
	}

	@Override
	public List<Driver> findAll() {
		return (List<Driver>) driverRepository.findAll();
	}

	@Override
	public Driver findById(Long id) {
		return driverRepository.findById(id);
	}
}