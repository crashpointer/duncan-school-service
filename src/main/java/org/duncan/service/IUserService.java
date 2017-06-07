package org.duncan.service;

import org.duncan.entity.User;

/**
 * @author crash pointer
 * This interface defines all required methods for users.
 */
public interface IUserService {
	
	/**
	 * This method is used to search in all users.
	 * @param email
	 * @return User
	 */
	public User findUser(String email);
	
	/**
	 * This method is used to add a new user.
	 * @param user
	 */
	public void saveUser(User user);
}
