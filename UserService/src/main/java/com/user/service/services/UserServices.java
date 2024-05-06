package com.user.service.services;

import java.util.List;

import com.user.service.entity.User;

public interface UserServices {

	User saveUser(User user);

	List<User> getAllUsers();

	User findByUserId(String userId);

	User deleteByUserId(String userId);

	User updateByUserId(User user);
	

}
