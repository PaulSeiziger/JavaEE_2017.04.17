package ru.sendto.jee.ejb.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the Option database table.
 * 
 */
@Entity
@Table(name="Option")
public class Option extends ru.sendto.jee.ejb.entity.EntityBase implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private long id;

	@Column(nullable=false)
	private boolean isCorrect;

	@Column(nullable=false, length=4096)
	private String text;

	//bi-directional many-to-many association to Answer
	@ManyToMany(mappedBy="options")
	private List<Answer> answers;

	//bi-directional many-to-one association to Quiz
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="quizId", nullable=false, referencedColumnName="id")
	private Quiz quiz;

	public Option() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public boolean getIsCorrect() {
		return this.isCorrect;
	}

	public void setIsCorrect(boolean isCorrect) {
		this.isCorrect = isCorrect;
	}

	public String getText() {
		return this.text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public List<Answer> getAnswers() {
		return this.answers;
	}

	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}

	public Quiz getQuiz() {
		return this.quiz;
	}

	public void setQuiz(Quiz quiz) {
		this.quiz = quiz;
	}

}