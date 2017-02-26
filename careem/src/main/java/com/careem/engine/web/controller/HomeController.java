package com.careem.engine.web.controller;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public Map<String, String> home(Locale locale) {
		logger.info("Called Home: " + locale);
		Map<String, String> object = new HashMap<String, String>();
		object.put("Name", "Engine.Web");
		return object;
	}
}