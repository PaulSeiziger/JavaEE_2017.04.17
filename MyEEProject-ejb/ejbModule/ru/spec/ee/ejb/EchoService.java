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
import javax.inject.Inject;
import javax.inject.Named;

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
	@Named
	double rnd;
	
	@Inject
	Event<Object> bus;
	
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
	public String echo(String msg){
    	testService.test();
    	System.out.println(rnd);
    	
    	System.out.println("--->"+testService.getClass().getName());
    	
    	bus.fire(msg);
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

}
