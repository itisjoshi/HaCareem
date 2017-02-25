package com.careem.engine.web.controller;

import java.util.List;

import javax.validation.Valid;

import com.careem.engine.web.model.*;
import com.careem.engine.web.service.CustomerWebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerWebService customerWebService;
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	@ResponseStatus(value = HttpStatus.OK)
	public @ResponseBody List<CustomerModel> listCustomer() {
		return customerWebService.getAllCustomers();
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.CREATED)
	public @ResponseBody CustomerModel createCustomer(@RequestBody CustomerModel userModel) {
		return customerWebService.createCustomer(userModel);
	}

	@RequestMapping(value = "/edit", method = RequestMethod.PUT)
	@ResponseStatus(value = HttpStatus.OK)
	public @ResponseBody CustomerModel editCustomer(@RequestBody CustomerModel userModel) {
		return customerWebService.editCustomer(userModel);
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.DELETE)
	@ResponseStatus(value = HttpStatus.OK)
	public @ResponseBody CustomerModel deleteCustomer(@RequestBody CustomerModel userModel) {
		return customerWebService.deleteCustomer(userModel);
	}

}