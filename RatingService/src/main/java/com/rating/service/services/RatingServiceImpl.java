package com.rating.service.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rating.service.entity.Rating;
import com.rating.service.repositary.RatingRepositary;

@Service
public class RatingServiceImpl implements RatingServices {

	@Autowired
	private RatingRepositary repositary;

	@Override
	public Rating createReting(Rating rating) {
		return repositary.save(rating);
	}

	@Override
	public List<Rating> getAllRatings() {
		return repositary.findAll();
	}

	@Override
	public List<Rating> findAllRatingByUserId(String userId) {
		return repositary.findByUserId(userId);
	}

	@Override
	public List<Rating> findAllRationgByHotelId(String hotelId) {
		return repositary.findByHotelId(hotelId);
	}

}
