package com.user.service.repositary;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.user.service.entity.User;

public interface UserRepositary extends JpaRepository<User, String>{
	Optional<User> findByUserId(String userId);
	
	void deleteByUserId(String userId);
}
