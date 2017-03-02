package com.careem.engine.web.model;

import com.careem.engine.core.model.User;

public class UserModel {

	private Long userId;
	
	private String name;
	
	private String email;
	
	public UserModel() {
	}

	public UserModel(Long id, String email2, String name2) {
		this.userId = id;
		this.email = email2;
		this.name = name2;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public UserModel UserToUserModelConvertor(User user) {
		return new UserModel(user.getId(), user.getEmail(), user.getName());
	}
	
	public User UserModelToUserConvertor(UserModel userModel) {
		User user = new User();
		user.setEmail(userModel.getEmail());
		user.setId(userModel.getUserId());
		user.setName(userModel.getName());
		return user;
	}
}