package com.jee.clinicmanagementsystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

import com.jee.clinicmanagementsystem.entity.Department;
import com.jee.clinicmanagementsystem.entity.Staff;
import com.jee.clinicmanagementsystem.repository.DepartmentRepository;
import com.jee.clinicmanagementsystem.repository.StaffRepository;


@SpringBootApplication
@ComponentScan({ "com.jee.clinicmanagementsystem.*" })
@EnableAutoConfiguration(exclude = {ErrorMvcAutoConfiguration.class})
public class ClinicmanagementsystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(ClinicmanagementsystemApplication.class, args);
    }
    
    
    /* @Autowired
    private DepartmentRepository departmentrepository;
    private StaffRepository staffrepository;
    
    @Override
	public void run(String... args) throws Exception {
    	
    	Department department = new Department("Gynecology", false);
    	
    	Staff staff1 = new Staff( "yaass", "yaya", 1111L, "yasser1@gmail.com", "$10$QrU0LcD.PJ8ckXacMALaO.9Kv4EjoXndffo2sdB9kbJRJredSw3qK", "060708095", "MED");
    	Staff staff2 = new Staff( "fas", "yayo", 1411L, "yassmina@gmail.com", "$10$QrU0LcD.PJ8ckXacMALaO.9Kv4EjoXndffo2sdB9kbJRJredSw3qK", "060888095", "MED");
    	
    	department.getStaff().add(staff1);
    	department.getStaff().add(staff2);
    	
    	this.departmentrepository.save(department);
		
		
	}*/
}

	
