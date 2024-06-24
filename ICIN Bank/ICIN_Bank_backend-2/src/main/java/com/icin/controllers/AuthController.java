package com.icin.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.icin.auth.AuthenticationService;
import com.icin.auth.RegistrationRequest;
import com.icin.auth.RegistrationResponse;
import com.icin.repos.RegistrationResponseRepo;
import com.icin.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

	@Autowired
	private RegistrationResponseRepo registrationrepo;
	
	@Autowired
	private AuthenticationService authenticationService;
	
	@PostMapping("/register")
	public ResponseEntity<RegistrationResponse> Register(@RequestBody @Valid RegistrationRequest request){
		RegistrationResponse response = authenticationService.register(request);
		return new ResponseEntity<RegistrationResponse>(response,HttpStatus.CREATED);
	}
	
	

}
