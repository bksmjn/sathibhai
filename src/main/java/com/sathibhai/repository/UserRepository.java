package com.sathibhai.repository;

import com.sathibhai.model.user.Role;
import com.sathibhai.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

	public User findByEmail(String email);

	@Modifying
	@Query("update User u set u.password = ?2 where u.email = ?1")
	public void updatePassword(String email, String password);

	@Modifying
	@Query("update User u set u.enable = false where u.email = ?1")
	public void disableUser(String email);

	@Modifying
	@Query("update User u set u.enable = true where u.email = ?1")
	public void enableUser(String email);

	public List<User> findByEnableFalse();

	public List<User> findByEnableTrue();

	/**
	 * 
	 * @returns list of enable users except email sent
	 * @param email
	 */
	public List<User> findByEmailNotAndEnableTrue(String email);

	@Query("from User u where u.enable is NULL")
	public List<User> findUnApprovedUsers();
	
	@Query("from User u where u.enable = true and u.role = ?1")
	public List<User> findByRole(Role role);

}
