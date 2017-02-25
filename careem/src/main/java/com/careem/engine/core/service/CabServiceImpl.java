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
		// TODO Auto-generated method stub
		return cabRepository.save(cab);
	}

	@Override
	public void delete(Cab cab) {
		// TODO Auto-generated method stub
		cabRepository.save(cab);
	}

	@Override
	public List<Cab> findAll() {
		// TODO Auto-generated method stub
		return (List<Cab>) cabRepository.findAll();
	}

	@Override
	public Cab findById(Long id) {
		// TODO Auto-generated method stub
		return cabRepository.findById(id);
	}

}
