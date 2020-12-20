package com.jee.clinicmanagementsystem.controller;

import com.jee.clinicmanagementsystem.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/med")
public class MedController {
    @Autowired
    private StaffService staffService;

    @GetMapping("/")
    public String medHome() {
        return "med/index";
    }
}
