package com.user.service.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.user.service.entity.Hotel;
import com.user.service.entity.User;
import com.user.service.externalservice.HotelService;
import com.user.service.services.UserServices;

import jakarta.transaction.Transactional;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserServices services;
	
	@Autowired
	private HotelService hotelService;

	@PostMapping()
	public ResponseEntity<User> CreateUser(@RequestBody User user) {
		User newUser = services.saveUser(user);
		return ResponseEntity.status(HttpStatus.CREATED).body(newUser);
	}
	
	@GetMapping("/{userID}")
	public ResponseEntity<User> getUser(@PathVariable("userID") String userID){
		User user = services.findByUserId(userID);
		return ResponseEntity.ok(user);
	}
	
	@GetMapping()
	public ResponseEntity<List<User>> getListOfAllUser(){
		List<User> users = services.getAllUsers();
		return ResponseEntity.ok(users);
	}
	
	@Transactional
	@DeleteMapping("/{userId}")
	public ResponseEntity<User> deleteUser(@PathVariable("userId") String userId){
		User user = services.deleteByUserId(userId);
		return ResponseEntity.ok(user);
	}
	
	@PatchMapping("/{userId}")
	public ResponseEntity<User> updateUser(@PathVariable("userId") String userId ,@RequestBody User user){
		User newUser = services.findByUserId(userId);
		newUser.setAbout(userId);
		newUser.setName(user.getName());
		newUser.setEmail(user.getEmail());
		newUser.setAbout(user.getAbout());
		User updateUser = services.updateByUserId(newUser);
		return ResponseEntity.status(HttpStatus.CREATED).body(updateUser);
	}
	
	@PostMapping("/hotel")
	public ResponseEntity<Hotel> CreateUser(@RequestBody Hotel hotel) {
		String id = UUID.randomUUID().toString();
		hotel.setHotelId(id);
		Hotel newUser = hotelService.saveHotel(hotel).getBody();
		return ResponseEntity.status(HttpStatus.CREATED).body(newUser);
		
	}
}
