package com.icin.service;

import java.util.List;

import com.icin.entity.User;

public interface UserService {

	User register(User user);
//	boolean UpdateUser(int id, User user);
	Double getBalance(String password);
	boolean login(String email,String Password);
	User getUser(int id);
	List<User> getAll();
	void removeUser(int id);
	
	
	
}
