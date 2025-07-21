package com.spring_boot.spring_boot.Learn;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import com.spring_boot.spring_boot.Learn.entity.ErrorMessage;

@ControllerAdvice
//@ResponseStatus
public class RestResponseExceptionHandler extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(DepartmentNotFoundException.class)
	public ResponseEntity<ErrorMessage> deptNotFoundException(DepartmentNotFoundException exception
																			   , WebRequest request) {
		ErrorMessage message = new ErrorMessage(HttpStatus.NOT_FOUND, exception.getMessage());		
		 return ResponseEntity.status(HttpStatus.NOT_FOUND)
	                .body(message);
	}
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorMessage> handleGenericException(Exception ex, WebRequest request) {
	    ErrorMessage message = new ErrorMessage(HttpStatus.INTERNAL_SERVER_ERROR, "An unexpected error occurred");
	    return new ResponseEntity<>(message, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}