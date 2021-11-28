package com.springboot.vote.repository.voteapp;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.vote.model.voteapp.User;


public interface UserRepository extends JpaRepository<User, Long> {
	User findByEmail(String email);
}
