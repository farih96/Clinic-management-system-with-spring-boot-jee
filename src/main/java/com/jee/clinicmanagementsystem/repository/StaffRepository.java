package com.jee.clinicmanagementsystem.repository;

import com.jee.clinicmanagementsystem.entity.Staff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface StaffRepository extends JpaRepository<Staff, Long>{

   @Query("SELECT u FROM Staff u WHERE u.email = ?1")
    Staff findStaffByEmail(String email);
}
