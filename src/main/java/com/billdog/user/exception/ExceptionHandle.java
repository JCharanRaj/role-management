package com.billdog.user.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.billdog.user.common.Constants;

@RestController
@ControllerAdvice
public class ExceptionHandle extends ResponseEntityExceptionHandler {

	private static final Logger LOGGER = LoggerFactory.getLogger(ExceptionHandle.class);

	@ExceptionHandler(InValidInputException.class)
	public final ResponseEntity<ErrorResponse> handleInValidInputException(InValidInputException exception,
			WebRequest request) {
		LOGGER.info("Exceptin cause: " + exception.getMessage());
		ErrorResponse errorResponse = new ErrorResponse(Constants.FAILED, exception.getLocalizedMessage(),
				request.getDescription(false));
		return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(NoRecordFoundException.class)
	public final ResponseEntity<ErrorResponse> handleNoRecordFoundException(NoRecordFoundException exception,
			WebRequest request) {
		LOGGER.info("Exceptin cause: " + exception.getMessage());
		ErrorResponse errorResponse = new ErrorResponse(Constants.FAILED, exception.getLocalizedMessage(),
				request.getDescription(false));
		return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
	}

}