package com.student.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.student.domain.StudentScore;

public interface StudentScoreRepository extends JpaRepository<StudentScore, Long> {
	
	@Query("SELECT s FROM StudentScore s WHERE s.studentNumber = ?1")
	List<StudentScore> findStudentScoreByStudentNumber(String studentNumber);
}