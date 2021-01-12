package com.jee.clinicmanagementsystem.controller;

import com.jee.clinicmanagementsystem.entity.Staff;
import com.jee.clinicmanagementsystem.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.naming.AuthenticationException;
import java.util.List;


@Controller

public class StaffController {

    @Autowired
    private StaffService staffService;

    @GetMapping("/")
    public String homePage(Authentication authentication){
        if(authentication == null || authentication instanceof AnonymousAuthenticationToken){
            return "redirect:/login";
        }
        else{
            if (authentication.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_ADMIN"))) {
                return "redirect:/admin/";
            } else if (authentication.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_GP"))) {
                return "redirect:/gp/";
            } else  {
                return "redirect:/med/";
            }
        }


    }

    @GetMapping("/login")
    public String loginPage(Authentication authentication) {

        if ( authentication == null || authentication instanceof AnonymousAuthenticationToken) {
            return "login";
        }

        return "redirect:/";

    }
    
    
/*
    @GetMapping("/")
    public String home() {
        return "index";
    }
    @GetMapping("/addstaff")
    public String addStaff(Model model) {
        model.addAttribute("staff", new Staff());
        return "signup_form";
    }
    @PostMapping("/addstaff")
    public String processAddStaff(Staff staff) {

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encodedPassword = encoder.encode(staff.getPassword());
        staff.setPassword(encodedPassword);

        staffService.saveStaff(staff);
        return "register_success";
    }

    @GetMapping("/users")
    public String listUsers(Model model) {
        List<Staff> listUsers = staffService.getAllStaff();
        model.addAttribute("listUsers", listUsers);

        return "users";
    }
    @GetMapping("/userindex")
    public String userindex() {
        return "gp/index";
    }
    @GetMapping("/adminindex")
    public String admin_index() {
        return "admin/admin_index";
    }

    @GetMapping("/login")
    public String loginpage() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if ( authentication == null || authentication instanceof AnonymousAuthenticationToken) {
            return "login";
        }
        return "redirect:/";
    }


    @GetMapping("/test")
    public String user() {
        return "admin/index";
    }
/*
    @GetMapping("/admin")
    public String admin() {
        return ("<h1>Welcome Admin</h1>");
    }*/

}
