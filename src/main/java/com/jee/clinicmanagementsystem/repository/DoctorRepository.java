package com.jee.clinicmanagementsystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.jee.clinicmanagementsystem.entity.Staff;

@Repository
public interface DoctorRepository {

	

	//@Query(value = "SELECT email FROM Staff, Department WHERE Staff.departmentId=Department.id and Department.department_name!='GP' and Department.department_name!='ADMIN' " )
}
