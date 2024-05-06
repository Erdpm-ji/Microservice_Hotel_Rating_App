package com.hotel.service.exceptions;

public class HotelNotFoundException extends RuntimeException{
	
	public HotelNotFoundException() {
		super("Hotel not found on the server!!");
	}
	
	public HotelNotFoundException(String massage) {
		super(massage);
	}
}
