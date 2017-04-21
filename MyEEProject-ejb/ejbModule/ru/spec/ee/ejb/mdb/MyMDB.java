package ru.spec.ee.ejb.mdb;

import java.util.HashMap;
import java.util.function.Consumer;

import javax.annotation.PostConstruct;
import javax.ejb.MessageDriven;
import javax.ejb.Singleton;
import javax.enterprise.event.Event;
import javax.enterprise.event.Observes;
import javax.inject.Inject;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * Message-Driven Bean implementation class for: MyMDB
 */
@MessageDriven(mappedName = "jms/QueueFromClientToServer")
public class MyMDB implements MessageListener {

	@Inject
	Event<Message> bus;

	HashMap<Class, Consumer<TextMessage>> route = new HashMap<>();
	
	@PostConstruct
	void init(){
		route.put(TextMessage.class, (TextMessage tm) ->{});
	}
	
	
	public void onMessage(Message msg) {
		bus.fire(msg);
		System.out.println("----"+msg);
	}
	
	

}
