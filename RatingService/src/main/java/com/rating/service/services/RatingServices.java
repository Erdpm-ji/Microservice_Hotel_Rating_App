package com.rating.service.services;

import java.util.List;

import com.rating.service.entity.Rating;

public interface RatingServices {

	Rating createReting(Rating rating);

	List<Rating> getAllRatings();

	List<Rating> findAllRatingByUserId(String userId);

	List<Rating> findAllRationgByHotelId(String hotelId);
}
