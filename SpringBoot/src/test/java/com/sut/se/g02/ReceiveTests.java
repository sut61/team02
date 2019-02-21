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

public class ReceiveTests {


    @Autowired
    private ReceiveMedicineRepository receiveMedicineRepository;

    @Autowired
    private OrderMedicineRepository orderMedicineRepository;
    @Autowired
    private NurseRepository nurseRepository;
    @Autowired
    private CheckStatusRepository checkStatusRepository;


    @Autowired
    private TestEntityManager entityManager;

    private Validator validator;

    @Before
    public void setup() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }
    @Test
    public void FinishReceive() {
        ReceiveMedicine receiveMedicine = new ReceiveMedicine();

        OrderMedicine o = this.orderMedicineRepository.findByOrderMedicineId(1L);
        CheckStatus c = this.checkStatusRepository.findByCheckStatusId(1L);
        Nurse n = this.nurseRepository.findByNurseId(1L);

        receiveMedicine.setOrderMedicine(o);
        receiveMedicine.setCheckStatus(c);
        receiveMedicine.setNurse(n);
        receiveMedicine.setNoteNew("มาจ้าาาา");

        try {
            entityManager.persist(receiveMedicine);
            entityManager.flush();
            //fail("Should not pass to this line");
            System.out.println();
            System.out.println("----------> Finish  Compile Receive <--------------------");
            //System.out.println(e.getMessage());
            System.out.println();
            System.out.println();
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);

        }

    }

    @Test
    public void CannotNullReceive() {
         ReceiveMedicine receiveMedicine = new ReceiveMedicine();

         OrderMedicine o = this.orderMedicineRepository.findByOrderMedicineId(1L);
        CheckStatus c = this.checkStatusRepository.findByCheckStatusId(1L);
        Nurse n = this.nurseRepository.findByNurseId(1L);

        receiveMedicine.setOrderMedicine(o);
        receiveMedicine.setCheckStatus(c);
        receiveMedicine.setNurse(n);
        receiveMedicine.setNoteNew(null);
        try {
            entityManager.persist(receiveMedicine);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 2);
            System.out.println();
            System.out.println("----------> Notnull NoteNew<--------------------");
            System.out.println(e.getMessage());
            System.out.println();
            System.out.println();
        }

    }

    @Test
    public void OrderMedicinenotNull() {
        ReceiveMedicine receiveMedicine = new ReceiveMedicine();

        //OrderMedicine o = this.orderMedicineRepository.findByOrderMedicineId(1L);
        CheckStatus c = this.checkStatusRepository.findByCheckStatusId(1L);
        Nurse n = this.nurseRepository.findByNurseId(1L);

        receiveMedicine.setOrderMedicine(null);
        receiveMedicine.setCheckStatus(c);
        receiveMedicine.setNurse(n);
        receiveMedicine.setNoteNew("มาาาา");
        try {
            entityManager.persist(receiveMedicine);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println();
            System.out.println("----------> Notnull OrderMedicine <--------------------");
            System.out.println(e.getMessage());
            System.out.println();
            System.out.println();
        }

    }

    @Test
    public void CannotNullCheckStatus() {
         ReceiveMedicine receiveMedicine = new ReceiveMedicine();

         OrderMedicine o = this.orderMedicineRepository.findByOrderMedicineId(1L);
        //CheckStatus c = this.checkStatusRepository.findByCheckStatusId(1L);
        Nurse n = this.nurseRepository.findByNurseId(1L);

        receiveMedicine.setOrderMedicine(o);
        receiveMedicine.setCheckStatus(null);
        receiveMedicine.setNurse(n);
        receiveMedicine.setNoteNew("ยาาา");
        try {
            entityManager.persist(receiveMedicine);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 2);
            System.out.println();
            System.out.println("----------> Notnull CheckStatus<--------------------");
            System.out.println(e.getMessage());
            System.out.println();
            System.out.println();
        }

    }

    @Test
    public void CannotNullNurse() {
         ReceiveMedicine receiveMedicine = new ReceiveMedicine();

       OrderMedicine o = this.orderMedicineRepository.findByOrderMedicineId(1L);
        CheckStatus c = this.checkStatusRepository.findByCheckStatusId(1L);
        //Nurse n = this.nurseRepository.findByNurseId(1L);

        receiveMedicine.setOrderMedicine(o);
        receiveMedicine.setCheckStatus(c);
        receiveMedicine.setNurse(null);
        receiveMedicine.setNoteNew("ยาาา");
        try {
            entityManager.persist(receiveMedicine);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 2);
            System.out.println();
            System.out.println("----------> Notnull Nurse<--------------------");
            System.out.println(e.getMessage());
            System.out.println();
            System.out.println();
        }

    }

    @Test
    public void testPatternReceive() {
        ReceiveMedicine receiveMedicine = new ReceiveMedicine();

        OrderMedicine o = this.orderMedicineRepository.findByOrderMedicineId(1L);
        CheckStatus c = this.checkStatusRepository.findByCheckStatusId(1L);
        Nurse n = this.nurseRepository.findByNurseId(1L);

        receiveMedicine.setOrderMedicine(o);
        receiveMedicine.setCheckStatus(c);
        receiveMedicine.setNurse(n);
        receiveMedicine.setNoteNew("กเดเ้าพ่้ีะร่ื");

        try {
            entityManager.persist(receiveMedicine);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println();
            System.out.println("----------> Comment Pattern Receive <--------------------");
            System.out.println(e.getMessage());
            System.out.println();
            System.out.println();
        }
    }
    @Test
    public void testSizeReceive() {
        ReceiveMedicine receiveMedicine = new ReceiveMedicine();

        OrderMedicine o = this.orderMedicineRepository.findByOrderMedicineId(1L);
        CheckStatus c = this.checkStatusRepository.findByCheckStatusId(1L);
        Nurse n = this.nurseRepository.findByNurseId(1L);

        receiveMedicine.setOrderMedicine(o);
        receiveMedicine.setCheckStatus(c);
        receiveMedicine.setNurse(n);
        receiveMedicine.setNoteNew("มาาาาาาาาาาาาาาาาาาาาาาาาาาาาาาาาาาาาาาาาาาาาาาาาาาาาาาาาาาาาาาา");

        try {
            entityManager.persist(receiveMedicine);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 2);
            System.out.println();
            System.out.println("----------> Comment Sizelong Receive<--------------------");
            System.out.println(e.getMessage());
            System.out.println();
            System.out.println();
        }
    }
}
