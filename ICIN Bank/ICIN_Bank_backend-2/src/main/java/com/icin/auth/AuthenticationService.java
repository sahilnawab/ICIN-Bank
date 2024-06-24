package com.icin.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.icin.entity.Role;
import com.icin.entity.User;
import com.icin.repos.RegistrationResponseRepo;
import com.icin.repos.UserRepo;

@Service
public class AuthenticationService {

//	@Autowired
//	AuthenticationManager authenticationManager;

	@Autowired
	private PasswordEncoder encoder;

	@Autowired
	private RegistrationResponseRepo responseRepo;

	@Autowired
	private UserRepo userRepo;

	public RegistrationResponse register(RegistrationRequest user) {
		User newUser = new User();
		newUser.setFirstName(user.getFirstName());
		newUser.setLastName(user.getLastName());
		newUser.setAge(user.getAge());
		newUser.setEmail(user.getEmail());
		newUser.setPhone(user.getPhone());
		newUser.setRole(Role.ROLE_CUSTOMER);
		newUser.setPassword(encoder.encode(user.getPassword()));
		userRepo.save(newUser);
		RegistrationResponse response = new RegistrationResponse();
		response.setMessage("Registration Sucssesfull");
		return responseRepo.save(response);

	}

//	public String authenticate(LoginRequest loginRequest) {
//		Authentication authenticate = authenticationManager.authenticate(
//				new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));
//	
//	
//	}
}
