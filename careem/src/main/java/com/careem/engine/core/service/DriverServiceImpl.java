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
		// TODO Auto-generated method stub
		return driverRepository.save(driver);
	}

	@Override
	public void delete(Driver driver) {
		// TODO Auto-generated method stub
		driverRepository.save(driver);
	}

	@Override
	public List<Driver> findAll() {
		// TODO Auto-generated method stub
		return (List<Driver>) driverRepository.findAll();
	}

	@Override
	public Driver findById(Long id) {
		// TODO Auto-generated method stub
		return driverRepository.findById(id);
	}

}
