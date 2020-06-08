package com.billdog.user.exception;

import java.time.LocalDateTime;


public class ErrorResponse {
	
	private String status;
	private String message;
	private LocalDateTime timeStamp;
	private String path;

	public ErrorResponse(String status, String message, String path) {
		super();
		this.message = message;
		this.path = path;
		this.timeStamp = LocalDateTime.now();
		this.status= status;
	}


	public String getStatus() {
		return status;
	}

	public String getMessage() {
		return message;
	}

	public LocalDateTime getTimeStamp() {
		return timeStamp;
	}

	public String getPath() {
		return path;
	}


}