package com.codebhatti.sathibhai.service;

import java.util.List;

import com.codebhatti.sathibhai.domain.User;

public interface UserService {

	List<User> findAllUsers();
	void addUser(User user);
}
