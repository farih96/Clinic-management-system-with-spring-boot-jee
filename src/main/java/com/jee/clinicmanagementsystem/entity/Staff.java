package com.jee.clinicmanagementsystem.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
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

}
