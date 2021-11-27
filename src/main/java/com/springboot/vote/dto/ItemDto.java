package com.springboot.vote.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemDto {
	private Long id;
	private String title;
	private String content;
	private Date createdOn;
	private Long likes;
	private Long currentUserLike;
}
