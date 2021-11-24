package com.springboot.vote.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.vote.model.Item;

public interface ItemRepository extends JpaRepository<Item, Long> {
	List<Item> findByCreatedOnBetween(Date fromDate, Date toDate);
}
