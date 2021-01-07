package com.jee.clinicmanagementsystem.controller;


import com.jee.clinicmanagementsystem.entity.Patient;
import com.jee.clinicmanagementsystem.entity.Staff;
import com.jee.clinicmanagementsystem.service.PatientService;
import com.jee.clinicmanagementsystem.service.StaffService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/gp")
public class GpController {

    @Autowired
    private PatientService patientService;
    @Autowired
    private StaffService staffService;
    
    public void loggedUser(Model model) {
    	Authentication loggedInUser = SecurityContextHolder.getContext().getAuthentication();
	    String email = loggedInUser.getName(); 
	    Staff staff = staffService.findStaffByEmail(email);
	    model.addAttribute("staffinfo", staff);
    }

    @GetMapping("/")
    public String gpHome(Model model) {
    	loggedUser(model);
        return "gp/index";
    }
    
    @RequestMapping("/listpatients")
    public String patientsList(Model model) {
    	List<Patient> listPatients = patientService.getAllPatients();
    	model.addAttribute("listPatients", listPatients);
    	return"gp/patients_list";
    }
    

    @GetMapping("/addpatient")
    public String addPatientForm(Model model) {
    	loggedUser(model);
    	 model.addAttribute("patient", new Patient());
         return "gp/add-patient";	
    	
    }
    @PostMapping("/addpatient")
    public String processAddPatient(Patient patient) {
    	
    	patientService.savePatient(patient);
        return "redirect:/gp/";
    }
    
    @GetMapping("/editpatient/{id}")
    public String updatePatientForm(@PathVariable("id") long id,Model model) {
    	  Patient patient  = patientService.findPatientById(id);
    	  loggedUser(model);
    	  model.addAttribute("patient", patient);
         return "gp/edit-patient";	
    	
    }
    @PostMapping("/editpatient")
    public String processUpdatePatient(Patient patient) {
    	
    	patientService.updatePatient(patient);
        return "redirect:/gp/";
    }
    
    @RequestMapping("/deletepatient/{id}")
    public String deletePatient(@PathVariable("id") Long id) {
    	 patientService.deletepatient(id);
    	return "redirect:/gp/patients_list";

    }

}
