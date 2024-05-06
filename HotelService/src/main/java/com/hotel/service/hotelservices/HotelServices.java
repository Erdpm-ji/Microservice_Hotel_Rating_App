package com.hotel.service.hotelservices;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hotel.service.enitity.Hotel;

public interface HotelServices {
	
	public Hotel createHotel(Hotel hotel);
	public List<Hotel> findAllHotels();
	public Hotel findbyHotelId(String hotelId);
	public Hotel deleteByHotelId(String hotelId);
	public Hotel updateByHotelId(Hotel hotel);
}
