package com.user.service.externalservice;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.user.service.entity.Hotel;

@FeignClient(name="HOTEL-SERVICE")
public interface HotelService {
	
	@GetMapping("/hotel/{hotelId}")
	ResponseEntity<Hotel> getHotel(@PathVariable String hotelId);
	
	@PostMapping("/hotel")
	public ResponseEntity<Hotel> saveHotel(Hotel hotel);
}
