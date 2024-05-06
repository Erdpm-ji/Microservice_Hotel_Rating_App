package com.hotel.service.repositary;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hotel.service.enitity.Hotel;

@Repository
public interface HotelRepositary extends JpaRepository<Hotel, String>{

	Optional<Hotel> findByHotelId(String hotelId);
	
	void deleteByHotelId(String hotelId);
	
}
