package com.mvp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mvp.common.entity.User;
import com.mvp.common.repository.UserRepository;

/**
 * service class for user.
 * @author techversant
 * @version 1.0
 * @since 2023
 */
@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	/**
	 * this method for getting user info by id.
	 * @param user id.
	 * @return user object.
	 */
	public User getUser(long userId) {
		return userRepository.findById(userId).orElse(null);
	}
}
