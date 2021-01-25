package com.jee.clinicmanagementsystem.controller;

import com.jee.clinicmanagementsystem.entity.Rdv;
import com.jee.clinicmanagementsystem.entity.Staff;
import com.jee.clinicmanagementsystem.service.DoctorService;
import com.jee.clinicmanagementsystem.service.RdvService;
import com.jee.clinicmanagementsystem.service.StaffService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/med")
public class MedController {
    @Autowired
    private StaffService staffService;
    @Autowired
    private RdvService rdvService;
    
    public void loggedUser(Model model) {
    	Authentication loggedInUser = SecurityContextHolder.getContext().getAuthentication();
	    String email = loggedInUser.getName(); 
	    Staff staff = staffService.findStaffByEmail(email);
	    model.addAttribute("staffinfo", staff);
    }
    
    @GetMapping("/")
    public String medHome(Model model) {
    	loggedUser(model);
    	
        return "med/index";
    }
    
    
    /////////////////////////////////////////////////
    /********************* RDV *********************/
    @GetMapping("/rdv/{date}")
    public String rdvByDate(@PathVariable("date") String date,Model model) {
    	loggedUser(model);
    	// get med id 
    	Authentication loggedInUser = SecurityContextHolder.getContext().getAuthentication();
    	String email = loggedInUser.getName(); 
	    Staff staff = staffService.findStaffByEmail(email);
	    Long medId = staff.getId(); 
	    
    	// get date 
	    Date rdvsDate = null;
	    try {
  		  rdvsDate = new SimpleDateFormat("yyyy-MM-dd").parse(date);	  
	  	  } catch (ParseException e) {
	  		e.printStackTrace();
	  	  }
    	// user service to get all rdv 
	    List<Rdv> rdvs = rdvService.getRdbByDateMed(rdvsDate, medId);
    	// link it to thymleaf
	    model.addAttribute("rdvs", rdvs);
	    return "med/my-rdvs";
    	
    }
    
    
    

}
