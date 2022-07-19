package com.student.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.student.domain.Student;

@Service
public interface StudentService {
	
	Student findStudentByStudentNumber(String studentNumber) throws Exception;
	Student findStudentByEmailAddress(String email) throws Exception;
	List<Student> findStudentByFirstName(String firstName) throws Exception;
	List<Student> findStudentByLastName(String lastName) throws Exception;
	
}
