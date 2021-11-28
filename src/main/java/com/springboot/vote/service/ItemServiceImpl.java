package com.springboot.vote.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.vote.model.voteapp.Item;
import com.springboot.vote.repository.voteapp.ItemRepository;

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
