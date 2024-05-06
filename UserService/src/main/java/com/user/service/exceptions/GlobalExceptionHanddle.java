package com.user.service.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.user.service.payload.ApiResponse;

@RestControllerAdvice
public class GlobalExceptionHanddle {
	
	@ExceptionHandler(ResourcesNotFoundExceptions.class)
	public ResponseEntity<ApiResponse> handlerResourceNotFoundException(ResourcesNotFoundExceptions ex){
		ApiResponse response =  ApiResponse.builder().massage(ex.getMessage()).isSuccess(true).status(HttpStatus.NOT_FOUND).build();
		return new ResponseEntity<ApiResponse>(response,HttpStatus.NOT_FOUND);
	}
}
