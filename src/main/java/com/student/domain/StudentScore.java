package com.student.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;


@Entity
@Table(name="student_score")
public class StudentScore {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "incrementDomain")
    @GenericGenerator(name = "incrementDomain", strategy = "increment")
	private long id;
	private String studentNumber;
	private String currentScore;
	private String previousScore;
	
	public StudentScore() {
	}
	
	public StudentScore(String studentNumber, String currentScore, String previousScore) {
		this.studentNumber = studentNumber;
		this.currentScore = currentScore;
		this.previousScore = previousScore;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getStudentNumber() {
		return studentNumber;
	}

	public void setStudentNumber(String studentNumber) {
		this.studentNumber = studentNumber;
	}

	public String getCurrentScore() {
		return currentScore;
	}

	public void setCurrentScore(String currentScore) {
		this.currentScore = currentScore;
	}

	public String getPreviousScore() {
		return previousScore;
	}

	public void setPreviousScore(String previousScore) {
		this.previousScore = previousScore;
	}
}