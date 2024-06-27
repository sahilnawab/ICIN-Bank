package com.icin.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetails;

import com.icin.auth.RegistrationRequest;
import com.icin.auth.RegistrationResponse;
import com.icin.entity.AccountDetails;
import com.icin.entity.User;
import com.icin.models.UserModel;

public interface UserService {

//	boolean UpdateUser(int id, User user);
	User getUser(int id);
	List<User> getAll();
	void removeUser(int id);
	RegistrationRequest ToRegistrationRequest(User user);
	UserModel toUserModel(User user);	
	Double getBalance(UserDetails details);
	Double addBalance(UserDetails details,double amount);
}
