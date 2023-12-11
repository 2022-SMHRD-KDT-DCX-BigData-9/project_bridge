package com.smhrd.bridge.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smhrd.bridge.entity.UserInfo;
import com.smhrd.bridge.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository repo;

	public UserInfo register(UserInfo user) {
		// 형변환을 시켜줘야 DB에 저장이 된다
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String formattedBirthday = user.getUserBirthday().format(formatter);
		user.setUserBirthday(LocalDate.parse(formattedBirthday, formatter));
		
		return repo.save(user);
	}

	public UserInfo login(UserInfo user) {
		return repo.findByUserIdAndUserPw(user.getUserId(), user.getUserPw());
	}
}
