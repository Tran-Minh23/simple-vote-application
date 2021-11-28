package com.springboot.vote.repository.copyuser;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.vote.model.copyuser.CopyUser;

@Repository
public interface CopyUserRepository extends JpaRepository<CopyUser, Long> {

}
