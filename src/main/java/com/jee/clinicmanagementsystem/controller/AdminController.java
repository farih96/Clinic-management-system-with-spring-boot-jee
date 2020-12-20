package com.jee.clinicmanagementsystem.controller;

import com.jee.clinicmanagementsystem.entity.Staff;
import com.jee.clinicmanagementsystem.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
        return "admin/add_gp_med";
    }
    @PostMapping("/addstaff")
    public String processAddStaff(Staff staff) {

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encodedPassword = encoder.encode(staff.getPassword());
        staff.setPassword(encodedPassword);
        staffService.saveStaff(staff);
        return "admin/index";
    }
}
