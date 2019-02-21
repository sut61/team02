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
public class PetInfoEntityTests {


    @Autowired
    private ServeRepository serveRepository;
    @Autowired
    private OwnerRepository ownerRepository;
    @Autowired
    private PetInfoRepository petInfoRepository;
    @Autowired
    private NurseRepository nurseRepository;
    @Autowired
    private BreedRepository breedRepository;


    @Autowired
    private TestEntityManager entityManager;

    private Validator validator;

    @Before
    public void setup() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    public void FinishPetInfo() {
        PetInfo petInfo = new PetInfo();
        Breed b = this.breedRepository.findByBreedId(1L);
        Owner o = this.ownerRepository.findByOwnerId(1L);
        Nurse n = this.nurseRepository.findByNurseId(1L);
        petInfo.setOwner(o);
        petInfo.setBreed(b);
        petInfo.setNurse(n);
        petInfo.setPetName("pupu");
        petInfo.setWeight(123.0);
        petInfo.setHeight(123.0);
        petInfo.setAge(12);

        try {
            entityManager.persist(petInfo);
            entityManager.flush();
            //fail("Should not pass to this line");
            System.out.println();
            System.out.println("----------> Finish  Compile PetInfo<--------------------");
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
    public void CannotNullPetInfoName() {
        PetInfo petInfo = new PetInfo();
        Breed b = this.breedRepository.findByBreedId(1L);
        Owner o = this.ownerRepository.findByOwnerId(1L);
        Nurse n = this.nurseRepository.findByNurseId(1L);
        petInfo.setOwner(o);
        petInfo.setBreed(b);
        petInfo.setNurse(n);
        petInfo.setPetName(null);
        petInfo.setWeight(123.0);
        petInfo.setHeight(123.0);
        petInfo.setAge(12);

        try {
            entityManager.persist(petInfo);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 2);
            System.out.println();
            System.out.println("----------> Notnull Name PetInfo<--------------------");
            System.out.println(e.getMessage());
            System.out.println();
            System.out.println();
        }
    }
    @Test
    public void CannotNullPetInfoWeight() {
        PetInfo petInfo = new PetInfo();
        Breed b = this.breedRepository.findByBreedId(1L);
        Owner o = this.ownerRepository.findByOwnerId(1L);
        Nurse n = this.nurseRepository.findByNurseId(1L);
        petInfo.setOwner(o);
        petInfo.setBreed(b);
        petInfo.setNurse(n);
        petInfo.setPetName("pupu");
        petInfo.setWeight(null);
        petInfo.setHeight(123.0);
        petInfo.setAge(12);

        try {
            entityManager.persist(petInfo);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 2);
            System.out.println();
            System.out.println("----------> Notnull Weight PetInfo<--------------------");
            System.out.println(e.getMessage());
            System.out.println();
            System.out.println();
        }
    }
    @Test
    public void CannotNullPetInfoHeight() {
        PetInfo petInfo = new PetInfo();
        Breed b = this.breedRepository.findByBreedId(1L);
        Owner o = this.ownerRepository.findByOwnerId(1L);
        Nurse n = this.nurseRepository.findByNurseId(1L);
        petInfo.setOwner(o);
        petInfo.setBreed(b);
        petInfo.setNurse(n);
        petInfo.setPetName("pupu");
        petInfo.setWeight(123.0);
        petInfo.setHeight(null);
        petInfo.setAge(12);

        try {
            entityManager.persist(petInfo);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 2);
            System.out.println();
            System.out.println("----------> Notnull Height PetInfo<--------------------");
            System.out.println(e.getMessage());
            System.out.println();
            System.out.println();
        }
    }
    @Test
    public void CannotNullPetInfoAge() {
        PetInfo petInfo = new PetInfo();
        Breed b = this.breedRepository.findByBreedId(1L);
        Owner o = this.ownerRepository.findByOwnerId(1L);
        Nurse n = this.nurseRepository.findByNurseId(1L);
        petInfo.setOwner(o);
        petInfo.setBreed(b);
        petInfo.setNurse(n);
        petInfo.setPetName("pupu");
        petInfo.setWeight(123.0);
        petInfo.setHeight(123.0);
        petInfo.setAge(null);

        try {
            entityManager.persist(petInfo);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 2);
            System.out.println();
            System.out.println("----------> Notnull Age PetInfo<--------------------");
            System.out.println(e.getMessage());
            System.out.println();
            System.out.println();
        }
    }
    @Test
    public void testSizePetInfoName() {
        PetInfo petInfo = new PetInfo();
        Breed b = this.breedRepository.findByBreedId(1L);
        Owner o = this.ownerRepository.findByOwnerId(1L);
        Nurse n = this.nurseRepository.findByNurseId(1L);
        petInfo.setOwner(o);
        petInfo.setBreed(b);
        petInfo.setNurse(n);
        petInfo.setPetName("pupuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuu");
        petInfo.setWeight(123.0);
        petInfo.setHeight(123.0);
        petInfo.setAge(12);

        try {
            entityManager.persist(petInfo);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 2);
            System.out.println();
            System.out.println("----------> Comment Sizelong PetInfoName<--------------------");
            System.out.println(e.getMessage());
            System.out.println();
            System.out.println();
        }
    }
    @Test
    public void testPatternePetInfoName() {
        PetInfo petInfo = new PetInfo();
        Breed b = this.breedRepository.findByBreedId(1L);
        Owner o = this.ownerRepository.findByOwnerId(1L);
        Nurse n = this.nurseRepository.findByNurseId(1L);
        petInfo.setOwner(o);
        petInfo.setBreed(b);
        petInfo.setNurse(n);
        petInfo.setPetName("1234");
        petInfo.setWeight(123.0);
        petInfo.setHeight(123.0);
        petInfo.setAge(12);

        try {
            entityManager.persist(petInfo);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 2);
            System.out.println();
            System.out.println("----------> Comment Pattern PetInfoName <--------------------");
            System.out.println(e.getMessage());
            System.out.println();
            System.out.println();
        }
    }
    @Test
    public void nullNurse() {
        PetInfo petInfo = new PetInfo();
        Breed b = this.breedRepository.findByBreedId(1L);
        Owner o = this.ownerRepository.findByOwnerId(1L);
        petInfo.setPetName("pupu");
        petInfo.setWeight(123.0);
        petInfo.setHeight(123.0);
        petInfo.setAge(12);
        petInfo.setOwner(o);
        petInfo.setBreed(b);
        petInfo.setNurse(null);

        try {
            entityManager.persist(petInfo);
            entityManager.flush();
            //fail("Should not pass to this line");

        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 2);
            System.out.println();
            System.out.println();
            System.out.println("----------> fail nullNurse PetInfo<--------------------");
            System.out.println();
            System.out.println();

        }

    }
    @Test
    public void nullBreed() {
        PetInfo petInfo = new PetInfo();
        Nurse n = this.nurseRepository.findByNurseId(1L);
        Owner o = this.ownerRepository.findByOwnerId(1L);
        petInfo.setPetName("pupu");
        petInfo.setWeight(123.0);
        petInfo.setHeight(123.0);
        petInfo.setAge(12);
        petInfo.setOwner(o);
        petInfo.setNurse(n);
        petInfo.setBreed(null);

        try {
            entityManager.persist(petInfo);
            entityManager.flush();
            //fail("Should not pass to this line");

        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 2);
            System.out.println();
            System.out.println();
            System.out.println("----------> fail nullBreed PetInfo<--------------------");
            System.out.println();
            System.out.println();

        }

    }









}