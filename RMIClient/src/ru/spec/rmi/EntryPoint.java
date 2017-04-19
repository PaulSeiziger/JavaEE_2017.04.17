package ru.spec.rmi;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import ru.spec.ee.ejb.IEchoService;

/**
 * ����� �����
 * @author User
 *
 */
public class EntryPoint {

	
	public static void main(String[] args) throws NamingException {
		Context ctx = new InitialContext();

		IEchoService echoBean = 
				(IEchoService)ctx.lookup("echoBean");
		
		System.out.println(echoBean
				.getClass().getName());
		
		String result = echoBean.echo("hello");
		System.out.println(result);

	}

}
