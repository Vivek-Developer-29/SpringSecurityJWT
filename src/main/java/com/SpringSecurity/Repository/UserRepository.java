package com.SpringSecurity.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.SpringSecurity.Entity.User;

public interface UserRepository extends JpaRepository<User, String>{
	public Optional<User> findByEmail(String email);

}
