package com.springboot.vote.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserLike {
	
	@EmbeddedId
	private UserLikeId id;
	
	@ManyToOne
    @MapsId("userId")
    @JoinColumn(name = "user_id")
    private User user;
	
	@ManyToOne
    @MapsId("itemID")
    @JoinColumn(name = "item_id")
    private Item item;

    private int count;
}
