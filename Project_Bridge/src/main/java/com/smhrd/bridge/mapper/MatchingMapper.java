package com.smhrd.bridge.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.smhrd.bridge.entity.UserInfo;
import com.smhrd.bridge.entity.UserSong;

@Mapper
public interface MatchingMapper {
	public List<UserInfo> matchingPage();
}
