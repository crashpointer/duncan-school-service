package org.duncan.service;

import org.duncan.entity.User;

/**
 * @author crash pointer
 * <p>Provides bridge between controller and database access layer.</p>
 */
public interface IUserService {
	
	/**
	 * <p>Search into all the users.</p>
	 * @param email
	 * @return User
	 */
	public User findUser(String email);
	
	/**
	 * <p>Add a new user.</p>
	 * @param user
	 */
	public void saveUser(User user);
	
}
