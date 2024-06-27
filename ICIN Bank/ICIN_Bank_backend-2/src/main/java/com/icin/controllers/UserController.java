package com.icin.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.icin.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	//@AuthenticationPrincipal used to get currunt logged in user
	@GetMapping("/balance")
	public ResponseEntity<Double> getBalance(@AuthenticationPrincipal UserDetails details) {				
		double balance=userService.getBalance(details);
		return new ResponseEntity<Double>(balance, HttpStatus.OK);
	}
	
	@PostMapping("/updatebalance")
	@ResponseStatus(code = HttpStatus.CREATED)
	public ResponseEntity<Double> updateBalance(@AuthenticationPrincipal UserDetails details,@RequestBody @Valid BalanceEntity entity){
	double updatedBalance=userService.addBalance(details,entity.getAmount());
		return ResponseEntity.ok(updatedBalance);
	}
	
	
	
	
	
}
