package com.user.service.externalcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.user.service.entity.Hotel;
import com.user.service.externalservice.HotelService;

@Service
public class HotelServiceImpl {
	
	@Autowired
	private HotelService hotelService;
	
	public Hotel createHotel() {
		Hotel hotel = Hotel.builder().name("Raju ki hotel").address("pochipura").about("mst").build();
		return hotelService.saveHotel(hotel).getBody();
	}
}

/* 8527852837 */