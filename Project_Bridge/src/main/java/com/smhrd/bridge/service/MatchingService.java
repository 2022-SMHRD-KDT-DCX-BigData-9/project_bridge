package com.smhrd.bridge.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smhrd.bridge.entity.UserInfo;
import com.smhrd.bridge.entity.UserSong;
import com.smhrd.bridge.mapper.MatchingMapper;

@Service
public class MatchingService {
	
	@Autowired
	MatchingMapper mapper;
	
	public List<UserInfo> matchingPage() {
		return mapper.matchingPage();
	}
	
	public List<UserSong> matchingProfile(String user_id){
		return mapper.matchingProfile(user_id);
	}
}
