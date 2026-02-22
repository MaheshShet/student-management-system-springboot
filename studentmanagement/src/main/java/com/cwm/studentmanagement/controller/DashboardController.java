package com.cwm.studentmanagement.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/*
 * Copyright (c) 2026 Mahesh Shet
 * Licensed under the MIT License.
 */

@Controller
public class DashboardController {
	
	@GetMapping("/dashboard")
	public String dashboard() {
		return "dashboard";
	}

}
