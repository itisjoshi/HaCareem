package com.careem.engine.web.service;

import java.util.ArrayList;
import java.util.Iterator;
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
		List<CustomerModel> customerModels = new ArrayList<CustomerModel>();
		List<Customer> customers = customerService.findAll();
		Iterator<Customer> customerIterator = customers.iterator();
		while(customerIterator.hasNext()) {
			Customer customer = customerIterator.next();
			CustomerModel customerModel = new CustomerModel();
			customerModel.setCustomerId(customer.getId());
			customerModel.setEmail(customer.getUser().getEmail());
			customerModel.setGender(customer.getUser().getGender());
			customerModel.setName(customer.getUser().getName());
			customerModel.setPreference(customer.getPreference());
			customerModel.setUserId(customer.getUser().getId());
			customerModels.add(customerModel);
		}
		return customerModels;
	}

	public CustomerModel createCustomer(CustomerModel customerModel) {
		// TODO Auto-generated method stub
		User user = new User();
		user.setEmail(customerModel.getEmail());
		user.setGender(customerModel.getGender());
		user.setName(customerModel.getName());
		user = userService.save(user);
		Customer customer = new Customer();
		customer.setPreference(customerModel.getPreference());
		customer.setUser(user);
		customer = customerService.save(customer);
		customerModel.setCustomerId(customer.getId());
		customerModel.setUserId(user.getId());
		return customerModel;
	}

	public CustomerModel editCustomer(CustomerModel customerModel) {
		// TODO Auto-generated method stub
		User user = userService.findById(customerModel.getUserId());
		user.setEmail(customerModel.getEmail());
		user.setGender(customerModel.getGender());
		user.setName(customerModel.getName());
		user = userService.save(user);
		Customer customer = customerService.findById(customerModel.getCustomerId());
		customer.setPreference(customerModel.getPreference());
		customer.setUser(user);
		customer = customerService.save(customer);
		customerModel.setCustomerId(customer.getId());
		customerModel.setUserId(user.getId());
		return customerModel;
	}

	public CustomerModel deleteCustomer(CustomerModel customerModel) {
		// TODO Auto-generated method stub
		return null;
	}

}
