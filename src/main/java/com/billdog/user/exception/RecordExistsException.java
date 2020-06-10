package com.billdog.user.exception;

public class RecordExistsException extends RuntimeException {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public RecordExistsException(String message) {
		super(message);
	}

}