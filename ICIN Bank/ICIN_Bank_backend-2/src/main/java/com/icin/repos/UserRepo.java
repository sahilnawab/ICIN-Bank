package com.icin.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.icin.entity.User;

public interface UserRepo extends JpaRepository<User, Integer>
{
	  User findByEmailAndPassword(String email, String Password); 
	  String findByPassword(String password);
}
