package com.careem.engine.core.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.careem.engine.core.model.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

	public Customer findById(Long id);
	
	@Query("SELECT customer FROM "
		    + "Customer customer "
		    + "LEFT JOIN FETCH customer.user user")
	List<Customer> findAll();
}
