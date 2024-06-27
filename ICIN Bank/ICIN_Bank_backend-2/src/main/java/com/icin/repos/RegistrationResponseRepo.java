package com.icin.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.icin.auth.RegistrationResponse;

public interface RegistrationResponseRepo extends JpaRepository<RegistrationResponse, Long> {

}
