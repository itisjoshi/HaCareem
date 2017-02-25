package com.careem.engine.core.service;

import java.util.List;

import com.careem.engine.core.model.Customer;

public interface CustomerService {
	public Customer save(Customer Customer);
	public void delete(Customer Customer);
	public List<Customer> findAll();
	public Customer findById(Long id);
}
