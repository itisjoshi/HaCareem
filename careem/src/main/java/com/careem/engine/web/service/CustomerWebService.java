package com.careem.engine.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.careem.engine.core.model.Customer;
import com.careem.engine.core.model.User;
import com.careem.engine.core.service.CustomerService;
import com.careem.engine.core.service.UserService;
import com.careem.engine.web.model.CustomerModel;

@Component
public class CustomerWebService {

	@Autowired
	private UserService userService;
	
	@Autowired
	private CustomerService customerService;
	
	public List<CustomerModel> getAllCustomers() {
		// TODO Auto-generated method stub
		return null;
	}

	public CustomerModel createCustomer(CustomerModel userModel) {
		// TODO Auto-generated method stub
		User user = new User();
		user.setEmail(userModel.getEmail());
		user.setGender(userModel.getGender());
		user.setName(userModel.getName());
		user = userService.save(user);
		Customer customer = new Customer();
		customer.setPreference(userModel.getPreference());
		customer.setUser(user);
		customerService.save(customer);
		return null;
	}

	public CustomerModel editCustomer(CustomerModel userModel) {
		// TODO Auto-generated method stub
		return null;
	}

	public CustomerModel deleteCustomer(CustomerModel userModel) {
		// TODO Auto-generated method stub
		return null;
	}

}
