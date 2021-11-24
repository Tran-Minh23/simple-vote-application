package com.springboot.vote.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.vote.model.Item;
import com.springboot.vote.service.ItemService;

@CrossOrigin
@RestController
public class ItemController {
	
	@Autowired
	ItemService itemService;
	SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
	
	// api for getting the items by the day filter
	// take vote_date as request param with "dd-MM-yyyy" format
	// if the request has any item, it will respond error 0 and a list of items
	// if the request doesn't find any item, it will respond with error 1 and not found message
	// if the request doesn't match with the format, it will respond error 2 and Invalid message
	@GetMapping("/items")
	public ResponseEntity<Map<String, Object>> findfindItemByCreatedOn(@RequestParam("vote_date") String date) {
		LinkedHashMap<String, Object> response= new LinkedHashMap<String, Object>();
		try {
			Date fromDate = simpleDateFormat.parse(date + " 00:00:00");
			Date toDate = simpleDateFormat.parse(date + " 23:59:59");
			
			ArrayList<Item> items = (ArrayList<Item>) itemService.findByCreatedOn(fromDate, toDate);
			if (items.isEmpty()) {
				response.put("errorCode", 1);
				response.put("message", "Not found any items");
				return new ResponseEntity<>(response, HttpStatus.OK);
			}
			response.put("errorCode", 0);
			response.put("data", items);
		} catch (ParseException e) {
			response.put("errorCode", 2);
			response.put("message", "Invalid input");
			e.printStackTrace();
			return new ResponseEntity<>(response, HttpStatus.OK);
		}
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
}
