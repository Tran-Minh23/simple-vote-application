package com.springboot.vote.repository.voteapp;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.vote.model.voteapp.Item;


public interface ItemRepository extends JpaRepository<Item, Long> {
	List<Item> findByCreatedOnBetween(Date fromDate, Date toDate);
}
