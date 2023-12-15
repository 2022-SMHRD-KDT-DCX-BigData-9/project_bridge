package com.smhrd.bridge.service;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smhrd.bridge.converter.ImageConverter;
import com.smhrd.bridge.converter.ImageToBase64;
import com.smhrd.bridge.entity.UserInfo;
import com.smhrd.bridge.entity.UserSong;
import com.smhrd.bridge.mapper.UploadMapper;
import com.smhrd.bridge.mapper.UserMapper;

@Service
public class UploadService {
	
	@Autowired
	UploadMapper mapper;

	public void uploadMusic(UserSong usersong) {
		mapper.uploadMusic(usersong);
	}
	
	public List<UserSong> mypage(UserInfo member) throws IOException{
		List<UserSong> list = mapper.mypage(member);
		for(int i = 0; i < list.size(); i++) {
			UserSong contents = list.get(i);
			File file = new File("c:\\uploadMusic\\" + contents.getSong_file());
			ImageConverter<File, String> converter= new ImageToBase64();
			String fileStringValue = converter.convert(file);
			list.get(i).setSong_file(fileStringValue);
		}
		return list;		
	}	
}
