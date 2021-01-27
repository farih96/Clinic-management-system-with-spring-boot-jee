package com.jee.clinicmanagementsystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.jee.clinicmanagementsystem.entity.Department;
import com.jee.clinicmanagementsystem.entity.Staff;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long>{

	
	Department findDepartmentById(Long id);

	
	}
