package com.codebhatti.sathibhai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.codebhatti.sathibhai.domain.User;
import com.codebhatti.sathibhai.service.UserService;

@RestController
@RequestMapping(value="/users")
public class UserController {
	
	@Autowired
	private UserService userService;

	public UserController(){
		System.out.println("USERCONTROLLER......");
	}
	@RequestMapping(value="/all")
	public List<User> getAllUsers(){
		return this.userService.findAllUsers();
	}
	

}
