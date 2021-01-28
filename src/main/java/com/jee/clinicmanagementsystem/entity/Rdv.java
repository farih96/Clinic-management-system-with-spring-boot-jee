package com.jee.clinicmanagementsystem.entity;

//import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.*;
import java.sql.Time;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Rdv {
	 @Id
     @GeneratedValue( strategy = GenerationType.IDENTITY)
	 private long id;
	 private long gpId;

	 
	
	 @ManyToOne(fetch = FetchType.LAZY)
	 @JoinColumn(name="patient_id")
	 private Patient patient;
	 //private long patientId;
	 @ManyToOne(fetch = FetchType.LAZY)
	 @JoinColumn(name="staff_id")
	 private Staff doc;
	 private long medId;
	// @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy, timezone = UTC)
	 @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-mm-dd, timezone = UTC")
	 @Temporal(TemporalType.DATE)
	 private Date rdvDate;
	 
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="HH:mm, timezone = UTC")
	 @Temporal(TemporalType.TIME)
	 private Date rdvTime;
	 private int status;
     private String message;
	 private String[] meds;
	 private String[] scans;
	 
	 public Staff getDoc() {
			return doc;
	 }

	public void setDoc(Staff doc) {
			this.doc = doc;
	}
	 
	 public String[] getMeds() {
		return meds;
	}

	public void setMeds(String[] meds) {
		this.meds = meds;
	}

	public String[] getScans() {
		return scans;
	}

	public void setScans(String[] scans) {
		this.scans = scans;
	}


	 
	public Rdv() {
		
	}

	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public long getGpId() {
		return gpId;
	}
	
	public void setGpId(long gpId) {
		this.gpId = gpId;
	}
	
	/*public long getPatientId() {
		return patientId;
	}
	
	public void setPatientId(long patientId) {
		this.patientId = patientId;
	}*/
	
	
	public long getMedId() {
		return medId;
	}
	
	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public void setMedId(long medId) {
		this.medId = medId;
	}
	
	public Date getRdvDate() {
		return rdvDate;
	}
	
	public void setRdvDate(Date rdvDate) {
		this.rdvDate = rdvDate;
	}
	
	public Date getRdvTime() {
		return rdvTime;
	}
	
	public void setRdvTime(Date rdvTime) {
		this.rdvTime = rdvTime;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	 	 
 
}
