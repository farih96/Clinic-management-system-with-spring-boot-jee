package com.jee.clinicmanagementsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jee.clinicmanagementsystem.entity.Department;
import com.jee.clinicmanagementsystem.entity.Staff;
import com.jee.clinicmanagementsystem.repository.DepartmentRepository;
import com.jee.clinicmanagementsystem.repository.PatientRepository;

@Service
public class DepartmentService {
	
	 @Autowired
	 private DepartmentRepository departmentRepository;
	 

	public List<Department> getAllDepartments() {
		 return departmentRepository.findAll();
	}
	
	
	public Department findDepartmentById(Long id) {
        return departmentRepository.findDepartmentById(id);
    }
	
}
