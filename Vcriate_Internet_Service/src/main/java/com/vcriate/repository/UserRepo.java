package com.vcriate.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vcriate.model.User;

public interface UserRepo extends JpaRepository<User, Long> {

	Optional<User> findByUsername(String username);

	User findByName(String name);
}
