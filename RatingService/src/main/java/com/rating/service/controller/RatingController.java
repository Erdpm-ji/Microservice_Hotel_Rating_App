package com.rating.service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rating.service.entity.Rating;
import com.rating.service.services.RatingServices;

@RestController
@RequestMapping("/rating")
public class RatingController {
	
	@Autowired
	private RatingServices services;
	
	@PostMapping()
	public ResponseEntity<Rating> saveRating(@RequestBody Rating rating){
		return ResponseEntity.status(HttpStatus.CREATED).body(services.createReting(rating));
	}
	
	@GetMapping()
	public ResponseEntity<List<Rating>> getAllRatings(){
		return ResponseEntity.ok(services.getAllRatings());
	}
	
	@GetMapping("/user/{userId}")
	public ResponseEntity<List<Rating>> findByUserId(@PathVariable("userId") String userId){
		return ResponseEntity.ok(services.findAllRatingByUserId(userId));
	}
	
	@GetMapping("/hotel/{hotelId}")
	public ResponseEntity<List<Rating>> findByHotelId(@PathVariable("hotelId") String hotelId){
		return ResponseEntity.ok(services.findAllRationgByHotelId(hotelId));
	}
}
