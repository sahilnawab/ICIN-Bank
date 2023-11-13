package com.icin.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.icin.entity.User;
import com.icin.service.UserService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

	@Autowired
	private UserService service;
	

	@PostMapping("/register")
	public ResponseEntity<User> Register(@RequestBody User user) 
	{
		User user1=service.register(user);
		ResponseEntity<User> response=new ResponseEntity<User>(user1,HttpStatus.CREATED) ;		
			
		return response;
	}
	
//	@GetMapping("/getbalance/get/{eno}")
//	public ResponseEntity<Double> getBalance( String password) {
//		double d=service.getBalance(password);
//		ResponseEntity<Double> response=new ResponseEntity<Double>(d,HttpStatus.OK);
//		return response;
//
//	}
	@GetMapping("/alluser")
	public ResponseEntity<List<User>> getAll(){
		List<User> list = service.getAll();
		return new ResponseEntity<List<User>>(list, HttpStatus.OK);
		
	}
	@GetMapping("/user/get/{id}")
	public ResponseEntity<User> getUSer(@PathVariable("id") int eno){
		User u=service.getUser(eno);
		return new ResponseEntity<User>(u,HttpStatus.OK);
		
	}
	@DeleteMapping("/remove/{id}")
	public void deleteById(@PathVariable int id) {
		service.removeUser(id);
	}
	
	}

