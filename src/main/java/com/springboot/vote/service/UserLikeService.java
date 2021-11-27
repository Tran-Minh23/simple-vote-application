package com.springboot.vote.service;

public interface UserLikeService {
	long countByItemId(long itemId);
	long findCountByIdItemIdAndIdUserId(long itemId, long userId);
	void insertToUserLike(long itemId, long userId, long count);
	void updateToUserLike(long itemId, long userId, long count);
}
