package com.cwm.studentmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cwm.studentmanagement.model.Enrollment;

/*
 * Copyright (c) 2026 Mahesh Shet
 * Licensed under the MIT License.
 */

public interface EnrollmentRepository extends JpaRepository<Enrollment, Long> {
	
	boolean existsByStudentIdAndCourseId(Long studentId, Long courseId);

}
