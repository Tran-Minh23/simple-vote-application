package com.springboot.vote.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.vote.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
	User findByEmail(String email);
}
