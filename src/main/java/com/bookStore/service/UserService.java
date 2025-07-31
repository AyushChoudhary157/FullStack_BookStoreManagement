package com.bookStore.service;

import com.bookStore.entity.User;

public interface UserService {
	public boolean registerUser(User user);
	public User loginUser(String email, String password);
	
}
