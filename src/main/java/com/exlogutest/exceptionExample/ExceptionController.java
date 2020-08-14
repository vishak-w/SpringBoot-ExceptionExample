package com.exlogutest.exceptionExample;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionController extends ResponseEntityExceptionHandler {
	@ExceptionHandler(Exception.class)
	ResponseEntity<Object> handleAllException(Exception ex, WebRequest req) {
		List<String> details = new ArrayList<String>();
		details.add(ex.getLocalizedMessage());
		Error err = new Error("Server Error", details);
		return new ResponseEntity<>(err, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(CustomException.class)
	ResponseEntity<Object> handleCustomException(CustomException ex, WebRequest re) {
		List<String> details = new ArrayList<String>();
		details.add(ex.getLocalizedMessage());
		Error err = new Error("Check Your DataBase ", details);
		return new ResponseEntity<>(err, HttpStatus.NOT_FOUND);

	}

}
