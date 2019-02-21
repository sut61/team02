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
	private PetInfoRepository petInfoRepository;
	@Autowired
	private DoctorRepository doctorRepository;
	@Autowired
	private NurseRepository nurseRepository;
	@Autowired
	private PeriodRepository periodRepository;
	@Autowired
	private OwnerRepository ownerRepository;

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
	public void testSprint1_NotNull_Owner() {
		Appointment s = new Appointment();
		Owner o = this.ownerRepository.findByOwnerId(1L);
		PetInfo p = this.petInfoRepository.findByPetId(1L);
		Doctor d = this.doctorRepository.findByDoctorId(1L);
		Period pe =this.periodRepository.findByPeriodId(1L);
		Nurse n = this.nurseRepository.findByNurseId(1L);

		s.setOwner(null);
		s.setPetInfo(p);
		s.setDoctor(d);
		s.setPeriod(pe);
		s.setNurse(n);
		s.setDate(new Date());
		s.setNote("and00And และ");

		try {
			entityManager.persist(s);
			entityManager.flush();

			fail("Should not pass to this line");
		} catch(javax.validation.ConstraintViolationException e) {
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 2);
			System.out.println();
			System.out.println("--------------- Note Sprint1 NotNull_Owner --------------------");
			System.out.println(e.getMessage());
			System.out.println();
		}

	}
	@Test
	public void testSprint1_NotNull_PetInfo() {
		Appointment s = new Appointment();
		Owner o = this.ownerRepository.findByOwnerId(1L);
		PetInfo p = this.petInfoRepository.findByPetId(1L);
		Doctor d = this.doctorRepository.findByDoctorId(1L);
		Period pe =this.periodRepository.findByPeriodId(1L);
		Nurse n = this.nurseRepository.findByNurseId(1L);

		s.setOwner(o);
		s.setPetInfo(null);
		s.setDoctor(d);
		s.setPeriod(pe);
		s.setNurse(n);
		s.setDate(new Date());
		s.setNote("and00And และ");

		try {
			entityManager.persist(s);
			entityManager.flush();

			fail("Should not pass to this line");
		} catch(javax.validation.ConstraintViolationException e) {
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 2);
			System.out.println();
			System.out.println("--------------- Note Sprint1 NotNull_PetInfo --------------------");
			System.out.println(e.getMessage());
			System.out.println();
		}

	}

	@Test
	public void testSprint1_NotNull_Doctor() {
		Appointment s = new Appointment();
		Owner o = this.ownerRepository.findByOwnerId(1L);
		PetInfo p = this.petInfoRepository.findByPetId(1L);
		Doctor d = this.doctorRepository.findByDoctorId(1L);
		Period pe =this.periodRepository.findByPeriodId(1L);
		Nurse n = this.nurseRepository.findByNurseId(1L);

		s.setOwner(o);
		s.setPetInfo(p);
		s.setDoctor(null);
		s.setPeriod(pe);
		s.setNurse(n);
		s.setDate(new Date());
		s.setNote("and00And และ");

		try {
			entityManager.persist(s);
			entityManager.flush();

			fail("Should not pass to this line");
		} catch(javax.validation.ConstraintViolationException e) {
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 3);
			System.out.println();
			System.out.println("--------------- Note Sprint1 NotNull_Doctor --------------------");
			System.out.println(e.getMessage());
			System.out.println();
		}

	}
	@Test
	public void testSprint1_NotNull_Period() {
		Appointment s = new Appointment();
		Owner o = this.ownerRepository.findByOwnerId(1L);
		PetInfo p = this.petInfoRepository.findByPetId(1L);
		Doctor d = this.doctorRepository.findByDoctorId(1L);
		Period pe =this.periodRepository.findByPeriodId(1L);
		Nurse n = this.nurseRepository.findByNurseId(1L);

		s.setOwner(o);
		s.setPetInfo(p);
		s.setDoctor(d);
		s.setPeriod(null);
		s.setNurse(n);
		s.setDate(new Date());
		s.setNote("and00And และ");

		try {
			entityManager.persist(s);
			entityManager.flush();

			fail("Should not pass to this line");
		} catch(javax.validation.ConstraintViolationException e) {
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 3);
			System.out.println();
			System.out.println("--------------- Note Sprint1 NotNull_Period --------------------");
			System.out.println(e.getMessage());
			System.out.println();
		}

	}
	@Test
	public void testSprint1_NotNull_Nurse() {
		Appointment s = new Appointment();
		Owner o = this.ownerRepository.findByOwnerId(1L);
		PetInfo p = this.petInfoRepository.findByPetId(1L);
		Doctor d = this.doctorRepository.findByDoctorId(1L);
		Period pe =this.periodRepository.findByPeriodId(1L);
		Nurse n = this.nurseRepository.findByNurseId(1L);

		s.setOwner(o);
		s.setPetInfo(p);
		s.setDoctor(d);
		s.setPeriod(pe);
		s.setNurse(null);
		s.setDate(new Date());
		s.setNote("and00And และ");

		try {
			entityManager.persist(s);
			entityManager.flush();

			fail("Should not pass to this line");
		} catch(javax.validation.ConstraintViolationException e) {
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 3);
			System.out.println();
			System.out.println("--------------- Note Sprint1 NotNull_Nurse --------------------");
			System.out.println(e.getMessage());
			System.out.println();
		}
	}
	@Test
	public void testSprint1_NotNull_Date() {
		Appointment s = new Appointment();
		Owner o = this.ownerRepository.findByOwnerId(1L);
		PetInfo p = this.petInfoRepository.findByPetId(1L);
		Doctor d = this.doctorRepository.findByDoctorId(1L);
		Period pe =this.periodRepository.findByPeriodId(1L);
		Nurse n = this.nurseRepository.findByNurseId(1L);

		s.setOwner(o);
		s.setPetInfo(p);
		s.setDoctor(d);
		s.setPeriod(pe);
		s.setNurse(n);
		s.setDate(null);
		s.setNote("and00And และ");

		try {
			entityManager.persist(s);
			entityManager.flush();

			fail("Should not pass to this line");
		} catch(javax.validation.ConstraintViolationException e) {
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 3);
			System.out.println();
			System.out.println("--------------- Note Sprint1 NotNull_Date --------------------");
			System.out.println(e.getMessage());
			System.out.println();
		}

	}
	@Test
	public void testSprint1_NotNull_Note() {
		Appointment s = new Appointment();
		Owner o = this.ownerRepository.findByOwnerId(1L);
		PetInfo p = this.petInfoRepository.findByPetId(1L);
		Doctor d = this.doctorRepository.findByDoctorId(1L);
		Period pe =this.periodRepository.findByPeriodId(1L);
		Nurse n = this.nurseRepository.findByNurseId(1L);

		s.setOwner(o);
		s.setPetInfo(p);
		s.setDoctor(d);
		s.setPeriod(pe);
		s.setNurse(n);
		s.setDate(new Date());
		s.setNote(null);

		try {
			entityManager.persist(s);
			entityManager.flush();

			fail("Should not pass to this line");
		} catch(javax.validation.ConstraintViolationException e) {
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 3);
			System.out.println();
			System.out.println("--------------- Note Sprint1 NotNull_Note --------------------");
			System.out.println(e.getMessage());
			System.out.println();
		}

	}
	//Test OverSize
	@Test
	public void testSprint1_OverSize() {
		Appointment s = new Appointment();
		Owner o = this.ownerRepository.findByOwnerId(1L);
		PetInfo p = this.petInfoRepository.findByPetId(1L);
		Doctor d = this.doctorRepository.findByDoctorId(1L);
		Period pe =this.periodRepository.findByPeriodId(1L);
		Nurse n = this.nurseRepository.findByNurseId(1L);

		s.setOwner(o);
		s.setPetInfo(p);
		s.setDoctor(d);
		s.setPeriod(pe);
		s.setNurse(n);
		s.setDate(new Date());
		s.setNote("1and000AND11and000AND11 and000AND11and000AND1");

		try {
			entityManager.persist(s);
			entityManager.flush();

			fail("Should not pass to this line");
		} catch(javax.validation.ConstraintViolationException e) {
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 3);
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
		Owner o = this.ownerRepository.findByOwnerId(1L);
		PetInfo p = this.petInfoRepository.findByPetId(1L);
		Doctor d = this.doctorRepository.findByDoctorId(1L);
		Period pe =this.periodRepository.findByPeriodId(1L);
		Nurse n = this.nurseRepository.findByNurseId(1L);

		s.setOwner(o);
		s.setPetInfo(p);
		s.setDoctor(d);
		s.setPeriod(pe);
		s.setNurse(n);
		s.setDate(new Date());
		s.setNote("%%andและ&&");

		try {
			entityManager.persist(s);
			entityManager.flush();

			fail("Should not pass to this line");
		} catch(javax.validation.ConstraintViolationException e) {
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 3);
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
		Owner o = this.ownerRepository.findByOwnerId(1L);
		PetInfo p = this.petInfoRepository.findByPetId(1L);
		Doctor d = this.doctorRepository.findByDoctorId(1L);
		Period pe =this.periodRepository.findByPeriodId(1L);
		Nurse n = this.nurseRepository.findByNurseId(1L);

		s.setOwner(o);
		s.setPetInfo(p);
		s.setDoctor(d);
		s.setPeriod(pe);
		s.setNurse(n);
		s.setDate(new Date());
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
			assertEquals(violations.size(), 2);

		}
	}

}

