package com.org.leap.finance.LoginApi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.leap.finance.LoginApi.model.User;
import com.org.leap.finance.LoginApi.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public User getUser(Long userId) {
		return (userRepository.findById(userId)).get();
	}

}
