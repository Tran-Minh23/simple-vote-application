package com.springboot.vote.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.vote.model.Item;
import com.springboot.vote.repository.ItemRepository;

@Service
public class ItemServiceImpl implements ItemService {
	
	@Autowired
	ItemRepository itemRepository;
	
	@Override
	public void save(Item item) {
		itemRepository.save(item); 
	}

	@Override
	public List<Item> findByCreatedOn(Date fromDate, Date toDate) {
		return itemRepository.findByCreatedOnBetween(fromDate, toDate); 
	}
}
