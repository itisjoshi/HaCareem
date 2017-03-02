package com.careem.engine.core.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.careem.engine.core.model.User;

public interface UserRepository extends CrudRepository<User, Long> {

	public User findById(Long id);
	
	public List<User> findAll();
}
