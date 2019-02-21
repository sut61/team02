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

public class TreatmentTests {

	@Autowired
	private TreatmentRepository treatmentRepository;

	@Autowired
	private TestEntityManager entityManager;

	private Validator validator;

	
	@Before
	public void setup(){

		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
	}


	/* ----------------------------------------  Sprint 1 ------------------------------------- */	
	@Test
	public void treatmentSaveAll(){
		Treatment treat = new Treatment();
		treat.setDate(new Timestamp(System.currentTimeMillis()));
		treat.setSymptom("ไข้หวัดH1N1");
		treat.setDCon(0);

		try{
			entityManager.persist(treat);
			entityManager.flush();
            System.out.println();
			System.out.println("------------------------ Check treatmentSaveAll --------------------------");
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
	public void treatmentพักฟื้นNotNull(){
		Treatment treat = new Treatment();
		treat.setDate(new Timestamp(System.currentTimeMillis()));
		treat.setSymptom("ไข้หวัดH1N1");
		treat.setDCon(null);

		try{
			entityManager.persist(treat);
			entityManager.flush();

			fail("Should noy pass to this line");

		}catch(javax.validation.ConstraintViolationException e){
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
			System.out.println();
			System.out.println("------------------------ Check treatmentพักฟื้นNotNull --------------------------");
			System.out.println(e.getMessage());
			System.out.println("------------------------------------------------------------------------");
			System.out.println();
		}
	}
	

	@Test
	public void treatmentSymptomNotNull(){
		Treatment treat = new Treatment();
		treat.setDate(new Timestamp(System.currentTimeMillis()));
		treat.setSymptom(null);
		treat.setDCon(0);

		try{
			entityManager.persist(treat);
			entityManager.flush();

			fail("Should noy pass to this line");

		}catch(javax.validation.ConstraintViolationException e){
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
			System.out.println();
			System.out.println("------------------------ Check treatmentSymptomNotNull --------------------------");
			System.out.println(e.getMessage());
			System.out.println("------------------------------------------------------------------------");
			System.out.println();
		}
	}
	
	@Test
	public void triageSymptomLongSize(){
		Treatment treat = new Treatment();
		
		treat.setDate(new Timestamp(System.currentTimeMillis()));
		treat.setSymptom("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
		treat.setDCon(0);

		

		try{
			entityManager.persist(treat);
			entityManager.flush();

			fail("Should noy pass to this line");

		}catch(javax.validation.ConstraintViolationException e){
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
			System.out.println();
			System.out.println("------------------------ Check treatmentSymptomLongSize ------------------------");
			System.out.println(e.getMessage());
			System.out.println("-------------------------------------------------------------------");
			System.out.println();
		}
	}

	
	@Test
	public void triageSymptomPattern(){
		Treatment treat = new Treatment();
		
		treat.setDate(new Timestamp(System.currentTimeMillis()));
		treat.setSymptom("#######################");
		treat.setDCon(0);

		

		try{
			entityManager.persist(treat);
			entityManager.flush();

			fail("Should noy pass to this line");

		}catch(javax.validation.ConstraintViolationException e){
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
			System.out.println();
			System.out.println("------------------------ Check treatmentSymptomไม่ตรงPattern ------------------------");
			System.out.println(e.getMessage());
			System.out.println("----------------------------------------------------------------------");
			System.out.println();
		}
	}




}
