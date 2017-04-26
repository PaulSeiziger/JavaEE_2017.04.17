package ru.sendto.jee.ejb;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ru.sendto.jee.ejb.entity.Quiz;
import ru.sendto.jee.ejb.entity.User;

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

}
