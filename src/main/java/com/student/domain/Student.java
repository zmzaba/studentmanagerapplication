package com.student.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="student")
public class Student {
	
	//@Id
	//@GeneratedValue(strategy=GenerationType.IDENTITY)
	//private long id;
	@Id
	private String studentNumber;
	@Column(nullable=false)
	private String firstName;
	@Column(nullable=false)
	private String lastName;
	private String mobileNumber;
	@Column(nullable=false, unique=true)
	private String emailAddress;
	private String dateOfBirth;
	private String currentScore;
	private String averageScore;
	
	public Student() {
	}
	
	public Student(String studentNumber, String firstName, String lastName, String mobileNumber, String emailAddress,
			String dateOfBirth, String currentScore, String averageScore) {

		this.studentNumber = studentNumber;
		this.firstName = firstName;
		this.lastName = lastName;
		this.mobileNumber = mobileNumber;
		this.emailAddress = emailAddress;
		this.dateOfBirth = dateOfBirth;
		this.currentScore = currentScore;
		this.averageScore = averageScore;
	}
	
	public String getStudentNumber() {
		return studentNumber;
	}
	
	public void setStudentNumber(String studentNumber) {
		this.studentNumber = studentNumber;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getCurrentScore() {
		return currentScore;
	}

	public void setCurrentScore(String currentScore) {
		this.currentScore = currentScore;
	}
	
	public String getAverageScore() {
		return averageScore;
	}
	
	public void setAverageScore(String averageScore) {
		this.averageScore = averageScore;
	}
}