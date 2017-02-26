package com.careem.engine.test;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.careem.engine.web.service.BookingWebService;

public class TestCase1 {
	
	@Autowired
	private BookingWebService bookingWebService;

	@Test
	public void test() {
		bookingWebService.getDriver(1L, 12.934930, 77.607808);
	}
}