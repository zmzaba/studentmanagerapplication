package com.student;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import com.student.domain.Student;
import com.student.domain.StudentScore;
import com.student.repositories.StudentRepository;
import com.student.repositories.StudentScoreRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace=Replace.NONE)
@Rollback(false)
public class StudentRepositoryTest {

	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private StudentScoreRepository studentScoreRepository;
	
	@Autowired
	private TestEntityManager entityManager;
	//Test case to create/or register a new student
	@Test
	public void testCreateStudent() {
		
		Student student = new Student();
		student.setStudentNumber("Z524125M");
		student.setFirstName("Zithobile");
		student.setLastName("Mzaba");
		student.setEmailAddress("mzaba.zithobile2@gmail.com");
		student.setDateOfBirth("1992-11-03");
		student.setMobileNumber("0609130504");
		student.setCurrentScore("95");
		Student savedStudent = studentRepository.save(student);
		
		Student existStudent = entityManager.find(Student.class, savedStudent.getStudentNumber());
		assertThat(existStudent.getEmailAddress()).isEqualTo(student.getEmailAddress());
	}
	
	//Test case to find a student record
	
	@Test
	public void testFindStudentByStudentNumber() {
		String studentNumber = "Z524125M";
		Student student = studentRepository.findStudentByStudentNumber(studentNumber);
		assertThat(student).isNotNull();
	}
	
}