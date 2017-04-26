package ru.sendto.jee.ejb;

import javax.ejb.Remote;

import ru.sendto.jee.ejb.entity.Quiz;

@Remote
public interface IQuizAdminService {

	Quiz addQuiz(String text /*, User u*/);

}