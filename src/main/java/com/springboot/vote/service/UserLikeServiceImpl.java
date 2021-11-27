package com.springboot.vote.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.vote.repository.UserLikeRepository;

@Service
public class UserLikeServiceImpl implements UserLikeService {
	
	@Autowired
	UserLikeRepository userLikeRepository;

	@Override
	public long countByItemId(long itemId) {
		long count = 0;
		try {
			count = userLikeRepository.sumCountByIdItemId(itemId);
		}
		catch(Exception e) {
			e.printStackTrace();
			return count = 0;
		}
		return count;
	}

	@Override
	public long findCountByIdItemIdAndIdUserId(long itemId, long userId) {
		long count = 0;
		try {
			count = userLikeRepository.findCountByIdItemIdAndIdUserId(itemId, userId);
		}
		catch(Exception e) {
			e.printStackTrace();
			return count = 0;
		}
		return userLikeRepository.findCountByIdItemIdAndIdUserId(itemId, userId);
	}

	@Override
	public void insertToUserLike(long itemId, long userId, long count) {
		userLikeRepository.insertToUserLike(itemId, userId, count);
	}

	@Override
	public void updateToUserLike(long itemId, long userId, long count) {
		userLikeRepository.updateToUserLike(itemId, userId, count);
	}
	
}
