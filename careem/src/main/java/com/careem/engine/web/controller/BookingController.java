package com.careem.engine.web.controller;

import com.careem.engine.web.model.*;
import com.careem.engine.web.service.BookingWebService;

import java.util.HashMap;

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
	public @ResponseBody BookingModel getDriver(@PathVariable("customerid") Long customerid, @PathVariable("latitude") double latitude, @PathVariable("longitude") double longitude) {
		return bookingWebService.getDriver(customerid, latitude, longitude);
	}

	@RequestMapping(value = "/book/generatecost/{id}", method = RequestMethod.GET)
	@ResponseStatus(value = HttpStatus.OK)
	public @ResponseBody BookingModel getDriver(@PathVariable("id") Long id) {
		return bookingWebService.generateCost(id);
	}

	@RequestMapping(value = "/book/updatedrop/{id}/{latitude}/{longitude}", method = RequestMethod.GET)
	@ResponseStatus(value = HttpStatus.OK)
	public @ResponseBody BookingModel updateDropTime(@PathVariable("id") Long id, @PathVariable("latitude") double latitude, @PathVariable("longitude") double longitude) {
		return bookingWebService.updateDropTime(id, latitude, longitude);
	}

	@RequestMapping(value = "/book/updaterating/{id}/{rating}", method = RequestMethod.GET)
	@ResponseStatus(value = HttpStatus.OK)
	public @ResponseBody BookingModel updateRating(@PathVariable("id") Long id, @PathVariable("rating") String rating) {
		return bookingWebService.updateRating(id, rating);
	}

	@RequestMapping(value = "/book/updatecablocation/{driverid}/{latitude}/{longitude}", method = RequestMethod.GET)
	@ResponseStatus(value = HttpStatus.OK)
	public @ResponseBody void updatecabCurrentLocation(@PathVariable("driverid") Long id, @PathVariable("latitude") double latitude, @PathVariable("longitude") double longitude) {
		bookingWebService.updatecabCurrentLocation(id, latitude, longitude);
	}
	
	@RequestMapping(value = "/book/getcablocation/{id}/{latitude}/{longitude}", method = RequestMethod.GET)
	@ResponseStatus(value = HttpStatus.OK)
	public @ResponseBody HashMap<String, Double> getcabCurrentLocation(@PathVariable("id") Long id) {
		return bookingWebService.getcabCurrentLocation(id);
	}
}