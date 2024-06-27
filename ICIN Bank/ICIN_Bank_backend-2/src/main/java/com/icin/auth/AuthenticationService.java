package com.icin.auth;


import org.hibernate.boot.model.naming.IllegalIdentifierException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.icin.entity.AccountDetails;
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
		AccountDetails accountDetails=new AccountDetails();
		accountDetails.setAccountNumber(user.getAccountNumber());
		accountDetails.setBalance(user.getBalance());
		accountDetails.setIFSC(user.getIFSC());
		accountDetails.setUser(newUser);
		newUser.setAccountDetails(accountDetails);
		RegistrationResponse response = new RegistrationResponse();
		if(userRepo.save(newUser)!=null) {
		response.setMessage("Registration Sucssesfull");
		return responseRepo.save(response);
		}
		else {
			//TO DO _ BETTER EXCEPTION HANDLING
			response.setMessage("Something went wrong");
			return response;
		}
	}

	public String throwException() {
		throw new IllegalStateException("Something Went Wrong");
	}
}
