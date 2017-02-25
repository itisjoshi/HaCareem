package com.careem.engine.web.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.careem.engine.core.model.User;
import com.careem.engine.core.service.UserService;
import com.careem.engine.web.model.UserModel;

@Component
public class UserWebService {

	@Autowired
	private UserService userService;

	public List<UserModel> getAllUsers() {
		List<UserModel> userModels = new ArrayList<>();
		List<User> users = userService.findAll();
		Iterator<User> userIterator = users.iterator();
		while(userIterator.hasNext()) {
			UserModel userModel = new UserModel().UserToUserModelConvertor(userIterator.next());
			userModels.add(userModel);
		}
		return userModels;
	}

	public UserModel createUser(UserModel userModel) {
		User user = new UserModel().UserModelToUserConvertor(userModel);
		user = userService.save(user);
		return new UserModel().UserToUserModelConvertor(user);
	}

	public UserModel editUser(UserModel userModel) {
		User user = new UserModel().UserModelToUserConvertor(userModel);
		user = userService.save(user);
		return new UserModel().UserToUserModelConvertor(user);
	}

	public UserModel deleteUser(UserModel userModel) {
		User user = new UserModel().UserModelToUserConvertor(userModel);
		user.setDeleted(true);
		user = userService.save(user);
		return new UserModel().UserToUserModelConvertor(user);
	}
}