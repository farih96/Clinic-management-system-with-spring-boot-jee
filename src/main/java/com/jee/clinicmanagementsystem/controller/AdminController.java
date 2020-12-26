package com.jee.clinicmanagementsystem.controller;

import com.jee.clinicmanagementsystem.entity.Staff;
import com.jee.clinicmanagementsystem.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private StaffService staffService;

    @GetMapping("/")
    public String adminHome() {
        System.out.println("adminhomepage");
        return "admin/index";
    }
    @GetMapping("/admintest")
    public String adminTest() {
        System.out.println("adminhomepage");
        return "users";
    }
    @GetMapping("/addstaff")
    public String addStaffForm(Model model) {
        model.addAttribute("staff", new Staff());
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
        return "admin/edit_staff";
    }

    @PostMapping("/editstaff")
    public String processUpdateForm(Staff staff) {

        return "admin/edit_staff";
    }

}
