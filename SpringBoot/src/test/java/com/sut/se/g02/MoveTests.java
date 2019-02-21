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


import javax.persistence.*;

import com.sut.se.g02.repository.*;
import com.sut.se.g02.entity.*;

@RunWith(SpringRunner.class)
@DataJpaTest
public class MoveTests {

	
    @Autowired
    private MoveRepository moveRepository;
    @Autowired
    private RecuperateRepository recuperateRepository;
    @Autowired
    private OwnerRepository ownerRepository;
    @Autowired
    private CageRepository cageRepository;
    
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


    // ทดสอบ save Move ปกติ
    @Test
    public void testSaveAll() {
        Move move = new Move();
        Recuperate r = this.recuperateRepository.findByRecuperateId(1L);
        Owner o = this.ownerRepository.findByOwnerId(1L);
        Cage c = this.cageRepository.findByCageId(1L);
        Nurse n = this.nurseRepository.findByNurseId(1L);
        move.setRecuperate(r);
        move.setOwner(o);
        move.setCage(c);
        move.setDate(new Date());
        move.setNote("ย้าย");
        move.setNurse(n);


        try {
            entityManager.persist(move);
            entityManager.flush();
            System.out.println();
            System.out.println("=================== OK ===================");
            //System.out.println(e.getMessage());
            System.out.println();
            //fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 2);
            
        }
        
    }


	// ทดสอบ Move เป็น Date : notnull
    @Test
    public void testMoveDateNotNull() {
        Move move = new Move();
        Recuperate r = this.recuperateRepository.findByRecuperateId(1L);
        Owner o = this.ownerRepository.findByOwnerId(1L);
        Cage c = this.cageRepository.findByCageId(1L);
        Nurse n = this.nurseRepository.findByNurseId(1L);
        move.setRecuperate(r);
        move.setOwner(o);
        move.setCage(c);
        move.setDate(null);
        move.setNote("null");
        move.setNurse(n);
        try {
            entityManager.persist(move);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 3);
            System.out.println();
            System.out.println("=================== Move เป็น Date : notnull ======================");
            System.out.println(e.getMessage());
            System.out.println();
        }
    }

    // ทดสอบ Move เป็น Recuperate : notnull
    @Test
    public void testMoveRecuperateNotNull() {
        Move move = new Move();
        //Recuperate r = this.recuperateRepository.findByRecuperateId(1L);
        Owner o = this.ownerRepository.findByOwnerId(1L);
        Cage c = this.cageRepository.findByCageId(1L);
        Nurse n = this.nurseRepository.findByNurseId(1L);
        move.setRecuperate(null);
        move.setOwner(o);
        move.setCage(c);
        move.setDate(new Date());
        move.setNote("hgffiutg");
        move.setNurse(n);
        try {
            entityManager.persist(move);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 2);
            System.out.println();
            System.out.println("=================== Move เป็น Recuperate : notnull ======================");
            System.out.println(e.getMessage());
            System.out.println();
        }
    }


    // ทดสอบ Move เป็น Owner : notnull
    @Test
    public void testMoveOwnerNotNull() {
        Move move = new Move();
        Recuperate r = this.recuperateRepository.findByRecuperateId(1L);
        //Owner o = this.ownerRepository.findByOwnerId(1L);
        Cage c = this.cageRepository.findByCageId(1L);
        Nurse n = this.nurseRepository.findByNurseId(1L);
        move.setRecuperate(r);
        move.setOwner(null);
        move.setCage(c);
        move.setDate(new Date());
        move.setNote("null");
        move.setNurse(n);
        try {
            entityManager.persist(move);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 2);
            System.out.println();
            System.out.println("=================== Move เป็น Owner : notnull ======================");
            System.out.println(e.getMessage());
            System.out.println();
        }
    }


    // ทดสอบ Move เป็น Cage : notnull
    @Test
    public void testMoveCageNotNull() {
        Move move = new Move();
        Recuperate r = this.recuperateRepository.findByRecuperateId(1L);
        Owner o = this.ownerRepository.findByOwnerId(1L);
        //Cage c = this.cageRepository.findByCageId(1L);
        Nurse n = this.nurseRepository.findByNurseId(1L);
        move.setRecuperate(r);
        move.setOwner(o);
        move.setCage(null);
        move.setDate(new Date());
        move.setNote("null");
        move.setNurse(n);
        try {
            entityManager.persist(move);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 3);
            System.out.println();
            System.out.println("=================== Move เป็น Cage : notnull ======================");
            System.out.println(e.getMessage());
            System.out.println();
        }
    }

    // ทดสอบ Move เป็น Nurse : notnull
    @Test
    public void testMoveNurseNotNull() {
        Move move = new Move();
        Recuperate r = this.recuperateRepository.findByRecuperateId(1L);
        Owner o = this.ownerRepository.findByOwnerId(1L);
        Cage c = this.cageRepository.findByCageId(1L);
        //Nurse n = this.nurseRepository.findByNurseId(1L);
        move.setRecuperate(r);
        move.setOwner(o);
        move.setCage(c);
        move.setDate(new Date());
        move.setNote("null");
        move.setNurse(null);
        try {
            entityManager.persist(move);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 3);
            System.out.println();
            System.out.println("=================== Move เป็น Nurse : notnull ======================");
            System.out.println(e.getMessage());
            System.out.println();
        }
    }



    
 	// ทดสอบ Move ความยาวเกิน
    @Test
    public void testMoveSizeOver() {
         Move move = new Move();
        Recuperate r = this.recuperateRepository.findByRecuperateId(1L);
        Owner o = this.ownerRepository.findByOwnerId(1L);
        Cage c = this.cageRepository.findByCageId(1L);
        Nurse n = this.nurseRepository.findByNurseId(1L);
        move.setRecuperate(r);
        move.setOwner(o);
        move.setCage(c);
        move.setDate(new Date());
        move.setNote("ย้ายยยยยยยยยยยยยยยยยยยยยยยยยยยยยยยยยย");
        move.setNurse(n);
        try {
            entityManager.persist(move);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 3);
            System.out.println();
            System.out.println("================= Move SizeOver =========================");
            System.out.println(e.getMessage());
            System.out.println();
        }
    }

    // ทดสอบ Move ไม่ตรง Pattern
   @Test
    public void testMoveNotPattern() {
         Move move = new Move();
        Recuperate r = this.recuperateRepository.findByRecuperateId(1L);
        Owner o = this.ownerRepository.findByOwnerId(1L);
        Cage c = this.cageRepository.findByCageId(1L);
        Nurse n = this.nurseRepository.findByNurseId(1L);
        move.setRecuperate(r);
        move.setOwner(o);
        move.setCage(c);
        move.setDate(new Date());
        move.setNote("123456");
        move.setNurse(n);
        try {
            entityManager.persist(move);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 3);
            System.out.println();
            System.out.println("================== Move not ===========================");
            System.out.println(e.getMessage());
            System.out.println();
        }
    }

    
}


