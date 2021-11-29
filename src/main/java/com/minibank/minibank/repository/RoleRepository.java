package com.minibank.minibank.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.minibank.minibank.domain.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
	
	Role findByName(String name);

}
