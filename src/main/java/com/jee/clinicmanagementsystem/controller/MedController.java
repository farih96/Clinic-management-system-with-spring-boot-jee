package com.jee.clinicmanagementsystem.controller;

import com.jee.clinicmanagementsystem.entity.Staff;
import com.jee.clinicmanagementsystem.service.DoctorService;
import com.jee.clinicmanagementsystem.service.StaffService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class MedController {
    @Autowired
    private StaffService staffService;

    /*@GetMapping("/")
    public String medHome() {
        return "med/index";
    }*/
    
    public void loggedUser(Model model) {
     	Authentication loggedInUser = SecurityContextHolder.getContext().getAuthentication();
 	    String email = loggedInUser.getName(); 
 	    Staff staff = staffService.findStaffByEmail(email);
 	    model.addAttribute("staffinfo", staff);
     }

 	@RequestMapping("/listdoctors")
    public String doctorsList(Model model) {
    	List<Staff> listDoctors= staffService.getAllDoctors();
    	model.addAttribute("listDoctors", listDoctors);
    	loggedUser(model);
    	return"doctors_list";
	}
 	
 	@RequestMapping("/docbydepartment/{id}")
    public String doctorsBydepartmentList(@PathVariable("id") Long id,  Model model) {
    	List<Staff>  listDoctorsbydepartment= staffService.findDocByDepartmentId(id);
    	model.addAttribute("listDoctorsbydepartment", listDoctorsbydepartment);
    	
    	return"doctors_bydepartment";
	}
    
    

}
