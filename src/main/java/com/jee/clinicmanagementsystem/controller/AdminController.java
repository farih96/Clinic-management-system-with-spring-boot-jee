package com.jee.clinicmanagementsystem.controller;

import com.jee.clinicmanagementsystem.entity.Department;
import com.jee.clinicmanagementsystem.entity.Patient;
import com.jee.clinicmanagementsystem.entity.Staff;
import com.jee.clinicmanagementsystem.service.DepartmentService;
import com.jee.clinicmanagementsystem.service.RdvService;
import com.jee.clinicmanagementsystem.service.StaffService;

import java.util.List;

import com.sun.el.stream.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private StaffService staffService;
    @Autowired
    private RdvService rdvService;
    @Autowired
    private DepartmentService departmentService;
    
    public void loggedUser(Model model) {
    	Authentication loggedInUser = SecurityContextHolder.getContext().getAuthentication();
	    String email = loggedInUser.getName(); 
	    Staff staff = staffService.findStaffByEmail(email);
	    model.addAttribute("staffinfo", staff);
    }

    @GetMapping("/")
    public String adminHome(Model model) {
    	loggedUser(model);
        return "admin/index";
    }
    
    @RequestMapping("/liststaff")
    public String staffList(Model model) {
    	List<Staff> listStaff = staffService.getAllStaff();
    	model.addAttribute("listStaff", listStaff);
    	loggedUser(model);
    	return"admin/staff_list";
    }
    
    @GetMapping("/admintest")
    public String adminTest(Model model) {
    	loggedUser(model);
        return "users";
    }
    @GetMapping("/addstaff")
    public String addStaffForm(Model model) {
    	model.addAttribute("staff", new Staff());
    	model.addAttribute("departments", departmentService.getAllDepartments());
    	
    	loggedUser(model);
        return "admin/add_staff";
    }

    @PostMapping("/addstaff")
    public String processAddStaff(Staff staff) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encodedPassword = encoder.encode(staff.getPassword());
        staff.setPassword(encodedPassword);
        staffService.saveStaff(staff);
        return "redirect:/admin/";
    }
    @GetMapping("/editstaff/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        Staff staff  = staffService.findStaffById(id);
        model.addAttribute("staff", staff);
        loggedUser(model);
        return "admin/edit_staff";
    }

    @PostMapping("/editstaff")
    public String processUpdateForm(Staff staff) {
    	staffService.updateStaff(staff);
    	
    	return "redirect:/admin/";
        

    }
    
     
    @RequestMapping("/deletestaff/{id}")
    public String deleteStaff(@PathVariable("id") Long id) {
    	 staffService.deletestaff(id);
    	 //rdvService.deleteByStaffId(id);
    	return "redirect:/admin/";

    }
    
  
}
