package com.codebhatti.sathibhai.repository;

import java.util.List;

import com.codebhatti.sathibhai.domain.User;

public interface UserRepository {

	void addUser(User user);
	List<User> findAll();
	User findByEmailAddress(String emailAddress);
	void removeUser(User user);
}
