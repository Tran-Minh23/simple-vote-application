package com.springboot.vote.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.springboot.vote.model.UserLike;
import com.springboot.vote.model.UserLikeId;

@Transactional
public interface UserLikeRepository extends JpaRepository<UserLike, UserLikeId> {
	
	@Query(value = "SELECT sum(ul.count) from user_like ul where ul.item_id =:itemId", nativeQuery = true)
	long sumCountByIdItemId(@Param("itemId") long itemId);
	
	@Query(value = "SELECT ul.count from user_like ul where ul.item_id =:itemId and ul.user_id =:userId", nativeQuery = true)
	long findCountByIdItemIdAndIdUserId(@Param("itemId")long itemId, @Param("userId")long userId);
	
	@Modifying
	@Query(value = "INSERT into user_like (item_id, user_id, count) VALUES (:itemId, :userId, :count)", nativeQuery = true)
	void insertToUserLike(@Param("itemId") long itemId, @Param("userId") long userId, @Param("count") long count);
	
	@Modifying
	@Query(value = "UPDATE user_like ul set ul.count =:count where item_id =:itemId and user_id =:userId", nativeQuery = true)
	void updateToUserLike(@Param("itemId") long itemId, @Param("userId") long userId, @Param("count") long count);
}
