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
import org.junit.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.sql.Timestamp;
import javax.persistence.*;

import com.sut.se.g02.repository.*;
import com.sut.se.g02.entity.*;

@RunWith(SpringRunner.class)
@DataJpaTest
public class PayEntityTests {

	
    @Autowired
    private PayRepository payRepository;



    @Autowired
    private PayInfoRepository payInfoRepository;

    @Autowired
    private StatusPayRepository statusPayRepository;

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


 	// ทดสอบ Pay ความยาวเกิน
    @Test
    public void testPaySizeOver() {
        Pay pay = new Pay();
       	PayInfo p = this.payInfoRepository.findByPayInfoId(1L);
        StatusPay s = this.statusPayRepository.findByStatusPayId(1L);
        Nurse n = this.nurseRepository.findByNurseId(1L);
        pay.setPayInfo(p);
        pay.setStatusPay(s);
        pay.setNurse(n);
        pay.setDateandtime(new Timestamp(System.currentTimeMillis()));
        pay.setNote("-ไม่มีเงินจ่ายจะให้ทำยังไงล่ะห่ะ");
        try {
            entityManager.persist(pay);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 2);
            System.out.println();
            System.out.println("----------> Note ความยาวเกิน<--------------------");
            System.out.println(e.getMessage());
            System.out.println();
            System.out.println();
        }
    }

    // ทดสอบห้าม Pay เป็น notnull PayInfo
    @Test
    public void testPayNotNullPayInfo() {
        Pay pay = new Pay();
        
        StatusPay s = this.statusPayRepository.findByStatusPayId(1L);
        Nurse n = this.nurseRepository.findByNurseId(1L);
        pay.setPayInfo(null);
        pay.setStatusPay(s);
        pay.setNurse(n);
        pay.setDateandtime(new Timestamp(System.currentTimeMillis()));
        pay.setNote("have money");
        try {
            entityManager.persist(pay);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println();
            System.out.println("----------> PayInfo notnull<--------------------");
            System.out.println(e.getMessage());
            System.out.println();
            System.out.println();
        }
    }

    // ทดสอบห้าม Pay เป็น notnull StatusPay
    @Test
    public void testPayNotNullStatusPay() {
        Pay pay = new Pay();
        PayInfo p = this.payInfoRepository.findByPayInfoId(1L);
        
        Nurse n = this.nurseRepository.findByNurseId(1L);
        pay.setPayInfo(p);
        pay.setStatusPay(null);
        pay.setNurse(n);
        pay.setDateandtime(new Timestamp(System.currentTimeMillis()));
        pay.setNote("have money");
        try {
            entityManager.persist(pay);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 2);
            System.out.println();
            System.out.println("----------> StatusPay notnull<--------------------");
            System.out.println(e.getMessage());
            System.out.println();
            System.out.println();
        }
    }

    // ทดสอบห้าม Pay เป็น notnull Nurse
    @Test
    public void testPayNotNullNurse() {
        Pay pay = new Pay();
        PayInfo p = this.payInfoRepository.findByPayInfoId(1L);
        StatusPay s = this.statusPayRepository.findByStatusPayId(1L);
    
        pay.setPayInfo(p);
        pay.setStatusPay(s);
        
        pay.setNurse(null);
        pay.setDateandtime(new Timestamp(System.currentTimeMillis()));
        pay.setNote("have money");
        try {
            entityManager.persist(pay);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 2);
            System.out.println();
            System.out.println("----------> Nurse notnull<--------------------");
            System.out.println(e.getMessage());
            System.out.println();
            System.out.println();
        }
    }


    // ทดสอบห้าม Pay เป็น notnull Note
    @Test
    public void testPayNotNullNote() {
        Pay pay = new Pay();
        PayInfo p = this.payInfoRepository.findByPayInfoId(1L);
        StatusPay s = this.statusPayRepository.findByStatusPayId(1L);
        Nurse n = this.nurseRepository.findByNurseId(1L);
        pay.setPayInfo(p);
        pay.setStatusPay(s);
        pay.setNurse(n);
        pay.setDateandtime(new Timestamp(System.currentTimeMillis()));
        pay.setNote(null);
        try {
            entityManager.persist(pay);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 2);
            System.out.println();
            System.out.println("----------> Note notnull<--------------------");
            System.out.println(e.getMessage());
            System.out.println();
            System.out.println();
        }
    }


    // ทดสอบ Pay ไม่ตรง Pattern
    @Test
    public void testPayNotPattern() {
        Pay pay = new Pay();
        PayInfo p = this.payInfoRepository.findByPayInfoId(1L);
        StatusPay s = this.statusPayRepository.findByStatusPayId(1L);
        Nurse n = this.nurseRepository.findByNurseId(1L);
        pay.setPayInfo(p);
        pay.setStatusPay(s);
        pay.setNurse(n);
        pay.setDateandtime(new Timestamp(System.currentTimeMillis()));
        pay.setNote("//");
        try {
            entityManager.persist(pay);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 2);
            System.out.println();
            System.out.println("----------> Note ไม่ตรง Pattern<--------------------");
            System.out.println(e.getMessage());
            System.out.println();
            System.out.println();
        }
    }

    // ทดสอบ save Pay ปกติ
    @Test
    public void testSaveAll() {
        Pay pay = new Pay();
        PayInfo p = this.payInfoRepository.findByPayInfoId(1L);
        StatusPay s = this.statusPayRepository.findByStatusPayId(1L);
        Nurse n = this.nurseRepository.findByNurseId(1L);
        pay.setPayInfo(p);
        pay.setStatusPay(s);
        pay.setNurse(n);
        pay.setDateandtime(new Timestamp(System.currentTimeMillis()));
        pay.setNote("เรียบร้อยแล้ว");
        try {
            entityManager.persist(pay);
            entityManager.flush();
            System.out.println();
            System.out.println();
            System.out.println("----------> บันทึก ปกติ<--------------------");
            System.out.println();
            System.out.println();
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            
        }
        
    }



}
