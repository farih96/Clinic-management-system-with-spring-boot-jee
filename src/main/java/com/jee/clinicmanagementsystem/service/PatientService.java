package com.jee.clinicmanagementsystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jee.clinicmanagementsystem.entity.Patient;
import com.jee.clinicmanagementsystem.repository.PatientRepository;

@Service
public class PatientService {
	 @Autowired
	 private PatientRepository patientRepository;
	 
	 public Patient findPatientById(long id) {
		  return patientRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid patient Id:" + id));
	  }
	 
	 public Patient savePatient(Patient patient) {
	        return patientRepository.save(patient);
	  }
	 
	 public Patient updatePatient(Patient patient) {
	        Patient patientToUpdate =  patientRepository.findById(patient.getId()).orElse(null);
	        if(patientToUpdate != null) {
	        	patientToUpdate.setFirstName(patient.getFirstName());
	        	patientToUpdate.setLastName(patient.getLastName());
	        	patientToUpdate.setAdress(patient.getAdress());
	        	patientToUpdate.setEmail(patient.getEmail());
	        	patientToUpdate.setPhoneNumber(patient.getPhoneNumber());
	        	patientToUpdate.setDateOfBirth(patient.getDateOfBirth());
	        	patientToUpdate.setSex(patient.getSex());
	        	savePatient(patientToUpdate);
	        	System.out.println("inside update");
	        }
	        return patientToUpdate;
	  }
}
