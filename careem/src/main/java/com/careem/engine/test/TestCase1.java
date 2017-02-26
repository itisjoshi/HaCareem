package com.careem.engine.test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.careem.engine.web.model.BookingModel;
import com.careem.engine.web.service.BookingWebService;

public class TestCase1 {
	
	@Autowired
	private BookingWebService bookingWebService;

	@Test
	public void test() {
		BookingModel bookingModel =  bookingWebService.getDriver(1L, 12.934930, 77.607808);
		assertEquals("1", bookingModel.getDriverId()+ "");
	}
}