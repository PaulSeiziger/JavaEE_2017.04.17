package ru.sendto.jee.ejb.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the Answer database table.
 * 
 */
@Entity
@Table(name="Answer")
public class Answer extends ru.sendto.jee.ejb.entity.EntityBase implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private long id;

	@Column(nullable=false)
	private Timestamp timestamp;

	//bi-directional many-to-many association to Option
	@ManyToMany
	@JoinTable(
		name="AnswerOption"
		, joinColumns={
			@JoinColumn(name="AnswerId", nullable=false)
			}
		, inverseJoinColumns={
			@JoinColumn(name="OptionId", nullable=false)
			}
		)
	private List<Option> options;

	//bi-directional many-to-one association to User
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="userId", nullable=false)
	private User user;

	public Answer() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Timestamp getTimestamp() {
		return this.timestamp;
	}

	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}

	public List<Option> getOptions() {
		return this.options;
	}

	public void setOptions(List<Option> options) {
		this.options = options;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}