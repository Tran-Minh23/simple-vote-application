package com.springboot.vote.service;

import java.util.Date;
import java.util.List;

import com.springboot.vote.model.Item;

public interface ItemService {
	void save(Item item);
	List<Item> findByCreatedOn(Date fromDate, Date toDate);
}
