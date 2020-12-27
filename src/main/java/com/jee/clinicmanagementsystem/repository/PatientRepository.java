package com.jee.clinicmanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jee.clinicmanagementsystem.entity.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long>{
	
	

}
