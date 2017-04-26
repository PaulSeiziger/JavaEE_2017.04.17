package ru.sendto.jee.ejb.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the User database table.
 * 
 */
@Entity
@Table(name="User")
public class User extends ru.sendto.jee.ejb.entity.EntityBase implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private long id;

	@Column(nullable=false, length=128)
	private String login;

	@Column(nullable=false, length=512)
	private String name;

	@Column(nullable=false, length=512)
	private String password;

	//bi-directional many-to-one association to Answer
	@OneToMany(mappedBy="user")
	private List<Answer> answers;

	//bi-directional many-to-one association to Quiz
	@OneToMany(mappedBy="user")
	private List<Quiz> quizs;

	public User() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getLogin() {
		return this.login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Answer> getAnswers() {
		return this.answers;
	}

	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}

	public Answer addAnswer(Answer answer) {
		getAnswers().add(answer);
		answer.setUser(this);

		return answer;
	}

	public Answer removeAnswer(Answer answer) {
		getAnswers().remove(answer);
		answer.setUser(null);

		return answer;
	}

	public List<Quiz> getQuizs() {
		return this.quizs;
	}

	public void setQuizs(List<Quiz> quizs) {
		this.quizs = quizs;
	}

	public Quiz addQuiz(Quiz quiz) {
		getQuizs().add(quiz);
		quiz.setUser(this);

		return quiz;
	}

	public Quiz removeQuiz(Quiz quiz) {
		getQuizs().remove(quiz);
		quiz.setUser(null);

		return quiz;
	}

}