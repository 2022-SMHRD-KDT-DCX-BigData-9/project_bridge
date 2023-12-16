package com.smhrd.bridge.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

import lombok.RequiredArgsConstructor;

@Configuration // Bean을 설정할 것이라는 어노테이션
@EnableWebSocketMessageBroker // WebSocket 서버 활성화
public class ChatConfig implements WebSocketMessageBrokerConfigurer {
			
	@Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        //클라이언트로 메세지를 응답 해 줄 때 prefix 정의 - 클라이언트가 메세지를 받을 때
		//ex) stomp.subscribe("/sub/chat/room/",function(){})

        registry.enableSimpleBroker("/queue", "/topic"); 
        //클라이언트에서 메세지 송신 시 붙일 prefix 정의 - 클라이언트가 메세지를 보낼때
        //ex) stomp.send("/sub/chat/room/",function(){})
        registry.setApplicationDestinationPrefixes("/app"); 
    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/bridge/chat") //handshake가 될 endpoint지정
                .setAllowedOrigins("*") //현재 구동되고 있는 서버와 다른 도메인에서도 접근 가능하게
                .withSockJS(); //SockJS사용
    }
}