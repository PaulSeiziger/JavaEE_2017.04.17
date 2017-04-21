package ru.spec.ee.ejb;

import java.math.BigInteger;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import javax.annotation.PostConstruct;
import javax.ejb.AsyncResult;
import javax.ejb.Asynchronous;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.enterprise.event.Event;
import javax.enterprise.event.Observes;
import javax.inject.Inject;
import javax.jms.JMSException;
import javax.jms.TextMessage;

/**
 * Session Bean implementation class EchoService
 */
@Stateless(mappedName = "echoBean")
@LocalBean
public class EchoService implements IEchoService {

	
//	@EJB/*(lookup="test")*/
	@Inject
	TestService testService;

	@Inject
	@UserIdGenerator
	double rnd;

	@Inject
	Event<String> bus;
	
	@Inject
	@UserIdGenerator
	Event<Object> busCommon;
	
	int count=0;
    
    @PostConstruct
    public void init(){
    	
    }
    
    @Override
    public int incrementAndGet(){
    	
    	System.out.println("----"+Thread.currentThread());
    	try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return ++count;
    }
    
    /* (non-Javadoc)
	 * @see ru.spec.ee.ejb.IEchoService#echo(java.lang.String)
	 */
    @Override
	@LogTime(logResult=true)
	public String echo(String msg){
    	testService.test();
    	System.out.println(rnd);
    	
    	System.out.println("--->"+testService.getClass().getName());
    	
    	busCommon.fire(msg);
//    	busCommon.select(TextMessage.class).fire(event);
//    	new TypeLiteral<List<Map<String, Date>>>() {};
    	return "re:"+msg;
    }
    
    @Asynchronous
    @Override
    public Future<BigInteger> getFibonacciElement(int index){
    	try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException notImportant) {
			
		}
    	return new AsyncResult<>(BigInteger.TEN);
    }
    
    public void onTextMessage(@Observes TextMessage tm) throws JMSException {
		System.out.println("!!"+tm.getText());
	}

}
