package com.jee.clinicmanagementsystem.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
@Entity
public class Department {
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	 @Column(name = "id")
	 private Long id;
	    @Column(nullable = false)
	    private String departmentName;
	    @Column(nullable = false)
	    private boolean status;
	    
	    @OneToMany(targetEntity = Staff.class, cascade = CascadeType.ALL)
	    @JoinColumn(name="department_id", referencedColumnName="id")
	    private List<Staff> staff= new ArrayList<>();
	    
	    public List<Staff> getStaff() {
			return staff;
		}



		public void setStaff(List<Staff> staff) {
			this.staff = staff;
		}



		public Department() {
	    	
	    }

		

		public Department(String departmentName, boolean status) {
			super();
			this.departmentName = departmentName;
			this.status = status;
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getDepartmentName() {
			return departmentName;
		}

		public void setDepartmentName(String departmentName) {
			this.departmentName = departmentName;
		}

		public boolean isStatus() {
			return status;
		}

		public void setStatus(boolean status) {
			this.status = status;
		}

		
	    

}
