package com.cwm.studentmanagement.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.cwm.studentmanagement.model.Students;

/*
 * Copyright (c) 2026 Mahesh Shet
 * Licensed under the MIT License.
 */

public interface StudentRepository extends JpaRepository<Students, Long> {
	
	boolean existsByEmailIgnoreCase(String email);
	
	boolean existsByEmailIgnoreCaseAndIdNot(String email, Long id);
	
	Page<Students> findByActiveTrue(Pageable pageable);
	
	List<Students> findByActiveTrue();

}
