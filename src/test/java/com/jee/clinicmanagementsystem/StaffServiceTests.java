package com.jee.clinicmanagementsystem;


import com.jee.clinicmanagementsystem.entity.Staff;
import com.jee.clinicmanagementsystem.repository.StaffRepository;
import com.jee.clinicmanagementsystem.service.StaffService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.stereotype.Component;
import org.springframework.test.annotation.Rollback;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class StaffServiceTests {

   /* @Autowired
    private TestEntityManager entityManager;*/

    @Autowired
    private StaffService repo;

    @Test
    public void testFindStaffByEmail() {
        String email = "test@test.com";
        Staff staff = repo.findStaffByEmail(email);
       //assertEquals("test@test.com", "test@test.com");
        assertNotNull(staff);
    }
}
