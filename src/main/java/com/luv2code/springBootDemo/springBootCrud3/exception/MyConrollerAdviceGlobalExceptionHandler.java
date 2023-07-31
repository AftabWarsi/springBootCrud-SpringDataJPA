package com.luv2code.springBootDemo.springBootCrud3.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class MyConrollerAdviceGlobalExceptionHandler<EmptyInputExcpetion> extends ResponseEntityExceptionHandler {
	@ExceptionHandler
	 public ResponseEntity<Object> handleEmpltyinput(EmptyInputExcpetion emptyInputExcpetion){
		return new ResponseEntity("Input Field is empty : please look into it "+HttpStatus.BAD_REQUEST, null) ;
		
		
	}

}
