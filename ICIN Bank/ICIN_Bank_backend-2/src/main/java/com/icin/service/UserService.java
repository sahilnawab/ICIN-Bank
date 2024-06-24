package com.icin.service;

import java.util.List;

import com.icin.auth.RegistrationRequest;
import com.icin.auth.RegistrationResponse;
import com.icin.entity.User;

public interface UserService {

//	boolean UpdateUser(int id, User user);
	Double getBalance(String password);
	User getUser(int id);
	List<User> getAll();
	void removeUser(int id);
	RegistrationRequest ToRegistrationRequest(User user);

	
	
}
