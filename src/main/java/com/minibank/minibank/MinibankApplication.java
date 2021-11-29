package com.minibank.minibank;

import java.util.ArrayList;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.minibank.minibank.domain.AppUser;
import com.minibank.minibank.domain.Role;
import com.minibank.minibank.service.AppUserService;

@SpringBootApplication
public class MinibankApplication {

	public static void main(String[] args) {
		SpringApplication.run(MinibankApplication.class, args);
	}
	
	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	
	@Bean
	CommandLineRunner run(AppUserService userService) {
		return args ->{
			userService.saveRole(new Role(null, "ROLE_USER"));
			userService.saveRole(new Role(null, "ROLE_MANAGER"));
			userService.saveRole(new Role(null, "ROLE_ADMIN"));
			userService.saveRole(new Role(null, "ROLE_SUPER_ADMIN"));
			
			userService.saveUser(new AppUser(null, "Guilherme", "gui", "12345", new ArrayList<>()));
			userService.saveUser(new AppUser(null, "Talita", "tata", "12345", new ArrayList<>()));
			userService.saveUser(new AppUser(null, "Rogério", "ro", "12345", new ArrayList<>()));
			userService.saveUser(new AppUser(null, "Bianca", "bia", "12345", new ArrayList<>()));
			
			userService.addRoleToUser("gui", "ROLE_SUPER_ADMIN");
			userService.addRoleToUser("tata", "ROLE_MANAGER");
			userService.addRoleToUser("ro", "ROLE_ADMIN");
			userService.addRoleToUser("bia", "ROLE_USER");
		};
	}

}
