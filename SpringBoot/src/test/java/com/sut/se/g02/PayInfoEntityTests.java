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

import org.junit.*;
import org.junit.Before;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.sql.Timestamp;
import javax.persistence.*;

import com.sut.se.g02.repository.*;
import com.sut.se.g02.entity.*;

@RunWith(SpringRunner.class)
@DataJpaTest
public class PayInfoEntityTests {

    
    @Autowired
    private PayInfoRepository payInfoRepository;

    @Autowired
    private OwnerRepository ownerRepository;
    @Autowired
    private TreatmentRepository treatmentRepository;
    @Autowired
    private MedicineRepository medicineRepository;
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


    // ทดสอบ PayInfo ความยาวเกิน
    @Test
    public void testSizeOver() {
        PayInfo payInfo = new PayInfo();
        Owner o = this.ownerRepository.findByOwnerId(1L);
        Treatment t = this.treatmentRepository.findByTreatmentId(1L);
        Medicine m = this.medicineRepository.findByMedicineId(1L);
        Nurse n = this.nurseRepository.findByNurseId(1L);
        payInfo.setOwner(o);
        payInfo.setTreatment(t);
        payInfo.setMedicine(m);
        payInfo.setNurse(n);
        payInfo.setDateandtime(new Timestamp(System.currentTimeMillis()));
        payInfo.setNote("-ยังไม่พร้อมจ่ายจ้าxxxxxxxxxxxxxxxx");
        try {
            entityManager.persist(payInfo);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 3);
            System.out.println();
            System.out.println("----------> Note ความยาวเกิน<--------------------");
            System.out.println(e.getMessage());
            System.out.println();
            System.out.println();
        }
    }

    // ทดสอบห้าม PayInfo เป็น notnullOwner
    @Test
    public void testNotNullOwner() {
        PayInfo payInfo = new PayInfo();
        
        Treatment t = this.treatmentRepository.findByTreatmentId(1L);
        Medicine m = this.medicineRepository.findByMedicineId(1L);
        Nurse n = this.nurseRepository.findByNurseId(1L);

        payInfo.setOwner(null);
        payInfo.setTreatment(t);
        payInfo.setMedicine(m);
        payInfo.setNurse(n);
        payInfo.setDateandtime(new Timestamp(System.currentTimeMillis()));
        payInfo.setNote("1234");
        try {
            entityManager.persist(payInfo);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 2);
            System.out.println();
            System.out.println("----------> Note notnull   Owner<--------------------");
            System.out.println(e.getMessage());
            System.out.println();
            System.out.println();
        }
    }

    // ทดสอบห้าม PayInfo เป็น notnullTreatment
    @Test
    public void testNotNullTreatment() {
        PayInfo payInfo = new PayInfo();
        Owner o = this.ownerRepository.findByOwnerId(1L);
       
        Medicine m = this.medicineRepository.findByMedicineId(1L);
        Nurse n = this.nurseRepository.findByNurseId(1L);
        payInfo.setOwner(o);
       
        payInfo.setTreatment(null);
        payInfo.setMedicine(m);
        payInfo.setNurse(n);
        payInfo.setDateandtime(new Timestamp(System.currentTimeMillis()));
        payInfo.setNote("1234");
        try {
            entityManager.persist(payInfo);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 2);
            System.out.println();
            System.out.println("----------> Note notnull   Treatment<--------------------");
            System.out.println(e.getMessage());
            System.out.println();
            System.out.println();
        }
    }

    // ทดสอบห้าม PayInfo เป็น notnullMedicine
    @Test
    public void testNotNullMedicine() {
        PayInfo payInfo = new PayInfo();
        Owner o = this.ownerRepository.findByOwnerId(1L);
        Treatment t = this.treatmentRepository.findByTreatmentId(1L);
        
        Nurse n = this.nurseRepository.findByNurseId(1L);
        payInfo.setOwner(o);
        payInfo.setTreatment(t);

        payInfo.setMedicine(null);
        payInfo.setNurse(n);
        payInfo.setDateandtime(new Timestamp(System.currentTimeMillis()));
        payInfo.setNote("1234");
        try {
            entityManager.persist(payInfo);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 3);
            System.out.println();
            System.out.println("----------> Note notnull   Medicine<--------------------");
            System.out.println(e.getMessage());
            System.out.println();
            System.out.println();
        }
    }

    // ทดสอบห้าม PayInfo เป็น notnullNurse
    @Test
    public void testNotNullNurse() {
        PayInfo payInfo = new PayInfo();
        Owner o = this.ownerRepository.findByOwnerId(1L);
        Treatment t = this.treatmentRepository.findByTreatmentId(1L);
        Medicine m = this.medicineRepository.findByMedicineId(1L);
        
        payInfo.setOwner(o);
        payInfo.setTreatment(t);
        payInfo.setMedicine(m);

        payInfo.setNurse(null);
        payInfo.setDateandtime(new Timestamp(System.currentTimeMillis()));
        payInfo.setNote("1234");
        try {
            entityManager.persist(payInfo);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 3);
            System.out.println();
            System.out.println("----------> Note notnull  Nurse<--------------------");
            System.out.println(e.getMessage());
            System.out.println();
            System.out.println();
        }
    }


    // ทดสอบห้าม PayInfo เป็น notnull Note
    @Test
    public void testNotNullNote() {
        PayInfo payInfo = new PayInfo();
        Owner o = this.ownerRepository.findByOwnerId(1L);
        Treatment t = this.treatmentRepository.findByTreatmentId(1L);
        Medicine m = this.medicineRepository.findByMedicineId(1L);
        Nurse n = this.nurseRepository.findByNurseId(1L);
        payInfo.setOwner(o);
        payInfo.setTreatment(t);
        payInfo.setMedicine(m);
        payInfo.setNurse(n);
        payInfo.setDateandtime(new Timestamp(System.currentTimeMillis()));
        payInfo.setNote(null);
        try {
            entityManager.persist(payInfo);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 3);
            System.out.println();
            System.out.println("----------> Note notnull<--------------------");
            System.out.println(e.getMessage());
            System.out.println();
            System.out.println();
        }
    }



    // ทดสอบ PayInfo ไม่ตรง Pattern
    @Test
    public void testNotPattern() {
        PayInfo payInfo = new PayInfo();
        Owner o = this.ownerRepository.findByOwnerId(1L);
        Treatment t = this.treatmentRepository.findByTreatmentId(1L);
        Medicine m = this.medicineRepository.findByMedicineId(1L);
        Nurse n = this.nurseRepository.findByNurseId(1L);
        payInfo.setOwner(o);
        payInfo.setTreatment(t);
        payInfo.setMedicine(m);
        payInfo.setNurse(n);
        payInfo.setDateandtime(new Timestamp(System.currentTimeMillis()));
        payInfo.setNote("**");
        try {
            entityManager.persist(payInfo);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 3);
            System.out.println();
            System.out.println("----------> Note ไม่ตรง Pattern<--------------------");
            System.out.println(e.getMessage());
            System.out.println();
            System.out.println();
        }
    }

    // ทดสอบ save PayInfo ปกติ
    @Test
    public void testSaveAll() {
        PayInfo payInfo = new PayInfo();
        Owner o = this.ownerRepository.findByOwnerId(1L);
        Treatment t = this.treatmentRepository.findByTreatmentId(1L);
        Medicine m = this.medicineRepository.findByMedicineId(1L);
        Nurse n = this.nurseRepository.findByNurseId(1L);
        payInfo.setOwner(o);
        payInfo.setTreatment(t);
        payInfo.setMedicine(m);
        payInfo.setNurse(n);
        payInfo.setDateandtime(new Timestamp(System.currentTimeMillis()));
        payInfo.setNote("--");
        try {
            entityManager.persist(payInfo);
            entityManager.flush();
            System.out.println();
            System.out.println();
            System.out.println("----------> บันทึก ปกติ<--------------------");
            System.out.println();
            System.out.println();
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 2);
            
        }
        
    }

}
