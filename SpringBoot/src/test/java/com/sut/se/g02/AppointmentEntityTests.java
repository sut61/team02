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
public class AppointmentEntityTests {

	@Autowired
	private AppointmentRepository appointmentRepository;

	@Autowired
	private TestEntityManager entityManager;

	private Validator validator;

	@Before
	public void setup() {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}

	//---------------------------------- Test Sprint1------------------------------------------------------
	//Test Not Null
	@Test
	public void testSprint1_NotNull() {
		Appointment s = new Appointment();
		s.setNote(null);

		try {
			entityManager.persist(s);
			entityManager.flush();

			fail("Should not pass to this line");
		} catch(javax.validation.ConstraintViolationException e) {
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 2);
			System.out.println();
			System.out.println("--------------- Note Sprint1 Not Null --------------------");
			System.out.println(e.getMessage());
			System.out.println();
		}

	}
	//Test OverSize
	@Test
	public void testSprint1_OverSize() {
		Appointment s = new Appointment();
		s.setNote("1and000AND11and000AND11 and000AND11and000AND1");

		try {
			entityManager.persist(s);
			entityManager.flush();

			fail("Should not pass to this line");
		} catch(javax.validation.ConstraintViolationException e) {
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 2);
			System.out.println();
			System.out.println("--------------- Note Sprint1 Over Size --------------------");
			System.out.println(e.getMessage());
			System.out.println();
		}
	}
	//Test Patten
	@Test
	public void testSprint1_Patten() {
		Appointment s = new Appointment();
		s.setNote("%%andและ&&");

		try {
			entityManager.persist(s);
			entityManager.flush();

			fail("Should not pass to this line");
		} catch(javax.validation.ConstraintViolationException e) {
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 2);
			System.out.println();
			System.out.println("--------------- Note Sprint1 Patten --------------------");
			System.out.println(e.getMessage());
			System.out.println();
		}
	}
	//Test SaveAll
	@Test
	public void testSprint1_SaveAll() {
		Appointment s = new Appointment();
		s.setNote("and00And และ");

		try {
			entityManager.persist(s);
			entityManager.flush();
			System.out.println();
			System.out.println("--------------- Note Sprint1 SaveAll --------------------");
			System.out.println();
			//fail("Should not pass to this line");
		} catch(javax.validation.ConstraintViolationException e) {
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);

		}
	}

}

