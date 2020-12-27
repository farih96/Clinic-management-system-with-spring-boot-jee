package com.jee.clinicmanagementsystem.service;

import com.jee.clinicmanagementsystem.entity.Staff;
import com.jee.clinicmanagementsystem.repository.StaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
    public Staff findStaffById(Long id) {
        return staffRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
    }
    public Staff updateStaff(Staff staff) {

        Staff staffToUpdate = staffRepository.findById(staff.getId()).orElse(null);
        if (staffToUpdate!= null ) {
            staffToUpdate.setLastName(staff.getLastName());
            staffToUpdate.setFirstName(staff.getFirstName());
            staffToUpdate.setMatriculeNumber(staff.getMatriculeNumber());
            staffToUpdate.setEmail(staff.getEmail());
            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
            String encodedPassword = encoder.encode(staff.getPassword());
            staffToUpdate.setPassword(encodedPassword);

            staffToUpdate.setPhoneNumber(staff.getPhoneNumber());
            staffToUpdate.setRole(staff.getRole());
            
            staffRepository.save(staffToUpdate);
        }

        return staffToUpdate;


    }

}
