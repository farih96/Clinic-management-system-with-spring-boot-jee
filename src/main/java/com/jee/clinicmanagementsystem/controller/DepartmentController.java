package com.jee.clinicmanagementsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jee.clinicmanagementsystem.entity.Department;
import com.jee.clinicmanagementsystem.entity.Staff;
import com.jee.clinicmanagementsystem.service.DepartmentService;
import com.jee.clinicmanagementsystem.service.StaffService;

@Controller
public class DepartmentController {
	
	@Autowired
	private DepartmentService departmentService;
	private StaffService staffService;
	
	@RequestMapping("/listdepartments")
    public String departmentsList(Model model) {
    	List<Department> listDepartments= departmentService.getAllDepartments();
    	model.addAttribute("listDepartments", listDepartments);
    	return"department_list";
	}
	
	

	
	/*@GetMapping("/docbydepartment/{id}")
    public String showDepartmentName(@PathVariable("id") long id, Model model) {
		Department department  = departmentService.findDepartmentById(id);
        model.addAttribute("department", department);
        
        return "/doctors_bydepartment";
    }*/
	
	/*@RequestMapping("/addstaff")
    public String departments(Model model) {
    	List<Department> listDepartment= departmentService.getAllDepartments();
    	model.addAttribute("listDepartment", listDepartment);
    	return"admin/add_staff";
	}*/

}
