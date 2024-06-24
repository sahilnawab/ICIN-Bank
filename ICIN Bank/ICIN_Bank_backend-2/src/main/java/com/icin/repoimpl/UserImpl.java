package com.icin.repoimpl;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.icin.Exception.UserNotFoundExcetion;
import com.icin.auth.RegistrationRequest;
import com.icin.auth.RegistrationResponse;
import com.icin.entity.Role;
import com.icin.entity.User;
import com.icin.repos.RegistrationResponseRepo;
import com.icin.repos.UserRepo;
import com.icin.service.UserService;

@Service
public class UserImpl implements UserService {

	@Autowired
	private UserRepo userrepo;

	@Autowired
	private PasswordEncoder encoder;

	@Autowired
	private RegistrationResponseRepo responseRepo;

	@Override
	public RegistrationResponse register(RegistrationRequest user) {
		User newUser = new User();
		newUser.setFirstName(user.getFirstName());
		newUser.setLastName(user.getLastName());
		newUser.setAge(user.getAge());
		newUser.setEmail(user.getEmail());
		newUser.setPhone(user.getPhone());
		newUser.setRole(Role.ROLE_CUSTOMER);
		newUser.setPassword(encoder.encode(user.getPassword()));
		RegistrationResponse response = new RegistrationResponse();
		response.setMessage("Registration Sucssesfull");
		return responseRepo.save(response);

	}

	@Override
	public Double getBalance(String password) {
		User user = null;
		double d;
		String pass = userrepo.findByPassword(password);
		if (pass.equals(password)) {
			d = user.getAccountDetails().getBalance();
		} else {
			return null;
		}
		return d;

	}

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

}
