package com.jee.clinicmanagementsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan({ "com.jee.clinicmanagementsystem.*" })
public class ClinicmanagementsystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(ClinicmanagementsystemApplication.class, args);
    }

}
