package com.example.backend.springws;

import jakarta.websocket.OnClose;
import jakarta.websocket.OnMessage;
import jakarta.websocket.OnOpen;
import jakarta.websocket.Session;
import jakarta.websocket.server.ServerEndpoint;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Service
@ServerEndpoint(value="/chatt")
@CrossOrigin(origins = "*")
public class WebSocketChatt {
	private static Set<Session> clientSet = 
						Collections.synchronizedSet(new HashSet<Session>());
	public WebSocketChatt() {
		System.out.println("WebSocketChatt 객체 생성~~~");
	}
	@OnOpen
	public void onOpen(Session s) {
		if(!clientSet.contains(s)) {
			clientSet.add(s);
			s.setMaxIdleTimeout(60000);
			System.out.println("[세션 오픈] " + s);
		}else {
			System.out.println("이미 연결된 세션임!!!");
		}
	}
	
	@OnMessage
	public void onMessage(String msg, Session session) throws Exception{
		System.out.println("[수신 메시지] " + msg);
		for(Session s : clientSet) {
			System.out.println("[송신 메시지] " + msg);
			s.getBasicRemote().sendText(msg);
		}		
	}
	
	@OnClose
	public void onClose(Session s) {
		System.out.println("[세션 종료] " + s);
		try {
			s.close();
		} catch(Exception e) {}
		clientSet.remove(s);
	}
}
