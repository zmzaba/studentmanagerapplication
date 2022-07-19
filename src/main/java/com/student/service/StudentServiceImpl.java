package com.student.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import com.student.domain.Student;
import com.student.repositories.StudentRepository;

public class StudentServiceImpl implements StudentService {
	
	@Autowired
	private StudentRepository studentRepository;
	
	@Override
	public Student findStudentByStudentNumber(String studentNumber) throws Exception {
		
		Student student = studentRepository.findStudentByStudentNumber(studentNumber);
		
		if (student == null) {
			throw new Exception("Student not found");
		}
		
		return student;
	}

	@Override
	public Student findStudentByEmailAddress(String email) throws Exception {
		
		Student student = studentRepository.findStudentByEmail(email);
		
		if (student == null) {
			throw new Exception("Student not found");
		}
		
		return student;
	}

	@Override
	public List<Student> findStudentByFirstName(String firstName) throws Exception {
		
		List<Student> students = studentRepository.findStudentByFirstName(firstName);
		
		if (students == null) {
			throw new Exception("Student not found");
		}
		
		return students;
	}

	@Override
	public List<Student> findStudentByLastName(String lastName) throws Exception {
		
		List<Student> students = studentRepository.findStudentByLastName(lastName);
		
		if (students == null) {
			throw new Exception("Student not found");
		}
		
		return students;
	}

}