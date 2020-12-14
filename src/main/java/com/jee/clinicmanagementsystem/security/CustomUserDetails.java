package com.jee.clinicmanagementsystem.security;

import com.jee.clinicmanagementsystem.entity.Staff;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class CustomUserDetails implements UserDetails {

    private Staff staff;
    private SimpleGrantedAuthority authority;


    public CustomUserDetails(Staff staff) {
        this.staff = staff;
        this.authority = new SimpleGrantedAuthority("ROLE_"+staff.getRole());
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Arrays.asList(authority);
    }

    @Override
    public String getPassword() {
        return staff.getPassword();
    }

    @Override
    public String getUsername() {
        return staff.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
    public String getFullName(){
        System.out.println(authority.toString());
        return staff.getFirstName()+' '+staff.getLastName();
    }
}
