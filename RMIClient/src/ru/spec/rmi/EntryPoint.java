package ru.spec.rmi;

import java.math.BigInteger;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSContext;
import javax.jms.JMSException;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import ru.sendto.jee.ejb.api.IQuizAdminService;
import ru.sendto.jee.ejb.entity.Quiz;
import ru.spec.ee.ejb.IEchoService;
import ru.spec.ee.ejb.IMySingleton;

/**
 * ����� �����
 * 
 * @author User
 *
 */
public class EntryPoint {

	public static void main(String[] args) throws NamingException, InterruptedException, ExecutionException, JMSException {
		Context ctx = new InitialContext();

		IQuizAdminService quizBean 
			= (IQuizAdminService)ctx.lookup("QuizAdminService");
		
//		addQuiz(quizBean);
		
		quizBean.test();

//		jms_old_and_new(ctx);
		
		
//		stateles(ctx);
		
//		singleton(ctx);
		
//		future(ctx);
		
//		singleton.

	}

	private static void addQuiz(IQuizAdminService quizBean) {
		System.out.println("текст вопроса:");
		String text = 
				new Scanner(System.in).nextLine();
		
		Quiz quiz = quizBean.addQuiz(text);
		
		System.out.println(quiz.getId());
	}

	private static void jms_old_and_new(Context ctx) throws NamingException, JMSException {
		Queue queue = (Queue) ctx.lookup("jms/QueueFromClientToServer");
		ConnectionFactory cf = (ConnectionFactory) ctx.lookup("jms/__defaultConnectionFactory");
		
		jms2(queue, cf);
		
		oldJMS(queue, cf);
	}

	private static void jms2(Queue queue, ConnectionFactory cf) {
		JMSContext jmsCtx = cf.createContext();
		jmsCtx.createProducer()
			.send(queue, jmsCtx.createTextMessage("HELLO 2"));
	}

	private static void oldJMS(Queue queue, ConnectionFactory cf) throws JMSException {
		Connection con = cf.createConnection();
		Session session = con.createSession();
		TextMessage tm = session.createTextMessage();
		
		tm.setText("HELLO FROM CLIENT");
		session.createProducer(queue).send(tm);
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
