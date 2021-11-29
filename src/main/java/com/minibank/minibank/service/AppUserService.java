package com.minibank.minibank.service;

import java.util.List;

import com.minibank.minibank.domain.AppUser;
import com.minibank.minibank.domain.Role;

public interface AppUserService {
	
	AppUser saveUser(AppUser user);
	Role saveRole(Role role);
	void addRoleToUser(String username, String roleName);
	AppUser getUser(String username);
	List<AppUser>getUsers();

}
