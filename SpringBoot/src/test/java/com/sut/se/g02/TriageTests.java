//package com.sut.sa.cpe;
package com.sut.se.g02.cpe;

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
import com.sut.se.g02.entity.*;
import com.sut.se.g02.repository.*;

@RunWith(SpringRunner.class)
@DataJpaTest
//@SpringBootTest
public class TriageTests {


	@Autowired
	private TriageRepository triageRepository;


	@Autowired
    private PetInfoRepository petInfoRepository;
    @Autowired
    private NurseRepository nurseRepository;
    @Autowired
    private TriageLevelRepository triageLevelRepository;

	@Autowired
	private TestEntityManager entityManager;

	private Validator validator;

	
	@Before
	public void setup(){

		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
	}


	
	/* ----------------------------------------  Sprint 2 ------------------------------------- */
	@Test
	public void triageSaveAll(){
		Triage t = new Triage();
		Nurse n = this.nurseRepository.findByNurseId(1L);
    	PetInfo  p = this.petInfoRepository.findByPetId(1L);
        TriageLevel  level = this.triageLevelRepository.findByLevelId(1L);
		t.setNurse(n);
		t.setPetInfo(p);
		t.setTriageLevel(level);
		t.setSymptom("ไข้ขึ้นสูง");
		

		try{
			entityManager.persist(t);
			entityManager.flush();
            System.out.println();
			System.out.println("------------------------ Check TriageSaveAll --------------------------");
			//System.out.println(e.getMessage());
			System.out.println("------------------------------------------------------------------------");
			System.out.println();

			//fail("Should noy pass to this line");

		}catch(javax.validation.ConstraintViolationException e){
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
			
		}
	}

	@Test
	public void NotNullNurse(){
		Triage t = new Triage();
    	PetInfo  p = this.petInfoRepository.findByPetId(1L);
        TriageLevel  level = this.triageLevelRepository.findByLevelId(1L);
		t.setNurse(null);
		t.setPetInfo(p);
		t.setTriageLevel(level);
		t.setSymptom("ไข้ขึ้นสูง ชักเกรง");

		try{
			entityManager.persist(t);
			entityManager.flush();

			fail("Should noy pass to this line");

		}catch(javax.validation.ConstraintViolationException e){
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 2);
			System.out.println();
			System.out.println("------------------------ Check NotNull Nurse--------------------------");
			System.out.println(e.getMessage());
			System.out.println("------------------------------------------------------------------------");
			System.out.println();
		}
	}

	@Test
	public void NotNullPetInfo(){
		Triage t = new Triage();
		Nurse n = this.nurseRepository.findByNurseId(1L);
        TriageLevel  level = this.triageLevelRepository.findByLevelId(1L);
		t.setNurse(n);
		t.setPetInfo(null);
		t.setTriageLevel(level);
		t.setSymptom("ไข้ขึ้นสูง ชักเกรง");

		try{
			entityManager.persist(t);
			entityManager.flush();

			fail("Should noy pass to this line");

		}catch(javax.validation.ConstraintViolationException e){
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
			System.out.println();
			System.out.println("------------------------ Check NotNull PetInfo --------------------------");
			System.out.println(e.getMessage());
			System.out.println("------------------------------------------------------------------------");
			System.out.println();
		}
	}

	@Test
	public void NotNullTriageLevel(){
		Triage t = new Triage();
		Nurse n = this.nurseRepository.findByNurseId(1L);
    	PetInfo  p = this.petInfoRepository.findByPetId(1L);
        
		t.setNurse(n);
		t.setPetInfo(p);
		t.setTriageLevel(null);
		t.setSymptom("ไข้ขึ้นสูง ชักเกรง");

		try{
			entityManager.persist(t);
			entityManager.flush();

			fail("Should noy pass to this line");

		}catch(javax.validation.ConstraintViolationException e){
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 2);
			System.out.println();
			System.out.println("------------------------ Check NotNull TriageLevel--------------------------");
			System.out.println(e.getMessage());
			System.out.println("------------------------------------------------------------------------");
			System.out.println();
		}
	}

	@Test
	public void triageSymptomNotNull(){
		Triage t = new Triage();
		Nurse n = this.nurseRepository.findByNurseId(1L);
    	PetInfo  p = this.petInfoRepository.findByPetId(1L);
        TriageLevel  level = this.triageLevelRepository.findByLevelId(1L);
		t.setNurse(n);
		t.setPetInfo(p);
		t.setTriageLevel(level);
		t.setSymptom(null);

		try{
			entityManager.persist(t);
			entityManager.flush();

			fail("Should noy pass to this line");

		}catch(javax.validation.ConstraintViolationException e){
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 2);
			System.out.println();
			System.out.println("------------------------ Check triageSymptomNotNull --------------------------");
			System.out.println(e.getMessage());
			System.out.println("------------------------------------------------------------------------");
			System.out.println();
		}
	}
	
	@Test
	public void triageSymptomLongSize(){
		Triage t = new Triage();
		Nurse n = this.nurseRepository.findByNurseId(1L);
    	PetInfo  p = this.petInfoRepository.findByPetId(1L);
        TriageLevel  level = this.triageLevelRepository.findByLevelId(1L);
		t.setNurse(n);
		t.setPetInfo(p);
		t.setTriageLevel(level);
		t.setSymptom("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaatttttttttt");

		

		try{
			entityManager.persist(t);
			entityManager.flush();

			fail("Should noy pass to this line");

		}catch(javax.validation.ConstraintViolationException e){
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 2);
			System.out.println();
			System.out.println("------------------------ Check triageSymptomLongSize ------------------------");
			System.out.println(e.getMessage());
			System.out.println("-------------------------------------------------------------------");
			System.out.println();
		}
	}

	
	@Test
	public void triageSymptomPattern(){
		Triage t = new Triage();
		Nurse n = this.nurseRepository.findByNurseId(1L);
    	PetInfo  p = this.petInfoRepository.findByPetId(1L);
        TriageLevel  level = this.triageLevelRepository.findByLevelId(1L);
		t.setNurse(n);
		t.setPetInfo(p);
		t.setTriageLevel(level);
		t.setSymptom("#######################");

		

		try{
			entityManager.persist(t);
			entityManager.flush();

			fail("Should noy pass to this line");

		}catch(javax.validation.ConstraintViolationException e){
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 2);
			System.out.println();
			System.out.println("------------------------ Check triageSymptomไม่ตรงPattern ------------------------");
			System.out.println(e.getMessage());
			System.out.println("----------------------------------------------------------------------");
			System.out.println();
		}
	}


}
