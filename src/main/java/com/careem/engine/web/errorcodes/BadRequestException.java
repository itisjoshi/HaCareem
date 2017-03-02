package com.careem.engine.web.errorcodes;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Bad Request")
public class BadRequestException extends RuntimeException {

	private static final long serialVersionUID = 6633005766981412890L;
	
	public BadRequestException(String string) {
		// TODO Auto-generated constructor stub
		super(string);
	}
}