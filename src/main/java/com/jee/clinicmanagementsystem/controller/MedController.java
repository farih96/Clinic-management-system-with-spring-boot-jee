package com.jee.clinicmanagementsystem.controller;

import com.jee.clinicmanagementsystem.entity.Staff;
import com.jee.clinicmanagementsystem.service.DoctorService;
import com.jee.clinicmanagementsystem.service.StaffService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class MedController {
    @Autowired
    private StaffService staffService;

    /*@GetMapping("/")
    public String medHome() {
        return "med/index";
    }*/
    
    

}
