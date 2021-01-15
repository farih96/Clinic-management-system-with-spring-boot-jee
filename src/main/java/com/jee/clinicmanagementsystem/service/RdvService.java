package com.jee.clinicmanagementsystem.service;

import java.sql.Time;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jee.clinicmanagementsystem.entity.Rdv;
import com.jee.clinicmanagementsystem.repository.RdvRepository;

@Service
public class RdvService {
	@Autowired
    private RdvRepository rdvRepository;
	
	
	public Rdv saveRdv(Rdv rdv) {
        return rdvRepository.save(rdv);
    } 

    public List<Rdv> findRdvByDate(Date date) {
       // return rdvRepository.findRdvByDate(date);
    	return null;
    }
    public List<Rdv> getAllRdv() {
        return rdvRepository.findAll();
    }
    public Rdv findRdvById(Long id) {
        return rdvRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid Rdv Id:" + id));
    }
    
    public void deleteRdv(Long id) {
    	rdvRepository.deleteById(id);
    }
}
