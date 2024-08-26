package com.students.golbalhandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.students.customexception.AgeInvalidException;

@RestControllerAdvice
public class StuGobalHandler {

	@ExceptionHandler(AgeInvalidException.class)
	public ResponseEntity<Object> ageHandler() {
		return new ResponseEntity<>("NOT ALLOWED", HttpStatus.BAD_REQUEST);
	}
}
