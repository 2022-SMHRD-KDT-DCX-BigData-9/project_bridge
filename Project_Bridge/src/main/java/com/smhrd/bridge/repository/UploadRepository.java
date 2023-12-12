package com.smhrd.bridge.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.smhrd.bridge.entity.UserInfo;
import com.smhrd.bridge.entity.UserSong;

@Repository
public interface UploadRepository extends JpaRepository<UserSong, String>{
	public List<UserSong> findByUserId(UserInfo userId);
}
