package com.icin.repoimpl;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icin.Exception.UserNotFoundExcetion;
import com.icin.entity.User;
import com.icin.repos.UserRepo;
import com.icin.service.UserService;

@Service("userservice")
public class UserImpl implements UserService {

	@Autowired
	private UserRepo userrepo;
	
	@Override
	public User register(User user) {
		User user1=null;
		boolean isInserted= false;
		user1=userrepo.save(user);
		if(user1!=null) {
			isInserted=true;
			
		return user1;
		}
		else { 
			return null;}
	
	}

	@Override
	public boolean login(String email, String password) {
		boolean isFound=false ;
		
		User user = userrepo.findByEmailAndPassword(email, password); 
		
		if (user!=null)
		isFound= true;
		else isFound=false;
		

		return isFound;
	}

	@Override
	public Double getBalance(String password) {
		User user= null;
		double d;
		String pass= userrepo.findByPassword(password);
		if (pass.equals(password))
		{
			 d=user.getAccountDetails().getBalance();
		}
		else
			{return null;}
		return d;
	
	}

	@Override
	public User getUser(int id) {
	User u= null;
		Optional<User> option=	userrepo.findById(id);
		if (option.isPresent()) 
			u= option.get();
		else throw new UserNotFoundExcetion("USer not found with given id");
				return u;
	}

	@Override
	public List<User> getAll() {
		return userrepo.findAll();
		 
	}

	@Override
	public void removeUser(int id) {
		userrepo.deleteById(id);
		
	}

	


	
	}
