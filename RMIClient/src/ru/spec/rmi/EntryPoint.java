package ru.spec.rmi;

import java.util.Scanner;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import ru.sendto.jee.ejb.IQuizAdminService;
import ru.sendto.jee.ejb.entity.Quiz;
import ru.spec.ee.ejb.IEchoService;
import ru.spec.ee.ejb.IMySingleton;

/**
 * Точка входа
 * 
 * @author User
 *
 */
public class EntryPoint {

	public static void main(String[] args) throws NamingException {
		Context ctx = new InitialContext();

		IQuizAdminService quizBean 
			= (IQuizAdminService)ctx.lookup("QuizAdminService");
		
		System.out.println("текст вопроса:");
		String text = 
				new Scanner(System.in).nextLine();
		
		Quiz quiz = quizBean.addQuiz(text);
		
		System.out.println(quiz.getId());

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
