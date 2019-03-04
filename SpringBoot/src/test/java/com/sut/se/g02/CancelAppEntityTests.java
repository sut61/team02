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
public class CancelAppEntityTests {

	@Autowired
	private CancelAppRepository cancelAppRepository;
	@Autowired
	private AppointmentRepository appointmentRepository;
	@Autowired
	private NurseRepository nurseRepository;
	@Autowired
	private Status1Repository status1Repository;

	@Autowired
	private TestEntityManager entityManager;

	private Validator validator;

	@Before
	public void setup() {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}


	//---------------------------------- Test Sprint2------------------------------------------------------
	//Test Not Null
	@Test
	public void testSprint2_NotNull_Note() {
		CancelApp c = new CancelApp();
		Appointment a = this.appointmentRepository.findByAppointmentId(1L);
		Status1 s = this.status1Repository.findByStatusId(1L);
		Nurse n = this.nurseRepository.findByNurseId(1L);
		c.setAppointment(a);
		c.setStatus1(s);
		c.setNurse(n);
		c.setNote(null);

		try {
			entityManager.persist(c);
			entityManager.flush();

			fail("Should not pass to this line");
		} catch(javax.validation.ConstraintViolationException e) {
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
			System.out.println();
			System.out.println("--------------- Note Sprint2 NotNull_Note --------------------");
			System.out.println(e.getMessage());
			System.out.println();
		}
	}
	@Test
	public void testSprint2_NotNull_App() {
		CancelApp c = new CancelApp();
		Appointment a = this.appointmentRepository.findByAppointmentId(1L);
		Status1 s = this.status1Repository.findByStatusId(1L);
		Nurse n = this.nurseRepository.findByNurseId(1L);
		c.setAppointment(null);
		c.setStatus1(s);
		c.setNurse(n);
		c.setNote("00Soon พา00");

		try {
			entityManager.persist(c);
			entityManager.flush();

			fail("Should not pass to this line");
		} catch(javax.validation.ConstraintViolationException e) {
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
			System.out.println();
			System.out.println("--------------- Note Sprint2 NotNull_App --------------------");
			System.out.println(e.getMessage());
			System.out.println();
		}
	}
	@Test
	public void testSprint2_NotNull_Status() {
		CancelApp c = new CancelApp();
		Appointment a = this.appointmentRepository.findByAppointmentId(1L);
		Status1 s = this.status1Repository.findByStatusId(1L);
		Nurse n = this.nurseRepository.findByNurseId(1L);
		c.setAppointment(a);
		c.setStatus1(null);
		c.setNurse(n);
		c.setNote("00Soon พา00");

		try {
			entityManager.persist(c);
			entityManager.flush();

			fail("Should not pass to this line");
		} catch(javax.validation.ConstraintViolationException e) {
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
			System.out.println();
			System.out.println("--------------- Note Sprint2 NotNull_Status --------------------");
			System.out.println(e.getMessage());
			System.out.println();
		}
	}
	@Test
	public void testSprint2_NotNull_Nurse() {
		CancelApp c = new CancelApp();
		Appointment a = this.appointmentRepository.findByAppointmentId(1L);
		Status1 s = this.status1Repository.findByStatusId(1L);
		Nurse n = this.nurseRepository.findByNurseId(1L);
		c.setAppointment(a);
		c.setStatus1(s);
		c.setNurse(null);
		c.setNote("00Soon พา00");

		try {
			entityManager.persist(c);
			entityManager.flush();

			fail("Should not pass to this line");
		} catch(javax.validation.ConstraintViolationException e) {
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
			System.out.println();
			System.out.println("--------------- Note Sprint2 NotNull_Nurse --------------------");
			System.out.println(e.getMessage());
			System.out.println();
		}
	}
	//Test OverSize
	@Test
	public void testSprint2_OverSize() {
		CancelApp c = new CancelApp();
		Appointment a = this.appointmentRepository.findByAppointmentId(1L);
		Status1 s = this.status1Repository.findByStatusId(1L);
		Nurse n = this.nurseRepository.findByNurseId(1L);
		c.setAppointment(a);
		c.setStatus1(s);
		c.setNurse(n);
		c.setNote("00พาSoon00 00พาSoon00 00พาSoon00 00พาSoon00");

		try {
			entityManager.persist(c);
			entityManager.flush();

			fail("Should not pass to this line");
		} catch(javax.validation.ConstraintViolationException e) {
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
			System.out.println();
			System.out.println("--------------- Note Sprint2 Over Size --------------------");
			System.out.println(e.getMessage());
			System.out.println();
		}
	}
	//Test Patten
	@Test
	public void testSprint2_Patten() {
		CancelApp c = new CancelApp();
		Appointment a = this.appointmentRepository.findByAppointmentId(1L);
		Status1 s = this.status1Repository.findByStatusId(1L);
		Nurse n = this.nurseRepository.findByNurseId(1L);
		c.setAppointment(a);
		c.setStatus1(s);
		c.setNurse(n);
		c.setNote("&&Soon&&");

		try {
			entityManager.persist(c);
			entityManager.flush();

			fail("Should not pass to this line");
		} catch(javax.validation.ConstraintViolationException e) {
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
			System.out.println();
			System.out.println("--------------- Note Sprint2 Patten --------------------");
			System.out.println(e.getMessage());
			System.out.println();
		}
	}
	//Test SaveAll
	@Test
	public void testSprint2_SaveAll() {
		CancelApp c = new CancelApp();
		Appointment a = this.appointmentRepository.findByAppointmentId(1L);
		Status1 s = this.status1Repository.findByStatusId(1L);
		Nurse n = this.nurseRepository.findByNurseId(1L);
		c.setAppointment(a);
		c.setStatus1(s);
		c.setNurse(n);
		c.setNote("00Soon พา00");

		try {
			entityManager.persist(c);
			entityManager.flush();
			System.out.println();
			System.out.println("--------------- Note Sprint2 SaveAll --------------------");
			System.out.println();
			//fail("Should not pass to this line");
		} catch(javax.validation.ConstraintViolationException e) {
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);

		}
	}
}

