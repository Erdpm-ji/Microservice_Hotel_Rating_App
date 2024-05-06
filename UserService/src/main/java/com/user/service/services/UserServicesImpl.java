package com.user.service.services;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.user.service.entity.Hotel;
import com.user.service.entity.Rating;
import com.user.service.entity.User;
import com.user.service.exceptions.ResourcesNotFoundExceptions;
import com.user.service.externalservice.HotelService;
import com.user.service.externalservice.RatingService;
import com.user.service.repositary.UserRepositary;

@Service
public class UserServicesImpl implements UserServices {

	@Autowired
	private UserRepositary repositary;

//	@Autowired
//	private final RestTemplate template;

	@Autowired
	HotelService hotelService;

	@Autowired
	RatingService ratingService;

//	UserServicesImpl(RestTemplate template) {
//		this.template = template;
//	}

	@Override
	public User saveUser(User user) {
		String id = UUID.randomUUID().toString();
		user.setUserId(id);
		return repositary.save(user);
	}

	@Override
	public List<User> getAllUsers() {
		List<User> users = repositary.findAll();

		for (User user : users) {
			List<Rating> ratings = ratingService.getRating(user.getUserId()).stream().map(rating -> {
				ResponseEntity<Hotel> hotels = hotelService.getHotel(rating.getHotelId());

				rating.setHotal(hotels.getBody());

				return rating;
			}).collect(Collectors.toList());
			user.setRating(ratings);
		}
		return users;
	}

	@Override
	public User findByUserId(String userId) {
		User user = repositary.findByUserId(userId)
				.orElseThrow(() -> new ResourcesNotFoundExceptions("User given id is not found on server " + userId));

		List<Rating> ratings = ratingService.getRating(userId).stream().map(rating -> {
			ResponseEntity<Hotel> hotels = hotelService.getHotel(rating.getHotelId());

			rating.setHotal(hotels.getBody());

			return rating;
		}).collect(Collectors.toList());

		user.setRating(ratings);
		return user;

	}

	@Override
	public User deleteByUserId(String userId) {
		User deleteduser = findByUserId(userId);
		repositary.deleteByUserId(userId);
		return deleteduser;
	}

	@Override
	public User updateByUserId(User user) {
		repositary.save(user);
		return user;
	}

}
