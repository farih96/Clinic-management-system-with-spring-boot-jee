package com.jee.clinicmanagementsystem.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Entity
public class Staff {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String lastName;
    @Column(nullable = false)
    private String firstName;
    @Column(nullable = false , unique = true)
    private Long matriculeNumber;
    @Column(nullable = false , unique = true)
    private String email;
    private String password;
    private String phoneNumber;
    private String role;
    //add active;

    public Staff(Long id, String lastName, String firstName, Long matriculeNumber, String email, String password, String phoneNumber, String role) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.matriculeNumber = matriculeNumber;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.role = role;
    }

    public Staff() {

    }

    public Long getId() {
        return id;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public Long getMatriculeNumber() {
        return matriculeNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getRole() {
        return role;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setMatriculeNumber(Long matriculeNumber) {
        this.matriculeNumber = matriculeNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
