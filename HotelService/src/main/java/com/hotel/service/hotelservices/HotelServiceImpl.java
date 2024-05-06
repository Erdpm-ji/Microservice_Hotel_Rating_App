package com.hotel.service.hotelservices;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.service.enitity.Hotel;
import com.hotel.service.exceptions.HotelNotFoundException;
import com.hotel.service.repositary.HotelRepositary;

@Service
public class HotelServiceImpl implements HotelServices{
	
	@Autowired
	private HotelRepositary repositary;

	@Override
	public Hotel createHotel(Hotel hotel) {
		String uuid = UUID.randomUUID().toString();
		hotel.setHotelId(uuid);
		return repositary.save(hotel);
	}

	@Override
	public List<Hotel> findAllHotels() {
		return repositary.findAll();
	}

	@Override
	public Hotel findbyHotelId(String hotelId) {
		return repositary.findByHotelId(hotelId).orElseThrow(()->new HotelNotFoundException("Hotel not found on the server "+hotelId));
	}

	@Override
	public Hotel deleteByHotelId(String hotelId) {
		Hotel hotel = findbyHotelId(hotelId);
		repositary.deleteByHotelId(hotelId);
		return hotel;
	}

	@Override
	public Hotel updateByHotelId(Hotel hotel) {
		return repositary.save(hotel);
	}

}
