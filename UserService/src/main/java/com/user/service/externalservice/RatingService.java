package com.user.service.externalservice;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.user.service.entity.Rating;

@Service
@FeignClient(name ="RATING-SERVICE")
public interface RatingService {
	
	@GetMapping("/rating/user/{ratingId}")
	List<Rating> getRating(@PathVariable String ratingId);
	
	@PostMapping("/rating")
	public ResponseEntity<Rating> saveRating(@RequestBody Rating rating);
}
