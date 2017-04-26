package ru.sendto.jee.ejb;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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
	
	/**
	 * Добавить опрос
	 */
	@Override
	public Quiz addQuiz(String text  /*, User u*/){
		
		Quiz quiz = new Quiz();
		quiz.setText(text);
		em.persist(quiz);
		
//		quiz.getId()
		
		return quiz;
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
