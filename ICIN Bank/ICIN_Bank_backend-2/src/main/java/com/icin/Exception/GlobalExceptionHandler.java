package com.icin.Exception;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> generalException(Exception exp){
		return ResponseEntity.badRequest()
				.body(exp.getMessage());
	}
	
	@ExceptionHandler(UsernameNotFoundException.class)
	public ResponseEntity<?> usernameNotFound(UsernameNotFoundException exp){
		return ResponseEntity.badRequest()
				.build();
	}
	@ExceptionHandler(UserNotFoundExcetion.class)
	public ResponseEntity<?> usernameNotFound(UserNotFoundExcetion exp){
		return ResponseEntity.badRequest()
				.body(exp.getMessage());
		}
}
