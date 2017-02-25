package com.careem.engine.web.controller;

import java.util.List;

import javax.validation.Valid;

import com.careem.engine.web.model.*;
import com.careem.engine.web.service.UserWebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserWebService userWebService;
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	@ResponseStatus(value = HttpStatus.OK)
	public @ResponseBody List<UserModel> listUser() {
		return userWebService.getAllUsers();
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.CREATED)
	public @ResponseBody UserModel createUser(@RequestBody UserModel userModel) {
		return userWebService.createUser(userModel);
	}

	@RequestMapping(value = "/edit", method = RequestMethod.PUT)
	@ResponseStatus(value = HttpStatus.OK)
	public @ResponseBody UserModel editUser(@RequestBody UserModel userModel) {
		return userWebService.editUser(userModel);
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.DELETE)
	@ResponseStatus(value = HttpStatus.OK)
	public @ResponseBody UserModel deleteUser(@RequestBody UserModel userModel) {
		return userWebService.deleteUser(userModel);
	}

}