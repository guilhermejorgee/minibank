package com.minibank.minibank.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.minibank.minibank.domain.AppUser;

public interface AppUserRepository extends JpaRepository<AppUser, Long> {
	
	AppUser findByUsername(String username);

}
