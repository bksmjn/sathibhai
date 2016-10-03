package com.codebhatti.sathibhai.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.codebhatti.sathibhai.domain.Address;
import com.codebhatti.sathibhai.domain.User;
import com.codebhatti.sathibhai.service.UserService;
import com.sun.xml.internal.ws.api.ha.HaInfo;

@RestController
@RequestMapping(value="/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	private User user;

	public UserController(){
		System.out.println("USERCONTROLLER......");
	}
	
	@PostConstruct
	private void init(){
		Set<Address> addresses=new HashSet<>();
		Address a=new Address();
		a.setCity("Irving");
		a.setUser(this.user);
		a.setCity("TX");
		a.setZipCode("75038");
		addresses.add(a);
		this.user=new User("bksmjn","Bikehs","Maharjan");
		this.user.addAddress(a);
		this.userService.addUser(user);
	}
	
	@RequestMapping(value="/all")
	public  @ResponseBody List<User> getAllUsers(){
		return this.userService.findAllUsers();
	}
	public UserService getUserService() {
		return userService;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	

}
