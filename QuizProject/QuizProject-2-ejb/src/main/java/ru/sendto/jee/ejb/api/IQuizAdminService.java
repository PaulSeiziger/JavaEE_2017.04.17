package ru.sendto.jee.ejb.api;

import javax.ejb.Remote;

import ru.sendto.jee.ejb.entity.Quiz;

@Remote
public interface IQuizAdminService {

	Quiz addQuiz(String text /*, User u*/);

}