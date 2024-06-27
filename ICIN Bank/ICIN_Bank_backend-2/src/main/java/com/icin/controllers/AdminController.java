package com.icin.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.icin.entity.User;
import com.icin.models.UserModel;
import com.icin.service.UserService;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

	@Autowired
	private UserService service;
	
	
	@GetMapping("/alluser")
	public ResponseEntity<List<UserModel>> getAll(){
		List<UserModel> list = service.getAll()
				.stream()
				.map(service::toUserModel)
				.toList();
		return new ResponseEntity<List<UserModel>>(list, HttpStatus.OK);
		
	}
	@GetMapping("/user/{id}")
	public ResponseEntity<User> getUSer(@PathVariable("id") int eno){
		User user=service.getUser(eno);
		return new ResponseEntity<User>(user,HttpStatus.OK);
		
	}
	@DeleteMapping("/remove/{id}")
	public void deleteById(@PathVariable int id) {
		service.removeUser(id);
	}
}
  
 