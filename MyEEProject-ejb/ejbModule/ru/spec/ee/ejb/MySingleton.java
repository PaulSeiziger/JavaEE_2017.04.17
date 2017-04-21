package ru.spec.ee.ejb;

import java.util.Date;

import javax.annotation.PostConstruct;
import javax.ejb.LocalBean;
import javax.ejb.Schedule;
import javax.ejb.Schedules;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.enterprise.event.Observes;
import javax.enterprise.event.TransactionPhase;
import javax.interceptor.Interceptors;

/**
 * Session Bean implementation class MySingleton
 */
@Singleton(mappedName = "singleton")
@LocalBean
@Startup
public class MySingleton implements IMySingleton {

	int count = 0;

	/**
	 * Default constructor.
	 */
	public MySingleton() {
		System.out.println("+++++++MySingleton " + Thread.currentThread());
	}

	@PostConstruct
	void init() {
		System.out.println("+++--->MySingleton.init " + Thread.currentThread());
	}

//	@Schedules({ 
//		@Schedule(hour = "*", minute = "*", second = "*/10", persistent = false) })
//	@Interceptors({TimeLogger.class,})
	@LogTime
	public void logTime() {
		System.out.println(new Date());
	}

	@Override
	@LogTime(logResult=true)
	public String echo(@TextMessage @Observes(during=TransactionPhase.BEFORE_COMPLETION) String msg) {
		return msg;
	}
	@Override
	@LogTime(logResult=true)
	public String echoTextMsg(
			@Observes(during=TransactionPhase.BEFORE_COMPLETION) 
			@TextMessage 
			String msg) {
		return msg;
	}

}
