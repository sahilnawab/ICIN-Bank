package com.icin.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.icin.Exception.UserNotFoundExcetion;
import com.icin.auth.RegistrationRequest;
import com.icin.entity.AccountDetails;
import com.icin.entity.User;
import com.icin.models.UserModel;
import com.icin.repos.UserRepo;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepo userrepo;

	@Override
	public User getUser(int id) {
		User user = null;
		Optional<User> option = userrepo.findById(id);
		if (option.isPresent())
			user = option.get();
		else
			throw new UserNotFoundExcetion("USer not found with given id");
		return user;
	}

	@Override
	public List<User> getAll() {
		return userrepo.findAll();

	}

	@Override
	public void removeUser(int id) {
		userrepo.deleteById(id);

	}

	@Override
	public RegistrationRequest ToRegistrationRequest(User user) {
		RegistrationRequest request = new RegistrationRequest(user.getFirstName(), user.getLastName(), user.getEmail(),
				user.getPhone(), user.getPassword(), user.getAge());
		return request;
	}

	@Override
	public UserModel toUserModel(User user) {
		UserModel model = new UserModel(user.getFirstName(), user.getLastName(), user.getEmail(), user.getPhone(),
				user.getAge());
		return model;
	}

	@Override
	public Double getBalance(UserDetails details) {
		return userrepo.findByEmail(details.getUsername()).get().getAccountDetails().getBalance();
	}

	@Override
	public Double addBalance(UserDetails details, double amount) {
		User user = userrepo.findByEmail(details.getUsername())
				.orElseThrow(() -> new UsernameNotFoundException("user not found"));

		double balance = user.getAccountDetails().getBalance();
		Double updatedBalance = balance + amount;
		user.getAccountDetails().setBalance(updatedBalance);
			User updatedUser=userrepo.save(user);
		if(updatedUser!=null) {
		return updatedBalance;
		}
		else {
			throw new IllegalStateException("something went wrong");
		}
	}
}
