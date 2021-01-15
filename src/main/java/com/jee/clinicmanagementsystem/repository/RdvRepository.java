package com.jee.clinicmanagementsystem.repository;
import java.sql.Time;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.jee.clinicmanagementsystem.entity.Rdv;

@Repository
public interface RdvRepository extends JpaRepository<Rdv, Long> {
	/*
	@Query("SELECT r FROM Rdv r WHERE r.date = ?1")
	List<Rdv> findRdvByDate(Date date);*/
}
