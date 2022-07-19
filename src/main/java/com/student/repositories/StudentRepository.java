package com.student.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.student.domain.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
	
	
	@Query("SELECT s FROM Student s WHERE s.studentNumber = ?1")
	Student findStudentByStudentNumber(String studentNumber);
	
	@Query("SELECT s FROM Student s WHERE s.emailAddress = ?1")
	Student findStudentByEmail(String email);
	
	@Query("SELECT s FROM Student s WHERE s.firstName = ?1")
	List<Student> findStudentByFirstName(String firstName);
	
	@Query("SELECT s FROM Student s WHERE s.lastName = ?1")
	List<Student> findStudentByLastName(String lastName);

}