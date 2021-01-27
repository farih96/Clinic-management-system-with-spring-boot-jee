package com.jee.clinicmanagementsystem.controller;


import com.jee.clinicmanagementsystem.entity.Patient;
import com.jee.clinicmanagementsystem.entity.Rdv;
import com.jee.clinicmanagementsystem.entity.Staff;
import com.jee.clinicmanagementsystem.service.PatientService;
import com.jee.clinicmanagementsystem.service.RdvService;
import com.jee.clinicmanagementsystem.service.StaffService;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/gp")
public class GpController {

    @Autowired
    private PatientService patientService;
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
    public String gpHome(Model model) {
    	loggedUser(model);
        return "gp/index";
    }
////////////////// PATIENT METHODS ///////////
    @RequestMapping("/listpatients")
    public String patientsList(Model model) {
    	List<Patient> listPatients = patientService.getAllPatients();
    	model.addAttribute("listPatients", listPatients);
    	loggedUser(model);
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
    	return "redirect:/gp/";

    }
    ////////////////// END PATIENT METHODS ///////////
    
    ////////////// RDV METHODS ///////////
    @GetMapping("/addrdv")
    public String addRdvForm(Model model) {
    	loggedUser(model);
    	model.addAttribute("rdv", new Rdv());
    	// send all patient 
    	List<Patient> patients = patientService.getAllPatients();
    	model.addAttribute("patients", patients);
    	// send departement and doctors
         return "gp/add-rdv";	
    	
    }
    @RequestMapping(value = "/addrdv", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public HashMap<String,String> processAddRdvForm(HttpServletRequest request) {
    	//double checking
	    	long check = checkRdvAv(request);
	    	// to return a json type we will use a hashmap
	    	HashMap<String,String> map = new HashMap<>();
	        
	    	if(check==0) {
		    	Rdv rdvToSave = new Rdv();
		    	rdvToSave.setGpId(Long.valueOf(request.getParameter("patientId")));
		    	rdvToSave.setPatientId(Long.valueOf(request.getParameter("patientId")));
		    	rdvToSave.setMedId(Long.valueOf(request.getParameter("docId")));
		    	
		    	 String rdv_date = request.getParameter("date");
		    	 String rdv_time = request.getParameter("time");
		    	 Date rdvDate = null;
		    	 Date rdvTime = null;
		    	 
		    	 try {
		    		  rdvDate = new SimpleDateFormat("yyyy-MM-dd").parse(rdv_date);
		    		  rdvTime = new SimpleDateFormat("HH:mm").parse(rdv_time);
		    		  
		    	  } catch (ParseException e) {
		    		e.printStackTrace();
		    	  } 
		    	rdvToSave.setRdvDate(rdvDate);
		    	rdvToSave.setRdvTime(rdvTime);
		    	rdvToSave.setMessage(request.getParameter("message"));
		    	rdvService.saveRdv(rdvToSave);
		    	map.put("added", "true");
		        }
	    	else map.put("added", "false");
    	return map;
    }
    
   //check availability
   @RequestMapping(value = "/checkav", method = RequestMethod.POST, produces = "application/json")
   @ResponseBody
    public long checkRdvAv(HttpServletRequest request) {
	
	 String rdv_date = request.getParameter("date");
	 String rdv_time = request.getParameter("time");
	 String med_id = request.getParameter("docId"); 
	 Date rdvDate = null;
	 Date rdvTime = null;
	 
	 try {
		  rdvDate = new SimpleDateFormat("yyyy-MM-dd").parse(rdv_date);
		  rdvTime = new SimpleDateFormat("HH:mm").parse(rdv_time);
		  
	  } catch (ParseException e) {
		e.printStackTrace();
	  } 
	 
	  return rdvService.checkRdvAvailability(rdvDate,rdvTime,Long.valueOf(med_id));
	   
    }
   
    @GetMapping("/rdvs/{date}")
    public String allRDV(@PathVariable("date") String date,Model model) {
    	loggedUser(model);
    	// get date 
	    Date rdvsDate = null;
	    try {
  		  rdvsDate = new SimpleDateFormat("yyyy-MM-dd").parse(date);	  
	  	  } catch (ParseException e) {
	  		e.printStackTrace();
	  	  }
    	 List<Rdv> rdvs = rdvService.findRdvByDate(rdvsDate);
    	 
    	// link it to thymleaf
	    model.addAttribute("rdvs", rdvs);
         return "gp/all-rdv";	
    	
    }
    
    @GetMapping("/rdv/{id}")
    public String rdvDetails(@PathVariable("id") String rdvId,Model model) {
    	loggedUser(model);
    	Rdv rdv = rdvService.findRdvById(Long.valueOf(rdvId));
    	model.addAttribute("rdv", rdv);
    	return "gp/rdv-details";
    	
    }
    
}
