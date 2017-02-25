package com.careem.engine.core.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.careem.engine.core.model.Cab;
import com.careem.engine.core.repository.CabRepository;

@Service("CabService")
@Repository
@Transactional

public class CabServiceImpl implements CabService {

	@Autowired
	private CabRepository cabRepository;
	
	@Override
	public Cab save(Cab cab) {
		return cabRepository.save(cab);
	}

	@Override
	public void delete(Cab cab) {
		cabRepository.save(cab);
	}

	@Override
	public List<Cab> findAll() {
		return (List<Cab>) cabRepository.findAll();
	}

	@Override
	public Cab findById(Long id) {
		return cabRepository.findById(id);
	}
}