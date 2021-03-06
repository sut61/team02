package com.sut.se.g02;

import lombok.*;

import org.junit.Test;
import org.junit.runner.RunWith;
//import org.springframework.boot.test.context.SpringBootTest;
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
public class ServeEntityTests {


    @Autowired
    private ServeRepository serveRepository;
    @Autowired
    private OwnerRepository ownerRepository;
    @Autowired
    private PetInfoRepository petInfoRepository;
    @Autowired
    private TestEntityManager entityManager;
    @Autowired
    private NurseRepository nurseRepository;
    @Autowired
    private TypeRepository typeRepository;


    private Validator validator;

    @Before
    public void setup() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }
    @Test
    public void FinishServe() {
        Serve serve = new Serve();
        Owner o = this.ownerRepository.findByOwnerId(1L);
        Nurse n = this.nurseRepository.findByNurseId(1L);
        Type t = this.typeRepository.findByTypeId(1L);
        serve.setOwner(o);
        serve.setType(t);
        serve.setNurse(n);
        serve.setComment("สำเร็จ000-332");


        try {
            entityManager.persist(serve);
            entityManager.flush();
            //fail("Should not pass to this line");
            System.out.println();
            System.out.println("----------> Finish  Compile Serve <--------------------");
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
    public void CannotNullServe() {
        Serve serve = new Serve();
        Owner o = this.ownerRepository.findByOwnerId(1L);
        Nurse n = this.nurseRepository.findByNurseId(1L);
        Type t = this.typeRepository.findByTypeId(1L);
        serve.setOwner(o);
        serve.setType(t);
        serve.setNurse(n);
        serve.setComment(null);


        try {
            entityManager.persist(serve);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println();
            System.out.println("----------> Notnull Comment<--------------------");
            System.out.println(e.getMessage());
            System.out.println();
            System.out.println();
        }

    }

    @Test
    public void testPatternServe() {
        Serve serve = new Serve();
        Owner o = this.ownerRepository.findByOwnerId(1L);
        Nurse n = this.nurseRepository.findByNurseId(1L);
        Type t = this.typeRepository.findByTypeId(1L);
        serve.setOwner(o);
        serve.setType(t);
        serve.setNurse(n);
        serve.setComment("god");

        try {
            entityManager.persist(serve);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println();
            System.out.println("----------> Comment Pattern Serve <--------------------");
            System.out.println(e.getMessage());
            System.out.println();
            System.out.println();
        }
    }



    @Test
    public void testSizeServe() {
        Serve serve = new Serve();
        Owner o = this.ownerRepository.findByOwnerId(1L);
        Nurse n = this.nurseRepository.findByNurseId(1L);
        Type t = this.typeRepository.findByTypeId(1L);
        serve.setOwner(o);
        serve.setType(t);
        serve.setNurse(n);
        serve.setComment("กกกกกกกกกกกกกกกกกกกกกกกกกกกกกกกกกกกกกกกกกกกกกกกกกกกกกกกกกกกกกกกกกกกกกกกกกกกกก");

        try {
            entityManager.persist(serve);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println();
            System.out.println("----------> Comment Sizelong Serve<--------------------");
            System.out.println(e.getMessage());
            System.out.println();
            System.out.println();
        }
    }
    @Test
    public void testServeOwnernull() {
        Serve serve = new Serve();
        //Owner o = this.ownerRepository.findByOwnerId(1L);
        Nurse n = this.nurseRepository.findByNurseId(1L);
        Type t = this.typeRepository.findByTypeId(1L);
        serve.setOwner(null);
        serve.setType(t);
        serve.setNurse(n);
        serve.setComment("เทสจ้า");

        try {
            entityManager.persist(serve);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println();
            System.out.println("----------> Comment testServeOwnernull Serve<--------------------");
            System.out.println(e.getMessage());
            System.out.println();
            System.out.println();
        }
    }

    @Test
    public void testServeNursenull() {
        Serve serve = new Serve();
        Owner o = this.ownerRepository.findByOwnerId(1L);
        //Nurse n = this.nurseRepository.findByNurseId(1L);
        Type t = this.typeRepository.findByTypeId(1L);
        serve.setOwner(o);
        serve.setType(t);
        serve.setNurse(null);
        serve.setComment("เทสจ้า");

        try {
            entityManager.persist(serve);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println();
            System.out.println("----------> Comment testServeNursenull Serve<--------------------");
            System.out.println(e.getMessage());
            System.out.println();
            System.out.println();
        }
    }

    @Test
    public void testServeTypenull() {
        Serve serve = new Serve();
        Owner o = this.ownerRepository.findByOwnerId(1L);
        Nurse n = this.nurseRepository.findByNurseId(1L);
        //Type t = this.typeRepository.findByTypeId(1L);
        serve.setOwner(o);
        serve.setType(null);
        serve.setNurse(n);
        serve.setComment("เทสจ้า");

        try {
            entityManager.persist(serve);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println();
            System.out.println("----------> Comment testServeTypenull Serve<--------------------");
            System.out.println(e.getMessage());
            System.out.println();
            System.out.println();
        }
    }



}










