package com.jee.clinicmanagementsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jee.clinicmanagementsystem.entity.Department;
import com.jee.clinicmanagementsystem.service.DepartmentService;

@Controller
public class DepartmentController {
	
	@Autowired
	private DepartmentService departmentService;
	
	@RequestMapping("/listdepartments")
    public String departmentsList(Model model) {
    	List<Department> listDepartments= departmentService.getAllDepartments();
    	model.addAttribute("listDepartments", listDepartments);
    	return"department_list";
	}

}
