package com.jee.clinicmanagementsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jee.clinicmanagementsystem.entity.Department;
import com.jee.clinicmanagementsystem.entity.Staff;
import com.jee.clinicmanagementsystem.service.DepartmentService;
import com.jee.clinicmanagementsystem.service.StaffService;

@Controller
public class DoctorController {
	
	 @Autowired
	    private StaffService staffService;
	 	private DepartmentService departmentService;
	 	
	 	


	 	
		
}
