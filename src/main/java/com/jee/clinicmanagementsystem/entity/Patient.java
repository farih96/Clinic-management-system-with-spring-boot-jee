package com.jee.clinicmanagementsystem.entity;

import java.util.ArrayList;
import java.util.Date;

import java.util.List;

import java.util.Set;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;


@Entity
public class Patient {
	@Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String lastName;
    @Column(nullable = false)
    private String firstName;
    @Column(nullable = false , unique = true)
    private String email;
    private String phoneNumber;
    private String adress;
    private String sex;
    private Date dateOfBirth;
    
    @OneToMany(mappedBy="patient",fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private Set<Rdv> rdvs;
    
    /*@OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="patientId", referencedColumnName="id")
    List<Rdv> rdv = new ArrayList<>();
    
	public List<Rdv> getRdv() {
		return rdv;
	}


	public void setRdv(List<Rdv> rdv) {
		this.rdv = rdv;
	}*/


	public Patient(Long id, String lastName, String firstName, String email, String phoneNumber, String adress,String sex,Date dateOfBirth) {
		
		this.id = id;
		this.lastName = lastName;
		this.firstName = firstName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.adress = adress;
		this.sex = sex;
		this.dateOfBirth = dateOfBirth;
	}
	
	
	public String getSex() {
		return sex;
	}


	public void setSex(String sex) {
		this.sex = sex;
	}


	public Date getDateOfBirth() {
		return dateOfBirth;
	}


	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}


	public Patient() {
		
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPhoneNumber() {
		return phoneNumber;
	}


	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}


	public String getAdress() {
		return adress;
	}


	public void setAdress(String adress) {
		this.adress = adress;
	}
	
	
    
    
}
