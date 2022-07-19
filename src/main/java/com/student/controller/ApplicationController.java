package com.student.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import com.student.domain.Student;
import com.student.domain.StudentScore;
import com.student.repositories.StudentRepository;
import com.student.repositories.StudentScoreRepository;

@Controller
public class ApplicationController {
	
	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private StudentScoreRepository studentScoreRepository;
	
	@GetMapping("/")
	public String index(Model model) {
		
		
		
		model.addAttribute("student", new Student());
		return "index";
	}
	
	@GetMapping("/search")
	public String search(Model model,String criteria, String keyword) { 
		
		List<Student> students = new ArrayList<Student>();
		if(criteria.equalsIgnoreCase("studentNumber")) {
			
			Student student = studentRepository.findStudentByStudentNumber(keyword);
			students.add(student);
			
		}
		
		else if(criteria.equalsIgnoreCase("firstName")) {
			students = studentRepository.findStudentByFirstName(keyword);
		}
		else if(criteria.equalsIgnoreCase("lastName")) {
			students = studentRepository.findStudentByLastName(keyword);
		}
		if(criteria.equalsIgnoreCase("emailAddress")) {
			
			Student student = studentRepository.findStudentByEmail(keyword);
			students.add(student);
			
		}
		
		else
			System.out.println("Invalid search criteria/details supplied.");
		
		model.addAttribute("students", students);
		return "student/listStudents";
	}
	
	
	@PostMapping("/save")
	public String createStudent(Student student) {
		
		saveStudent(student);
		saveStudentScore(student);
		
		return "student/success";
	}
	
	@PostMapping("/update")
	public String updateStudent(Student student) {
		
		Student dbStudent = studentRepository.findStudentByStudentNumber(student.getStudentNumber());
		dbStudent.setCurrentScore(student.getCurrentScore());
		dbStudent.setFirstName(student.getFirstName());
		
		saveStudent(dbStudent);
		updateStudentScore(student);
		
		return "student/success";
	}
	
	public void saveStudent(Student student) {
		studentRepository.save(student);
	}
	
	public void saveStudentScore(Student student) {
		
		StudentScore studentScore = new StudentScore(student.getStudentNumber(), student.getCurrentScore(), student.getCurrentScore());
		studentScoreRepository.save(studentScore);
	}
	
	public void updateStudentScore(Student student) {


        List<StudentScore> studentScoreList = studentScoreRepository.findStudentScoreByStudentNumber(student.getStudentNumber());
        StudentScore dbStudentScore = studentScoreList.get(studentScoreList.size() - 1);
        StudentScore studentScore = new StudentScore(student.getStudentNumber(), student.getCurrentScore(), dbStudentScore.getCurrentScore());
        studentScoreRepository.save(studentScore);
    }
	
	@GetMapping("/list")
	public String listStudents(Model model) {
		
		model.addAttribute("students", studentRepository.findAll());
		return "student/listStudents";
		
	}
	
	@PostMapping("/edit")
	public String editStudent(Student student, Model model) {
		
		Student editStudent = studentRepository.findStudentByStudentNumber(student.getStudentNumber());
		model.addAttribute("student", editStudent);
		
		return "student/edit";
	}
	
	@PostMapping("/score")
	public String scoreStudent(Student student, Model model) {
		
		Student editStudent = studentRepository.findStudentByStudentNumber(student.getStudentNumber());
		model.addAttribute("student", editStudent);
		
		return "student/score";
	}
	
	@PostMapping("/delete")
	public String deleteStudent(Student student) {
		
		Student delStudent = studentRepository.findStudentByStudentNumber(student.getStudentNumber()); 
		studentRepository.delete(delStudent);
		deleteStudentScore(student);
		
		return "student/success";
	}
	
	private void deleteStudentScore(Student student) {
		
		List<StudentScore> studentScoreList = studentScoreRepository.findStudentScoreByStudentNumber(student.getStudentNumber()); 
		studentScoreRepository.deleteAll(studentScoreList);
	}
	
}
