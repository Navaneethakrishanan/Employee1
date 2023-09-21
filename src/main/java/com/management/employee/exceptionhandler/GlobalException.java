package com.management.employee.exceptionhandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalException {
	@ExceptionHandler(NameNotFoundException.class)
	public ResponseEntity<Object> nameNotFoundException(NameNotFoundException ne){
		return new ResponseEntity<>(ne.getMessage(),HttpStatus.NOT_FOUND);
	}
	
	

}
