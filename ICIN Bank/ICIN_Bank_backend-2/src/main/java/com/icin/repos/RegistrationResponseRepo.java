package com.icin.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.icin.auth.RegistrationResponse;
import com.icin.entity.User;

public interface RegistrationResponseRepo extends JpaRepository<RegistrationResponse, Long> {

//	User	FindByApplicationNumber();

}
