package com.sut.se.g02;

import lombok.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.Collections;
import java.util.OptionalInt;
import java.util.Set;
import java.util.Date;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.Before;
import org.junit.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.sql.Timestamp;
import javax.persistence.*;

import com.sut.se.g02.repository.*;
import com.sut.se.g02.entity.*;

@RunWith(SpringRunner.class)
@DataJpaTest
public class RecupTests {

	
    @Autowired
    private RecuperateRepository recuperateRepository;
    @Autowired
    private TreatmentRepository treatmentRepository;
    @Autowired
    private CageRepository cageRepository;
    @Autowired
    private CageTypeRepository cageTypeRepository;
    @Autowired
    private NurseRepository nurseRepository;



	@Autowired
    private TestEntityManager entityManager;

    private Validator validator;

    @Before
    public void setup() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }


    // ทดสอบ save Recuperate ปกติ
    @Test
    public void testSaveAll() {
        Recuperate recuperate = new Recuperate();

        Treatment t = this.treatmentRepository.findByTreatmentId(1L);
        Cage c = this.cageRepository.findByCageId(1L);
        CageType ct = this.cageTypeRepository.findByCageTypeId(1L);
        Nurse n = this.nurseRepository.findByNurseId(1L);

        recuperate.setTreatment(t);
        recuperate.setCage(c);
        recuperate.setCageType(ct);
        recuperate.setDate(new Timestamp(System.currentTimeMillis()));
        recuperate.setNote("rec");
        recuperate.setNurse(n);
        try {
            entityManager.persist(recuperate);
            entityManager.flush();
            System.out.println();
            System.out.println("=================== OK ===================");
            //System.out.println(e.getMessage());
            System.out.println();
            //fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            
        }
        
    }



    // ทดสอบ Recuperate เป็น Note : notnull
    @Test
    public void testNoteNotNull() {
        Recuperate recuperate = new Recuperate();
        Treatment t = this.treatmentRepository.findByTreatmentId(1L);
        Cage c = this.cageRepository.findByCageId(1L);
        CageType ct = this.cageTypeRepository.findByCageTypeId(1L);
        Nurse n = this.nurseRepository.findByNurseId(1L);

        recuperate.setTreatment(t);
        recuperate.setCage(c);
        recuperate.setCageType(ct);
        recuperate.setDate(new Timestamp(System.currentTimeMillis()));
        recuperate.setNote(null);
        recuperate.setNurse(n);
        try {
            entityManager.persist(recuperate);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 2);
            System.out.println();
            System.out.println("=================== Recuperate เป็น notnull ======================");
            System.out.println(e.getMessage());
            System.out.println();
        }
    }

     // ทดสอบ Recuperate เป็น Date : notnull
    @Test
    public void testDateNotNull() {
        Recuperate recuperate = new Recuperate();
        Treatment t = this.treatmentRepository.findByTreatmentId(1L);
        Cage c = this.cageRepository.findByCageId(1L);
        CageType ct = this.cageTypeRepository.findByCageTypeId(1L);
        Nurse n = this.nurseRepository.findByNurseId(1L);

        recuperate.setTreatment(t);
        recuperate.setCage(c);
        recuperate.setCageType(ct);
        recuperate.setDate(null);
        recuperate.setNote("null");
        recuperate.setNurse(n);
        try {
            entityManager.persist(recuperate);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 2);
            System.out.println();
            System.out.println("=================== Recuperate เป็น Date : notnull ======================");
            System.out.println(e.getMessage());
            System.out.println();
        }
    }

    // ทดสอบ Recuperate เป็น Treatment : notnull
    @Test
    public void testTreatmentNotNull() {
        Recuperate recuperate = new Recuperate();
        //Treatment t = this.treatmentRepository.findByTreatmentId(1L);
        Cage c = this.cageRepository.findByCageId(1L);
        CageType ct = this.cageTypeRepository.findByCageTypeId(1L);
        Nurse n = this.nurseRepository.findByNurseId(1L);

        recuperate.setTreatment(null);
        recuperate.setCage(c);
        recuperate.setCageType(ct);
        recuperate.setDate(new Timestamp(System.currentTimeMillis()));
        recuperate.setNote("null");
        recuperate.setNurse(n);
        try {
            entityManager.persist(recuperate);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println();
            System.out.println("=================== Recuperate เป็น Treatment : notnull ======================");
            System.out.println(e.getMessage());
            System.out.println();
        }
    }

    // ทดสอบ Recuperate เป็น Cage : notnull
    @Test
    public void testCageNotNull() {
        Recuperate recuperate = new Recuperate();
        Treatment t = this.treatmentRepository.findByTreatmentId(1L);
        //Cage c = this.cageRepository.findByCageId(1L);
        CageType ct = this.cageTypeRepository.findByCageTypeId(1L);
        Nurse n = this.nurseRepository.findByNurseId(1L);

        recuperate.setTreatment(t);
        recuperate.setCage(null);
        recuperate.setCageType(ct);
        recuperate.setDate(new Timestamp(System.currentTimeMillis()));
        recuperate.setNote("null");
        recuperate.setNurse(n);
        try {
            entityManager.persist(recuperate);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 2);
            System.out.println();
            System.out.println("=================== Recuperate เป็น Cage : notnull ======================");
            System.out.println(e.getMessage());
            System.out.println();
        }
    }

    // ทดสอบ Recuperate เป็น CageType : notnull
    @Test
    public void testCageTypeNotNull() {
        Recuperate recuperate = new Recuperate();
        Treatment t = this.treatmentRepository.findByTreatmentId(1L);
        Cage c = this.cageRepository.findByCageId(1L);
        //CageType ct = this.cageTypeRepository.findByCageTypeId(1L);
        Nurse n = this.nurseRepository.findByNurseId(1L);

        recuperate.setTreatment(t);
        recuperate.setCage(c);
        recuperate.setCageType(null);
        recuperate.setDate(new Timestamp(System.currentTimeMillis()));
        recuperate.setNote("null");
        recuperate.setNurse(n);
        try {
            entityManager.persist(recuperate);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 2);
            System.out.println();
            System.out.println("=================== Recuperate เป็น CageType : notnull ======================");
            System.out.println(e.getMessage());
            System.out.println();
        }
    }

    // ทดสอบ Recuperate เป็น Nurse : notnull
    @Test
    public void testNurseNotNull() {
        Recuperate recuperate = new Recuperate();
        Treatment t = this.treatmentRepository.findByTreatmentId(1L);
        Cage c = this.cageRepository.findByCageId(1L);
        CageType ct = this.cageTypeRepository.findByCageTypeId(1L);
        //Nurse n = this.nurseRepository.findByNurseId(1L);

        recuperate.setTreatment(t);
        recuperate.setCage(c);
        recuperate.setCageType(ct);
        recuperate.setDate(new Timestamp(System.currentTimeMillis()));
        recuperate.setNote("null");
        recuperate.setNurse(null);
        try {
            entityManager.persist(recuperate);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 2);
            System.out.println();
            System.out.println("=================== Recuperate เป็น Nurse : notnull ======================");
            System.out.println(e.getMessage());
            System.out.println();
        }
    }


 	// ทดสอบ Recuperate ความยาวเกิน
    @Test
    public void testRecuperateSizeOver() {
    	Recuperate recuperate = new Recuperate();
        recuperate.setDate(new Timestamp(System.currentTimeMillis()));
        recuperate.setNote("reccccccccccccccccccccccccccccccccccc");
        try {
            entityManager.persist(recuperate);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 5);
            System.out.println();
            System.out.println("================= Recuperate SizeOver =========================");
            System.out.println(e.getMessage());
            System.out.println();
        }
    }

    // ทดสอบ Recuperate ไม่ตรง Pattern
   @Test
    public void testRecuperateNotPattern() {
        Recuperate recuperate = new Recuperate();

        recuperate.setDate(new Timestamp(System.currentTimeMillis()));
        recuperate.setNote("****");
        try {
            entityManager.persist(recuperate);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 5);
            System.out.println();
            System.out.println("================== Recuperate not ===========================");
            System.out.println(e.getMessage());
            System.out.println();
        }
    }

   
}


