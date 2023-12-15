package com.smhrd.bridge.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.smhrd.bridge.entity.SongList;
import com.smhrd.bridge.entity.UserInfo;
import com.smhrd.bridge.entity.UserLikeList;

@Mapper
public interface UserMapper {
	// 회원가입
	public int register(UserInfo userinfo);
	
	// 로그인
	public UserInfo login(UserInfo userinfo);
	
	// 선택한 노래 저장
	public int songList(UserLikeList userlikelist);
	
	// 노래 다 불러오기
	public List<SongList> allSong();
	
	// 회원 정보 수정
	public int update(UserInfo user);
}
