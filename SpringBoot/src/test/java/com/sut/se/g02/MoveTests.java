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
        move.setDate(new Date());
        move.setNote("ย้าย");
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
            assertEquals(violations.size(), 1);
            
        }
        
    }


	// ทดสอบ Move เป็น notnull
    @Test
    public void testMoveNotNull() {
       Move move = new Move();
       move.setDate(new Date());
        move.setNote(null);
        try {
            entityManager.persist(move);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println();
            System.out.println("=================== Move เป็น notnull ======================");
            System.out.println(e.getMessage());
            System.out.println();
        }
    }


    
 	// ทดสอบ Move ความยาวเกิน
    @Test
    public void testMoveSizeOver() {
        Move move = new Move();
        move.setDate(new Date());
        move.setNote("ย้ายอีกกกกกกกกกกกกกกกกกกกกกกกกกกกกกกก");
        try {
            entityManager.persist(move);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
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
       move.setDate(new Date());
        move.setNote("----");
        try {
            entityManager.persist(move);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println();
            System.out.println("================== Move not ===========================");
            System.out.println(e.getMessage());
            System.out.println();
        }
    }

    // ทดสอบ sป้องกัน id ซ้ำ
    /*@Test
    public void testId() {
        Pay pay = new Pay();
        pay.setId(1L);
        pay.setDateandtime(new Timestamp(System.currentTimeMillis()));
        pay.setNote("มีเงินA");
        try {
            entityManager.persist(pay);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }*/
}


