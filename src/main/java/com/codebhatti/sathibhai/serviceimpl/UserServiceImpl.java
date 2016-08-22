package com.codebhatti.sathibhai.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codebhatti.sathibhai.domain.User;
import com.codebhatti.sathibhai.repository.UserRepository;
import com.codebhatti.sathibhai.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public List<User> findAllUsers() {
		return this.userRepository.findAll();
	}

}
