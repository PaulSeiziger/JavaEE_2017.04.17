package ru.spec.rmi;

import java.math.BigInteger;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import ru.spec.ee.ejb.IEchoService;
import ru.spec.ee.ejb.IMySingleton;

/**
 * ����� �����
 * 
 * @author User
 *
 */
public class EntryPoint {

	public static void main(String[] args) throws NamingException, InterruptedException, ExecutionException {
		Context ctx = new InitialContext();

		stateles(ctx);
		
//		singleton(ctx);
		
//		future(ctx);
		
//		singleton.

	}

	private static void future(Context ctx) throws NamingException {
		IEchoService echoBean = (IEchoService) ctx.lookup("echoBean");
		
		Future<BigInteger> el = echoBean.getFibonacciElement(1);
		
//		el.get();
		for(;!el.isDone();){
			System.out.println(el.isDone());
		}

		System.out.println(el.isDone());
	}

	private static void singleton(Context ctx) throws NamingException {
		IMySingleton singleton = (IMySingleton) ctx.lookup("singleton");
		String res = singleton.echo("ok");
		System.out.println(res);
	}

	private static void stateles(Context ctx) throws NamingException {
		IEchoService echoBean = (IEchoService) ctx.lookup("echoBean");

		System.out.println(echoBean.getClass().getName());

		String result = echoBean.echo("hello");
		System.out.println(result);

//		for (int i = 0; i < 100; i++) {
//			new Thread(() -> {
//				int res = echoBean.incrementAndGet();
//				System.out.println(res);
//			}).start();
//		}
	}

}
