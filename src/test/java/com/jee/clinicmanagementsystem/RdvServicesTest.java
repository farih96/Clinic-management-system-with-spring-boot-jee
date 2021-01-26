package com.jee.clinicmanagementsystem;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.jee.clinicmanagementsystem.service.RdvService;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class RdvServicesTest {
	  @Autowired
	    private RdvService rdvService;
	  
	  @Test
	  public void testCheckavailibility() {
		  String dt = "2020-02-10";
		  String hr = "12:00";
		  Date dt_date=null;
		  Date hr_date=null;
		  try {
			dt_date= new SimpleDateFormat("yyyy-MM-dd").parse(dt);
			hr_date= new SimpleDateFormat("HH:mm").parse(hr);
		} catch (ParseException e) {
			
			e.printStackTrace();
		} 
		 long r = rdvService.checkRdvAvailability(
				dt_date,
				hr_date,
				 Long.valueOf(2)
				  );
		 System.out.println(r);
		 assertEquals(1, r);
		  
	  }

}
