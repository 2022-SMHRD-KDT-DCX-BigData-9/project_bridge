package com.smhrd.bridge.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.smhrd.bridge.entity.UserInfo;

@Repository
public interface UserRepository extends JpaRepository<UserInfo, String>{
	public UserInfo findByUserIdAndUserPw(String userId, String userPw);
}
