package com.smhrd.bridge.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smhrd.bridge.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository repo;
	
}
