package org.duncan.service;

import org.duncan.entity.User;

public interface IUserService {
	public User findUserByEmail(String email);
	public void saveUser(User user);
}
