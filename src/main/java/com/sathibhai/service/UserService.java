package com.sathibhai.service;

import com.sathibhai.dto.ChangePassword;
import com.sathibhai.model.user.Role;
import com.sathibhai.model.user.User;

import java.util.List;

public interface UserService extends AbstractService<User, Long> {

	public User findUserByEmail(String email);

	public void updatePassword(ChangePassword changePassword);

	public void removeByEmail(String email);

	public void enableUserByEmail(String email);

	public void disableUserByEmail(String email);

	public List<User> findByEnableFalse();

	public List<User> findByEnableTrue(String email);

	public List<User> findUnApprovedUsers();

	public void approveUser(User user);

	public List<User> findUserByRole(Role role);
}
