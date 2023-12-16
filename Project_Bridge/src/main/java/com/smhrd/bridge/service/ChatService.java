/**
 * 
 */
package com.smhrd.bridge.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import com.smhrd.bridge.entity.ChatRoom;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class ChatService {
	
	private Map<String, ChatRoom> chatRooms;
	
	// 이 부분을 DB와 연결하면 될듯.
	
    @PostConstruct
    //의존관게 주입완료되면 실행되는 코드
    private void init() {
        chatRooms = new LinkedHashMap<>();
    }

    //채팅방 불러오기
    public List<ChatRoom> findAllRoom() {
        //채팅방 최근 생성 순으로 반환 // chatRooms에 저장되고 있음.
        List<ChatRoom> result = new ArrayList<>(chatRooms.values());
        System.out.println(chatRooms.values());
        Collections.reverse(result);
        return result;
    }

    //채팅방 하나 불러오기
    public ChatRoom findById(String roomId) {
        return chatRooms.get(roomId);
    }

    //채팅방 생성
    public ChatRoom createRoom(String name) {
        ChatRoom chatRoom = ChatRoom.create(name);
        chatRooms.put(chatRoom.getRoomId(), chatRoom);
        return chatRoom;
    }

}
