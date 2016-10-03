package com.codebhatti.sathibhai.repositoryimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.codebhatti.sathibhai.domain.User;
import com.codebhatti.sathibhai.repository.UserRepository;
import com.codebhatti.sathibhai.utils.EntityManagerWrapper;
import com.codebhatti.sathibhai.utils.QueryParameter;
import com.codebhatti.sathibhai.utils.QueryParameterCollection;

@Repository
public class UserRepositoryImpl implements UserRepository {

	@Autowired
	private EntityManagerWrapper entityManagerWrapper;

	public UserRepositoryImpl() {
		System.out.println("UserRepositoryImpl......");
	}

	@Override
	public void addUser(User user) {
		if (user == null)
			throw new IllegalArgumentException("User is Null");
		this.entityManagerWrapper.persist(user);

	}

	@Override
	public List<User> findAll() {
		List<User> users=this.entityManagerWrapper.findAll(User.FINDALL);
		System.out.println("SIZE"+users.size());
		return users;
	}

	@Override
	public User findByEmailAddress(String emailAddress) {
		return this.entityManagerWrapper.find(User.class, emailAddress);
	}

	@Override
	public void removeUser(User user) {
		this.entityManagerWrapper.remove(user);

	}

	public EntityManagerWrapper getEntityManagerWrapper() {
		return entityManagerWrapper;
	}

	public void setEntityManagerWrapper(EntityManagerWrapper entityManagerWrapper) {
		this.entityManagerWrapper = entityManagerWrapper;
	}

	
}
