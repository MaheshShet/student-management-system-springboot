package com.cwm.studentmanagement.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.cwm.studentmanagement.dto.EnrollmentDTO;
import com.cwm.studentmanagement.model.Courses;
import com.cwm.studentmanagement.model.Enrollment;
import com.cwm.studentmanagement.model.Students;
import com.cwm.studentmanagement.repository.CourseRepository;
import com.cwm.studentmanagement.repository.EnrollmentRepository;
import com.cwm.studentmanagement.repository.StudentRepository;
import com.cwm.studentmanagement.service.EnrollmentService;

/*
 * Copyright (c) 2026 Mahesh Shet
 * Licensed under the MIT License.
 */

@Service
public class EnrollmentServiceImpl implements EnrollmentService {
	private static final Logger log = LoggerFactory.getLogger(EnrollmentServiceImpl.class);
	
	private final EnrollmentRepository enrollmentRepository;
	private final StudentRepository studentRepository;
	private final CourseRepository courseRepository;
	
	EnrollmentServiceImpl(EnrollmentRepository enrollmentRepository,
			StudentRepository studentRepository,
			CourseRepository courseRepository) 
	{
		this.enrollmentRepository = enrollmentRepository;
		this.studentRepository = studentRepository;
		this.courseRepository = courseRepository;
	}
	

	@Override
	public void enrollStudentToCourses(EnrollmentDTO enrollmentDTO) {
		log.info("request from enrollStudentToCourses");
		
		Students student = studentRepository.findById(enrollmentDTO.getStudentId())
				.orElseThrow(() -> new RuntimeException("Student not found"));
		
		for(Long courseId : enrollmentDTO.getCourseIds()) {
			Courses course = courseRepository.findById(courseId)
					.orElseThrow(() -> new RuntimeException("course not found"));
			
			if(enrollmentRepository.existsByStudentIdAndCourseId(enrollmentDTO.getStudentId(),
					courseId)) {
				continue;
			}
			
			Enrollment enrollment = new Enrollment();
			enrollment.setStudent(student);
			enrollment.setCourse(course);
			
			enrollmentRepository.save(enrollment);
		}
		
	}

}
