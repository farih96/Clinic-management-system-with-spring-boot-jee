package com.jee.clinicmanagementsystem.service;

import com.jee.clinicmanagementsystem.entity.Staff;
import com.jee.clinicmanagementsystem.repository.StaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StaffService {
    @Autowired
    private StaffRepository staffRepository;

    public Staff saveStaff(Staff staff) {
        return staffRepository.save(staff);
    }

    public Staff findStaffByEmail(String email) {
        return staffRepository.findStaffByEmail(email);
    }
    public List<Staff> getAllStaff() {
        return staffRepository.findAll();
    }

}
