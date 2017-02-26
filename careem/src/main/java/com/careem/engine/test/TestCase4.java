package com.careem.engine.test;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.careem.engine.web.service.BookingWebService;

public class TestCase4 {
	
	@Autowired
	private BookingWebService bookingWebService;

	@Test
	public void test() {
		bookingWebService.getDriver(4L, 12.846883, 77.678481);
	}
}