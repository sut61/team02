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
public class OwnerEntityTests {


    @Autowired
    private ServeRepository serveRepository;
    @Autowired
    private OwnerRepository ownerRepository;
    @Autowired
    private PetInfoRepository petInfoRepository;


    @Autowired
    private TestEntityManager entityManager;

    private Validator validator;

    @Before
    public void setup() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }


    @Test
    public void FinishOwner() {
        Owner owner = new Owner();
        owner.setOwnerName("วชริ ขวัญใจ");
        owner.setOwnerTel("0988787780");

        try {
            entityManager.persist(owner);
            entityManager.flush();
            //fail("Should not pass to this line");
            System.out.println();
            System.out.println("----------> Finish  Compile Owner<--------------------");
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
    public void CannotNullOwnerName() {
        Owner owner = new Owner();
        owner.setOwnerName(null);
        owner.setOwnerTel("0988787780");


        try {
            entityManager.persist(owner);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println();
            System.out.println("----------> Notnull  OwnerName<--------------------");
            System.out.println(e.getMessage());
            System.out.println();
            System.out.println();
        }

    }
    @Test
    public void CannotNullOwnerTel() {
        Owner owner = new Owner();
        owner.setOwnerName("วชิระ  ขวัญใจ");
        owner.setOwnerTel(null);


        try {
            entityManager.persist(owner);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println();
            System.out.println("----------> Notnull OwnerTel<--------------------");
            System.out.println(e.getMessage());
            System.out.println();
            System.out.println();
        }

    }
    @Test
    public void testPatternOwnerName() {
        Owner owner = new Owner();
        owner.setOwnerName("Wachira");
        owner.setOwnerTel("0988787780");

        try {
            entityManager.persist(owner);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println();
            System.out.println("----------> Comment Pattern Owner Name<--------------------");
            System.out.println(e.getMessage());
            System.out.println();
            System.out.println();
        }
    }
    @Test
    public void testPatternOwnerTel() {
        Owner owner = new Owner();
        owner.setOwnerName("วชิระ ขวัญใจ");
        owner.setOwnerTel("DD");

        try {
            entityManager.persist(owner);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println();
            System.out.println("----------> Comment Pattern Owner Tel<--------------------");
            System.out.println(e.getMessage());
            System.out.println();
            System.out.println();
        }
    }
    @Test
    public void testSizeOwnerName() {
        Owner owner = new Owner();
        owner.setOwnerName("วชิระ ขวัญใจจจจจจจจจจจจจจจจจจจจจจจจจจจจจจจจจจจจจจจจจจจจจจจจจจจจจจจจจจจจจจจจจจ");
        owner.setOwnerTel("0988787780");

        try {
            entityManager.persist(owner);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println();
            System.out.println("----------> Comment Sizelong OwnerName<--------------------");
            System.out.println(e.getMessage());
            System.out.println();
            System.out.println();
        }
    }
    @Test
    public void testSizeOwnerTel() {
        Owner owner = new Owner();
        owner.setOwnerName("วชิระ ขวัญใจ");
        owner.setOwnerTel("09887877800000000");

        try {
            entityManager.persist(owner);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println();
            System.out.println("----------> Comment Sizelong OwnerTel<--------------------");
            System.out.println(e.getMessage());
            System.out.println();
            System.out.println();
        }
    }

}










