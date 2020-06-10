package com.billdog.user.exception;

public class InValidInputException extends BadRequestException {

	private static final long serialVersionUID = 1L;

	public InValidInputException(String message) {
		super(message);
	}

}