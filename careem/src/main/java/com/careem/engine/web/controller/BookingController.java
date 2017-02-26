package com.careem.engine.web.controller;

import com.careem.engine.core.model.CabType;
import com.careem.engine.web.model.*;
import com.careem.engine.web.service.BookingWebService;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("booking")
public class BookingController {

	@Autowired
	private BookingWebService bookingWebService;
	
	@RequestMapping(value = "/{customerid}/{latitude}/{longitude}/book", method = RequestMethod.GET)
	@ResponseStatus(value = HttpStatus.OK)
	public @ResponseBody BookingModel getDriver(@PathVariable("customerid") Long customerid, @PathVariable("latitude") double latitude, @PathVariable("longitude") double longitude) {
		return bookingWebService.getDriver(customerid, latitude, longitude);
	}

	@RequestMapping(value = "/generatecost/{bookingid}", method = RequestMethod.GET)
	@ResponseStatus(value = HttpStatus.OK)
	public @ResponseBody BookingModel getDriver(@PathVariable("bookingid") Long id) {
		return bookingWebService.generateCost(id);
	}

	@RequestMapping(value = "/updatedrop/{bookingid}/{latitude}/{longitude}/drop", method = RequestMethod.GET)
	@ResponseStatus(value = HttpStatus.OK)
	public @ResponseBody BookingModel updateDropTime(@PathVariable("bookingid") Long id, @PathVariable("latitude") double latitude, @PathVariable("longitude") double longitude) {
		bookingWebService.updateDropTime(id, latitude, longitude);
		return bookingWebService.generateCost(id);
	}

	@RequestMapping(value = "/updaterating/{bookingid}/{rating}", method = RequestMethod.GET)
	@ResponseStatus(value = HttpStatus.OK)
	public @ResponseBody BookingModel updateRating(@PathVariable("bookingid") Long id, @PathVariable("rating") String rating) {
		return bookingWebService.updateRating(id, rating);
	}

	@RequestMapping(value = "/updatecablocation/{driverid}/{latitude}/{longitude}/book", method = RequestMethod.GET)
	@ResponseStatus(value = HttpStatus.OK)
	public @ResponseBody DriverModel updatecabCurrentLocation(@PathVariable("driverid") Long id, @PathVariable("latitude") double latitude, @PathVariable("longitude") double longitude) {
		return bookingWebService.updatecabCurrentLocation(id, latitude, longitude);
	}
	
	@RequestMapping(value = "/getcablocation/{driverid}", method = RequestMethod.GET)
	@ResponseStatus(value = HttpStatus.OK)
	public @ResponseBody HashMap<String, Double> getcabCurrentLocation(@PathVariable("driverid") Long driverid) {
		return bookingWebService.getcabCurrentLocation(driverid);
	}
	
	@RequestMapping(value = "/cancelbooking/{bookingid}", method = RequestMethod.GET)
	@ResponseStatus(value = HttpStatus.OK)
	public @ResponseBody void cancelbooking(@PathVariable("bookingid") Long id) {
		bookingWebService.cancelbooking(id);
	}

	@RequestMapping(value = "/estimate/{fromlatitude}/{fromlongitude}/{tolatitude}/{tolongitude}/cost", method = RequestMethod.GET)
	@ResponseStatus(value = HttpStatus.OK)
	public @ResponseBody HashMap<String, String> estimate(@PathVariable("fromlatitude") double fromlatitude, @PathVariable("fromlongitude") double fromlongitude, @PathVariable("tolatitude") double tolatitude, @PathVariable("tolongitude") double tolongitude) {
		return bookingWebService.generateCost(fromlatitude, fromlongitude, tolatitude, tolongitude);
	}

}