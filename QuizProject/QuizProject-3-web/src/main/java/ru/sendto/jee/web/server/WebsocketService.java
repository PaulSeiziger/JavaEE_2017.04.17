package ru.sendto.jee.web.server;

import java.io.IOException;
import java.util.logging.Logger;

import javax.annotation.Resource;
import javax.annotation.security.DenyAll;
import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.annotation.security.RunAs;
import javax.ejb.EJB;
import javax.ejb.Lock;
import javax.ejb.LockType;
import javax.ejb.SessionContext;
import javax.ejb.Singleton;
import javax.inject.Inject;
import javax.websocket.CloseReason;
import javax.websocket.EndpointConfig;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.PongMessage;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import ru.sendto.jee.ejb.QuizAdminService;

@ServerEndpoint(value="ws")
@Singleton
@Lock(LockType.READ)
public class WebsocketService {
	
	@EJB QuizAdminService quizService;
	@Inject Logger log;
	
	@Resource
	SessionContext sctx;
	
	@OnOpen
//	@RolesAllowed("admin")
//	@PermitAll
	public String onOpen(Session session, EndpointConfig endpointConfig) {
//		endpointConfig.getUserProperties()
		
//		sctx.getCallerPrincipal()
		
		session.getOpenSessions();
		try {
			session.getBasicRemote().sendText("hello");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		session.getAsyncRemote().sendText("hello");
		session.getOpenSessions()
			.forEach( s ->
				s.getAsyncRemote().sendText("hello")
			);
		return "hello";
	}
	
	@OnMessage
	public String onMessage(String message) {
		return "ok";
	}
	
	@OnMessage
	public void onMessage(byte[] message) {
		
	}
	
	@OnMessage
	public void onMessage(PongMessage message) {
		
	}
	
	@OnClose
	public void onClose(Session session, CloseReason closeReason) {
		
	}
	
	@OnError
	public void onError(Session session, Throwable throwable) {
		
	}
	
	
	
	

}
