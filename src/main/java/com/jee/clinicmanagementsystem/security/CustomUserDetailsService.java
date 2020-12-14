package com.jee.clinicmanagementsystem.security;

import com.jee.clinicmanagementsystem.entity.Staff;
import com.jee.clinicmanagementsystem.repository.StaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private StaffRepository staffRepository;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Staff staff = staffRepository.findStaffByEmail(email);
        if(staff == null){
            throw new UsernameNotFoundException("User not found");
        }
        return new CustomUserDetails(staff);
    }
}
