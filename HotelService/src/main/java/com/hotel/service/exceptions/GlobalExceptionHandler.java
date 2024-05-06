package com.hotel.service.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.hotel.service.payload.ApiResponse;


@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(HotelNotFoundException.class)
	public ResponseEntity<ApiResponse> handlerHotelNotFoundException(HotelNotFoundException ex){
		ApiResponse response = ApiResponse.builder().message(ex.getMessage()).isSuccess(true).status(HttpStatus.NOT_FOUND).build();
		return new ResponseEntity<com.hotel.service.payload.ApiResponse>(response,HttpStatus.NOT_FOUND);
	}
}
