package com.jee.clinicmanagementsystem.repository;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.jee.clinicmanagementsystem.entity.Rdv;

@Repository
public interface RdvRepository extends JpaRepository<Rdv, Long> {
	
	
	@Query("SELECT r FROM Rdv r WHERE r.rdvDate = ?1 and r.medId=?2")
	List<Rdv> getRdbByDateMed(Date rdv_date,Long med_id);
	
	
	@Query("SELECT COUNT(r) FROM Rdv r WHERE r.rdvDate = ?1 AND r.rdvTime =?2 and r.medId=?3")
	//Optional<Rdv> checkRdvAvailability(Date rdv_date,Date rdv_time,Long med_id);
	long checkRdvAvailability(Date rdv_date,Date rdv_time,Long med_id);
	
	@Query("SELECT r FROM Rdv r WHERE r.rdvDate = ?1")
	List<Rdv> findRdvByDate (Date rdv_date);
	
	List<Rdv> findRdvByPatientId (long patient_id);
}
