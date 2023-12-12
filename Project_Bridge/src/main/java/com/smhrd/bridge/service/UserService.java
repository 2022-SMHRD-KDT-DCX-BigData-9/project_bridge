package com.smhrd.bridge.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smhrd.bridge.entity.UserInfo;
import com.smhrd.bridge.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository repo;
	
	@PersistenceContext
    private EntityManager entityManager;

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
	
	// 회원정보수정
	@Transactional
	public void update(UserInfo user) {
		UserInfo findUser = entityManager.find(UserInfo.class, user.getUserId());
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String formattedBirthday = user.getUserBirthday().format(formatter);
		user.setUserBirthday(LocalDate.parse(formattedBirthday, formatter));
		
		findUser.setUserName(user.getUserName());
		findUser.setUserNick(user.getUserNick());
		findUser.setUserPw(user.getUserPw());
		findUser.setUserBirthday(user.getUserBirthday());
		findUser.setUserAddress(user.getUserAddress());
	}
}
