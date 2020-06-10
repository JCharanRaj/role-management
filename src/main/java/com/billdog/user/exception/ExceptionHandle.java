package com.billdog.user.exception;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.billdog.user.common.Constants;

@RestControllerAdvice
public class ExceptionHandle extends ResponseEntityExceptionHandler {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ExceptionHandle.class);
	
	@Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException exception,
            HttpHeaders headers, HttpStatus status, WebRequest request) {
		
        List<String> errors = exception.getBindingResult().getFieldErrors().stream().map(x -> x.getDefaultMessage())
                .collect(Collectors.toList());
        LOGGER.info("Exception cause: "+errors.toString());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new ErrorResponse(Constants.FAILED,errors.get(0), request.getDescription(false)));
    }
	
	@ExceptionHandler(value = { ConstraintViolationException.class })
    public ResponseEntity<Object> handleResourceNotFoundException(ConstraintViolationException exception, WebRequest request) {
		
        Set<ConstraintViolation<?>> constraintViolations = exception.getConstraintViolations();
        List<ConstraintViolation<?>> errors = constraintViolations.stream().collect(Collectors.toList());
        LOGGER.info("Exception cause: "+errors.toString());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new ErrorResponse(Constants.FAILED,errors.get(0).getMessage(), request.getDescription(false)));
    }

	
	@ExceptionHandler(InValidInputException.class)
	public final ResponseEntity<ErrorResponse> handleInValidInputException(
			InValidInputException exception, WebRequest request) {
		LOGGER.info("Exception cause: "+exception.getMessage());
		ErrorResponse errorResponse = new ErrorResponse(Constants.FAILED,exception.getLocalizedMessage(), request.getDescription(false));
		return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(NoRecordFoundException.class)
	public final ResponseEntity<ErrorResponse> handleNoRecordFoundException(NoRecordFoundException exception,
			WebRequest request) {
		LOGGER.info("Exception cause: " + exception.getMessage());
		ErrorResponse errorResponse = new ErrorResponse(Constants.FAILED, exception.getLocalizedMessage(),
				request.getDescription(false));
		return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
	}

	
	
	@ExceptionHandler(RecordExistsException.class)
	public final ResponseEntity<ErrorResponse> handleRecordExistsException(RecordExistsException exception,
			WebRequest request) {
		LOGGER.info("Exception cause: " + exception.getMessage());
		ErrorResponse errorResponse = new ErrorResponse(Constants.FAILED, exception.getLocalizedMessage(),
				request.getDescription(false));
		return new ResponseEntity<>(errorResponse, HttpStatus.CONFLICT);
	}
	
}