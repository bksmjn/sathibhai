package com.sathibhai;

import com.sathibhai.model.user.Role;
import com.sathibhai.model.user.User;
import com.sathibhai.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class Startup {

	private static final String FIRSTNAME = "Admin";
	private static final String LASTNAME = "Admin";
	private static final String EMAIL = "admin@sathibhai.com";
	private static final String PASSWORD = "admin@123";
	private static final String RE_PASSWORD = "admin@123";
	private static final Role ROLE = Role.ROLE_ADMIN;

	@Autowired
	private UserService userService;

	@PostConstruct
	public void init() {
		this.addAdminUser();
	}

	private void addAdminUser() {
		if (this.userService.findUserByEmail(EMAIL) == null) {
			User user = new User(EMAIL, PASSWORD, RE_PASSWORD, ROLE);
			user.setEnable(true);
			user.setFirstName(FIRSTNAME);
			user.setLastName(LASTNAME);
			userService.add(user);
		}
	}

}
