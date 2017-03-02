package com.careem.engine.core.service;

import java.util.List;

import com.careem.engine.core.model.User;

public interface UserService {
	public User save(User User);
	public void delete(User User);
	public List<User> findAll();
	public User findById(Long id);
}
