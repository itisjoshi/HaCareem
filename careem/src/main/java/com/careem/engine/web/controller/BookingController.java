package com.careem.engine.web.controller;

import com.careem.engine.web.model.*;
import com.careem.engine.web.service.BookingWebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/booking")
public class BookingController {

	@Autowired
	private BookingWebService bookingWebService;
	
	@RequestMapping(value = "/book/{customerid}/{latitude}/{longitude}", method = RequestMethod.GET)
	@ResponseStatus(value = HttpStatus.OK)
	public @ResponseBody DriverModel getDriver(@PathVariable("customerid") Long customerid, @PathVariable("latitude") double latitude, @PathVariable("longitude") double longitude) {
		return bookingWebService.getDriver(customerid, latitude, longitude);
	}
	
}