package com.careem.engine.web.service;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.careem.engine.core.model.Booking;
import com.careem.engine.core.service.BookingService;
import com.careem.engine.web.model.BookingModel;

@Component
public class BookingWebService {

	@Autowired
	private BookingService bookingService;
	
	public static final int PER_KILOMETER_RATE_MINI = 7;
	public static final int PER_KILOMETER_RATE_PRIME = 15;
	
	public BookingModel getDriver(Long customerid, double latitude, double longitude) {
		// TODO Auto-generated method stub

		return null;
	}

	public BookingModel generateCost(Long id) {
		
		Booking booking = bookingService.findById(id);
		double totalCost = 0.0;
		
		Long distance = Long.parseLong(booking.getDistanceTravelled());
		String cabType = booking.getDriver().getCab().getCabType().toString();
		
		switch(cabType) {
			case "MINI" : totalCost = distance * PER_KILOMETER_RATE_MINI; break;
			case "PRIME" : totalCost = distance * PER_KILOMETER_RATE_PRIME; break;
		}
		booking.setCost(totalCost);	
		booking.setDistanceTravelled(distance.toString());
		return null;
	}

	public BookingModel updateDropTime(Long id, double latitude, double longitude) {
		// TODO Auto-generated method stub
		Booking booking = bookingService.findById(id);
		booking.setDriverEndLatitude(latitude);
		booking.setDriverEndLongitude(longitude);
		booking = bookingService.save(booking);
		return null;
	}

	public BookingModel updateRating(Long id, String rating) {
		// TODO Auto-generated method stub
		Booking booking = bookingService.findById(id);
		booking.setRating(rating);
		booking = bookingService.save(booking);
		return null;
	}

	public BookingModel updatecabCurrentLocation(Long id, double latitude, double longitude) {
		// TODO Auto-generated method stub
		return null;
	}

	public HashMap<String, Double> getcabCurrentLocation(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
