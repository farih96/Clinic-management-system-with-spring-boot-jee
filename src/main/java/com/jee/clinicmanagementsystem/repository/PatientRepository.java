package com.jee.clinicmanagementsystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.jee.clinicmanagementsystem.entity.Patient;
import com.jee.clinicmanagementsystem.entity.Staff;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long>{
	
	 @Query("SELECT u FROM Patient u WHERE u.email = ?1")
	    Patient findPatientByEmail(String email);

	 @Query("SELECT p FROM Patient p WHERE p.firstName LIKE %?1%"
			 + "OR p.lastName LIKE %?1%")
	 public List<Patient> search(String keyword);
	 
}
