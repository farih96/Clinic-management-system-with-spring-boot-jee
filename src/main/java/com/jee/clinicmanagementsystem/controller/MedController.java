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
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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
    @GetMapping("/rdvs/{date}")
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
    @GetMapping("/rdv/{id}")
    public String rdvDetails(@PathVariable("id") String rdvId,Model model) {
    	loggedUser(model);
    	Rdv rdv = rdvService.findRdvById(Long.valueOf(rdvId));
    	model.addAttribute("rdv", rdv);
    	return "med/rdv-details";
    	
    }
    @RequestMapping(value = "/donerdv", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public HashMap<String, Boolean> setRdvAsDone(HttpServletRequest request) {
    	String[] meds = request.getParameterValues("meds[]");
    	String[] scanners = request.getParameterValues("scanners[]");
    	String description = request.getParameter("description");
    	String rdvId = request.getParameter("rdvId");
    	Rdv rdv = rdvService.findRdvById(Long.valueOf(rdvId));
    	
    	rdv.setMeds(meds);
    	rdv.setScans(scanners);
    	rdv.setMessage(description);
    	rdv.setStatus(1);
    	
    	rdvService.saveRdv(rdv);
    	HashMap<String, Boolean> map = new HashMap<>();
    	map.put("traiter", true);
        
    	return map;
    	
    }
    
    
    

}
