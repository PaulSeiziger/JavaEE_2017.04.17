package ru.spec.rmi;

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

	public static void main(String[] args) throws NamingException {
		Context ctx = new InitialContext();

//		stateles(ctx);
		
		IMySingleton singleton = (IMySingleton) ctx.lookup("singleton");
		singleton.echo("ok");

	}

	private static void stateles(Context ctx) throws NamingException {
		IEchoService echoBean = (IEchoService) ctx.lookup("echoBean");

		System.out.println(echoBean.getClass().getName());

		String result = echoBean.echo("hello");
		System.out.println(result);

		for (int i = 0; i < 100; i++) {
			new Thread(() -> {
				int res = echoBean.incrementAndGet();
				System.out.println(res);
			}).start();
		}
	}

}
