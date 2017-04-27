package ru.sendto.jee.ejb;

import java.util.List;

import javax.annotation.Resource;
import javax.ejb.ApplicationException;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ru.sendto.jee.ejb.api.IQuizAdminService;
import ru.sendto.jee.ejb.entity.Answer;
import ru.sendto.jee.ejb.entity.Option;
import ru.sendto.jee.ejb.entity.Quiz;

/**
 * Сервис проведения опросов
 */
@Stateless(mappedName = "QuizAdminService")
@LocalBean
public class QuizAdminService implements IQuizAdminService {

	@PersistenceContext
    EntityManager em;
	
	@Resource
	SessionContext sctx;

	@Inject
	QuizAdminService self;
	
	@EJB
	QuizAdminService self2;
	
	/**
	 * Добавить опрос
	 */
	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public Quiz addQuiz(String text  /*, User u*/){
		
//		this.getClass()
		
		Quiz quiz = new Quiz();
		quiz.setText(text);
		em.persist(quiz);
		
//		quiz.getId()
		
		return quiz;
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	public void test(){
		Query nativeQuery = em.createNativeQuery("SELECT * "
				+ "FROM Quiz "
				+ "WHERE 1 ",Quiz.class);
//		nativeQuery.
		
		self.addQuiz("---hello world---");
		
		List<Quiz> resultList = em.createQuery(
				"SELECT q "
				+ "FROM Quiz q "
//				+ "WHERE q.user.login = :userLogin "
				+ "",Quiz.class)
//			.setParameter("userLogin", "user1")
			.setMaxResults(10)
			.setFirstResult(0)
			.getResultList();
		
//		Option opt = resultList.get(0);
//		em.detach(opt);
		
//		em.
		
//		option.setIsCorrect(false);
		
		resultList.forEach(q->System.out.println(q.getText()));
		
		
		
//		em.createNamedQuery("Quiz.findAll", Quiz.class);
		
		self.throwExeprion();
		System.out.println("end");
		
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	private void throwExeprion() {
		try {
			throw new Exception("Oh no!");
		} catch (Exception e) {
			sctx.setRollbackOnly();
			e.printStackTrace();
		}
	}

	/**
	 * Добавить опцию к опросу
	 * @param quizId
	 * @param optionTexts
	 * @return
	 */
	public List<Option> addOptions(long quizId, String... optionTexts){
		return null;
	}
	
	/**
	 * Завершить опрос
	 */
	public void closeQuiz(long quizId){
		
	}

	/**
	 * Найти опрос по тексту опроса
	 * @param criteria - поисковой запрос
	 * @return
	 */
	public List<Quiz> findQuizs(String criteria){
		return null;
	}
	
	/**
	 * Получить список вопросов
	 * @param offset 
	 * @return
	 */
	public List<Quiz> getQuizList(int offset){
		return null;
	}
	
	/**
	 * Добавить ответ на опрос
	 * @param optionIds
	 * @return
	 */
	public List<Answer> answerQuiz(long... optionIds){
		return null;
	}
	/**
	 * Получить результаты опроса
	 * @param quizId
	 * @return
	 */
	public List<Answer> getQuizResults(long quizId){
		return null;
	}
	

}
