package com.careem.engine.test;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.careem.engine.web.service.BookingWebService;

public class TestCase5 {
	
	@Autowired
	private BookingWebService bookingWebService;

	@Test
	public void test() {
		bookingWebService.getDriver(5L, 12.828137, 77.602263);
	}
}