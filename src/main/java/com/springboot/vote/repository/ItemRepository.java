package com.springboot.vote.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.vote.model.Item;

public interface ItemRepository extends JpaRepository<Item, Long> {

}
