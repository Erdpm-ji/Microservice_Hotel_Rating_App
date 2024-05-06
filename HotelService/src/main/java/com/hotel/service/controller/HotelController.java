package com.hotel.service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotel.service.enitity.Hotel;
import com.hotel.service.hotelservices.HotelServices;

import jakarta.transaction.Transactional;

@RestController
@RequestMapping("/hotel")
public class HotelController {
	
	@Autowired
	private HotelServices services;
	
	@PostMapping()
	public ResponseEntity<Hotel> saveHotel(@RequestBody Hotel hotel){
		Hotel newHotel = services.createHotel(hotel);
		return ResponseEntity.status(HttpStatus.CREATED).body(newHotel);
	}
	
	@GetMapping("/{hotelID}")
	public ResponseEntity<Hotel> getHotel(@PathVariable("hotelID") String hotelId){
		Hotel hotel = services.findbyHotelId(hotelId);
		return ResponseEntity.ok(hotel);
	}
	
	@GetMapping()
	public ResponseEntity<List<Hotel>> getAllHotels(){
		List<Hotel> hotel = services.findAllHotels();
		return ResponseEntity.ok(hotel);
	}
	
	@DeleteMapping(value = "/{hotelID}")
	@Transactional
	public ResponseEntity<Hotel> deleteByHotelId(@PathVariable String hotelID) {
		Hotel hotel = services.deleteByHotelId(hotelID);
		return ResponseEntity.ok(hotel);
	}
	
	@PatchMapping(value = "/{hotelID}")
	public ResponseEntity<Hotel> updateByHotelId(@PathVariable String hotelID, @RequestBody Hotel hotel){
		Hotel oldHotel = services.findbyHotelId(hotelID);
		oldHotel.setHotelId(hotelID);
		oldHotel.setName(hotel.getName());
		oldHotel.setAddress(hotel.getAddress());
		oldHotel.setAbout(hotel.getAbout());
		Hotel updatedHotel = services.updateByHotelId(oldHotel);
		return ResponseEntity.ok(updatedHotel);
	}
}
