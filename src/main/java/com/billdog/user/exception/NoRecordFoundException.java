package com.billdog.user.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@SuppressWarnings("serial")
@ResponseStatus(HttpStatus.NOT_FOUND)
public class NoRecordFoundException extends RuntimeException {

	public NoRecordFoundException(String message) {
		super(message);
	}

}
