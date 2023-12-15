package com.smhrd.bridge.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smhrd.bridge.entity.UserInfo;
import com.smhrd.bridge.mapper.UserMapper;

@Service
public class UserService {

	@Autowired
	UserMapper mapper;

	public int register(UserInfo userinfo) {
		return mapper.register(userinfo);
	}

	public UserInfo login(UserInfo userinfo) {
		return mapper.login(userinfo);
	}
	
	// 회원정보수정
	public int update(UserInfo user) {
		return mapper.update(user);
	}
}
