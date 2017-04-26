package ru.sendto.jee.ejb.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the Quiz database table.
 * 
 */
@Entity
@Table(name="Quiz")
public class Quiz extends ru.sendto.jee.ejb.entity.EntityBase implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private long id;

	@Column(nullable=false)
	private Timestamp created;

	private Timestamp deleted;

	@Column(nullable=false)
	private boolean hasMultianswer;

	@Column(nullable=false, length=4096)
	private String text;

	//bi-directional many-to-one association to Option
	@OneToMany(mappedBy="quiz")
	private List<Option> options;

	//bi-directional many-to-one association to User
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="authorId", nullable=true)
	private User user;

	public Quiz() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Timestamp getCreated() {
		return this.created;
	}

	public void setCreated(Timestamp created) {
		this.created = created;
	}

	public Timestamp getDeleted() {
		return this.deleted;
	}

	public void setDeleted(Timestamp deleted) {
		this.deleted = deleted;
	}

	public boolean getHasMultianswer() {
		return this.hasMultianswer;
	}

	public void setHasMultianswer(boolean hasMultianswer) {
		this.hasMultianswer = hasMultianswer;
	}

	public String getText() {
		return this.text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public List<Option> getOptions() {
		return this.options;
	}

	public void setOptions(List<Option> options) {
		this.options = options;
	}

	public Option addOption(Option option) {
		getOptions().add(option);
		option.setQuiz(this);

		return option;
	}

	public Option removeOption(Option option) {
		getOptions().remove(option);
		option.setQuiz(null);

		return option;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}