package com.smhrd.bridge.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smhrd.bridge.entity.UserSong;
import com.smhrd.bridge.service.MatchingService;

@RestController
public class MatchingRestController {
	 @Autowired MatchingService service;
	 
	 @GetMapping("matchingPage/matchingProfile") 
	 public List<UserSong> matchingProfile(String user_id) { 
		 return	service.matchingProfile(user_id); 
	 }
}
