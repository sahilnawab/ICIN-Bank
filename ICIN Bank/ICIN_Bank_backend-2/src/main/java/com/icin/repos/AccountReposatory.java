package com.icin.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.icin.entity.AccountDetails;

@Repository
public interface AccountReposatory extends JpaRepository<AccountDetails, Integer>{

	
}
