package com.jee.clinicmanagementsystem.controller;

import com.jee.clinicmanagementsystem.entity.Patient;
import com.jee.clinicmanagementsystem.entity.Staff;
import com.jee.clinicmanagementsystem.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @GetMapping("/")
    public String gpHome() {
        return "gp/index";
    }
    
    @GetMapping("/addpatient")
    public String addPatientForm(Model model) {
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
    	 model.addAttribute("patient", patient);
         return "gp/edit-patient";	
    	
    }
    @PostMapping("/editpatient")
    public String processUpdatePatient(Patient patient) {
    	
    	patientService.updatePatient(patient);
        return "redirect:/gp/";
    }
}
