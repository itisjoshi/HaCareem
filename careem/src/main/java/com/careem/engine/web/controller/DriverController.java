package com.careem.engine.web.controller;

import java.util.List;

import javax.validation.Valid;

import com.careem.engine.web.model.*;
import com.careem.engine.web.service.DriverWebService;
import com.careem.engine.web.service.DriverWebService;
import com.careem.engine.web.service.DriverWebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/driver")
public class DriverController {

	@Autowired
	private DriverWebService driverWebService;
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	@ResponseStatus(value = HttpStatus.OK)
	public @ResponseBody List<DriverModel> listDriver() {
		return driverWebService.getAllDrivers();
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.CREATED)
	public @ResponseBody DriverModel createDriver(@RequestBody DriverModel userModel) {
		return driverWebService.createDriver(userModel);
	}

	@RequestMapping(value = "/edit", method = RequestMethod.PUT)
	@ResponseStatus(value = HttpStatus.OK)
	public @ResponseBody DriverModel editDriver(@RequestBody DriverModel userModel) {
		return driverWebService.editDriver(userModel);
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.DELETE)
	@ResponseStatus(value = HttpStatus.OK)
	public @ResponseBody DriverModel deleteDriver(@RequestBody DriverModel userModel) {
		return driverWebService.deleteDriver(userModel);
	}

}