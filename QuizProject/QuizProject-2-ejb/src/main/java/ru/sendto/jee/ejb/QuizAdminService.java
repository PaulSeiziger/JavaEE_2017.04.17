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
 * Session Bean implementation class QuizAdminService
 */
@Stateless(mappedName = "QuizAdminService")
@LocalBean
public class QuizAdminService implements IQuizAdminService {

	@PersistenceContext
    EntityManager em;
	
	@Override
	public Quiz addQuiz(String text  /*, User u*/){
		
		Quiz quiz = new Quiz();
		quiz.setText(text);
		em.persist(quiz);
		
//		quiz.getId()
		
		return quiz;
	}

	public List<Option> addOptions(long quizId, String... optionTexts){
		return null;
	}

	public List<Quiz> findQuizs(String criteria){
		return null;
	}
	
	public List<Quiz> getQuizList(int offset){
		return null;
	}
	
	public List<Answer> answerQuiz(long... optionIds){
		return null;
	}
	
	public List<Answer> getQuizResults(long quizId){
		return null;
	}
	

}
