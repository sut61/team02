package com.sut.se.g02;

import lombok.*;
import com.sut.se.g02.repository.*;
import com.sut.se.g02.entity.*;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.filter.CharacterEncodingFilter;

import java.util.stream.Stream;

@SpringBootApplication
@Data
public class CpeApplication {

    public static void main(String[] args) {
        SpringApplication.run(CpeApplication.class, args);
    }

    @Bean
    CharacterEncodingFilter characterEncodingFilter() {
        CharacterEncodingFilter filter = new CharacterEncodingFilter();
        filter.setEncoding("UTF-8");
        filter.setForceEncoding(true);
        return filter;
    }

    @Bean
    ApplicationRunner init(NurseRepository nurseRepository, DoctorRepository doctorRepository,
                           BreedRepository breedRepository,MedicineRepository medicineRepository,
                           PeriodRepository periodRepository,
                           CageRepository cageRepository,CageTypeRepository cageTypeRepository,
                           CompanyRepository companyRepository) {
        return args ->{

            Nurse nurse = new Nurse();
            Nurse nurse1 = new Nurse();
            nurse.setNameNurse("นางสาวนวรัตน์ แก้วคำลา");
            nurse.setPasswordNurse("B01");
            nurse1.setNameNurse("นางสาวนฌานันท์ ผดุงแดน");
            nurse1.setPasswordNurse("B02");
            nurseRepository.save(nurse);
            nurseRepository.save(nurse1);


            Doctor doctor = new Doctor();
            Doctor doctor1 = new Doctor();
            doctor.setNameDoctor("สพ.ญ.สสิตา วงษ์พยัคฆ์");
            doctor.setPasswordDoctor("D01");
            doctor1.setNameDoctor("สพ.ญ.ปภานัน เสาวิชิต");
            doctor1.setPasswordDoctor("D02");
            doctorRepository.save(doctor);
            doctorRepository.save(doctor1);

            Breed breed = new Breed();
            breed.setBreedName("กระต่าย");
            Breed breed1 = new Breed();
            breed1.setBreedName("สุนัข");
            Breed breed2 = new Breed();
            breed2.setBreedName("แมว");
            Breed breed3 = new Breed();
            breed3.setBreedName("ปลา");
            Breed breed4 = new Breed();
            breed4.setBreedName("อื่นๆ");
            breedRepository.save(breed);
            breedRepository.save(breed1);
            breedRepository.save(breed2);
            breedRepository.save(breed3);
            breedRepository.save(breed4);

            Medicine medicine = new Medicine();
            Medicine medicine1 = new Medicine();
            Medicine medicine2 = new Medicine();
            Medicine medicine3 = new Medicine();
            Medicine medicine4 = new Medicine();

            medicine.setNameMed("ยาพารา");
            medicine.setType("แผง");
            medicine.setAmountMed(9);
            medicine.setPrice(99);

            medicine1.setNameMed("ยาแก้ไอ");
            medicine1.setType("ขวด");
            medicine1.setAmountMed(18);
            medicine1.setPrice(89);

            medicine2.setNameMed("ยาแก้ปวด");
            medicine2.setType("แผง");
            medicine2.setAmountMed(2);
            medicine2.setPrice(5);

            medicine3.setNameMed("ยาแก้ไข้");
            medicine3.setType("ซอง");
            medicine3.setAmountMed(87);
            medicine3.setPrice(95);

            medicine4.setNameMed("ยาลดน้ำมูก");
            medicine4.setType("ขวด");
            medicine4.setAmountMed(11);
            medicine4.setPrice(54);

            medicineRepository.save(medicine);
            medicineRepository.save(medicine1);
            medicineRepository.save(medicine2);
            medicineRepository.save(medicine3);
            medicineRepository.save(medicine4);

            Period period = new Period();
            Period period1 = new Period();
            period.setPeriods("10.00-12.00");
            period1.setPeriods("13.00-15.00");
            periodRepository.save(period);
            periodRepository.save(period1);

             CageType cageType = new CageType();
            CageType cageType1 = new CageType();
            cageType.setNameCageType("A:กรงเดี่ยว");
            cageType1.setNameCageType("B:กรงรวม");
            cageTypeRepository.save(cageType);
            cageTypeRepository.save(cageType1);
             
             
             Cage cage = new Cage();
            Cage cage1 = new Cage();
            Cage cage2 = new Cage();
            Cage cage3 = new Cage();
            Cage cage4 = new Cage();
            cage.setNameCage("A01");
            cage1.setNameCage("A02");
            cage2.setNameCage("A03");
            cage3.setNameCage("B01");
            cage4.setNameCage("B02");
            cageRepository.save(cage);
            cageRepository.save(cage1);
            cageRepository.save(cage2);
            cageRepository.save(cage3);
            cageRepository.save(cage4);


            Company company = new Company();
            Company company1 = new Company();
            Company company2 = new Company();
            Company company3 = new Company();
            company.setNameCompany("บริษัทสยามเภสัช");
            company1.setNameCompany("องค์การเภสัชกรรม");
            company2.setNameCompany("บริษัทเบอร์ลิน ฟาร์มา");
            company3.setNameCompany("บริษัทไบโอฟารม์");
            companyRepository.save(company);
            companyRepository.save(company1);
            companyRepository.save(company2);
            companyRepository.save(company3);
        };
    }

}