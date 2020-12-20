package com.jee.clinicmanagementsystem.controller;

import com.jee.clinicmanagementsystem.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/gp")
public class GpController {

    @Autowired
    private StaffService staffService;

    @GetMapping("/")
    public String gpHome() {
        return "gp/index";
    }
}
