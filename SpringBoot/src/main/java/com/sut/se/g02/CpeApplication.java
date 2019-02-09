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
                           PeriodRepository periodRepository,Status1Repository status1Repository,
                           CageRepository cageRepository,CageTypeRepository cageTypeRepository,
                           CompanyRepository companyRepository, StatusPayRepository statusPayRepository
            ,TypeRepository typeRepository,TriageLevelRepository triageLevelRepository,CheckStatusRepository checkStatusRepository ) {
        return args ->{

            Nurse nurse = new Nurse();
            Nurse nurse1 = new Nurse();
            Nurse nurse2 = new Nurse();
            Nurse nurse3 = new Nurse();
            Nurse nurse5 = new Nurse();
            nurse.setNameNurse("นายวชิระ ขวัญใจ");
            nurse.setPasswordNurse("B5716173");
            nurse1.setNameNurse("นางสาวฉัตรแก้ว จันทร์กลาง");
            nurse1.setPasswordNurse("B5713189");
            nurse2.setNameNurse("นางสาวนฌานันท์ ผดุงแดน");
            nurse2.setPasswordNurse("B5710041");
            nurse3.setNameNurse("นางสาวนวรัตน์ แก้วคำลา");
            nurse3.setPasswordNurse("B5711598");
            nurse5.setNameNurse("นายธวัชชัย หนองรวง");
            nurse5.setPasswordNurse("B5705368");
            nurseRepository.save(nurse);
            nurseRepository.save(nurse1);
            nurseRepository.save(nurse2);
            nurseRepository.save(nurse3);
            nurseRepository.save(nurse5);


            Doctor doctor = new Doctor();
            Doctor doctor1 = new Doctor();
            doctor.setNameDoctor("แพทย์หญิงสสิตา วงษ์พยัคฆ์");
            doctor.setPasswordDoctor("D01");
            doctor1.setNameDoctor("แพทย์หญิงปภานัน เสาวิชิต");
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



            StatusPay statusPay = new StatusPay();
            StatusPay statusPay1 = new StatusPay();
            statusPay.setNameStatusPay("ชำระเงินแล้ว");
            statusPay1.setNameStatusPay("ยังไม่ชำระเงิน");
            statusPayRepository.save(statusPay);
            statusPayRepository.save(statusPay1);


            Type type = new Type();
            type.setList("หมอน");
            Type type1 = new Type();
            type1.setList("อาหาร");
            Type type2 = new Type();
            type2.setList("ของเล่น");
            Type type3 = new Type();
            type3.setList("หวี");
            Type type4 = new Type();
            type4.setList("อื่นๆ");
            typeRepository.save(type);
            typeRepository.save(type1);
            typeRepository.save(type2);
            typeRepository.save(type3);
            typeRepository.save(type4);
            
            TriageLevel triagelevel = new TriageLevel();
           TriageLevel triagelevel1 = new TriageLevel();
           TriageLevel triagelevel2 = new TriageLevel();
           TriageLevel triagelevel3 = new TriageLevel();
           TriageLevel triagelevel4 = new TriageLevel();
           
           triagelevel.setLevelName("R-Resuscitation ผู้ป่วยฉุกเฉินวิกฤต");
           triagelevel1.setLevelName("E-Emergency ผู้ป่วยฉุกเฉิน");
           triagelevel2.setLevelName("U-Urgency ผู้ป่วยฉุกเฉินเร่งด่วน");
           triagelevel3.setLevelName("S-Semi Urgency ผู้ป่วยฉุกเฉินไม่รุนแรง");
           triagelevel4.setLevelName("N-Non Urgency ผู้ป่วยทั่วไป ");

           triageLevelRepository.save(triagelevel);
           triageLevelRepository.save(triagelevel1);
           triageLevelRepository.save(triagelevel2);
           triageLevelRepository.save(triagelevel3);
           triageLevelRepository.save(triagelevel4);

            Status1 status1 = new Status1();
            Status1 status11 = new Status1();
            status1.setStatus1("ไม่ยกเลิก");
            status11.setStatus1("ยกเลิก");
            status1Repository.save(status1);
            status1Repository.save(status11);

            CheckStatus checkStatus = new CheckStatus();
            CheckStatus checkStatus1 = new CheckStatus();
            checkStatus.setCheckStatus("รับยาเรียบร้อย");
            checkStatus1.setCheckStatus("ยังไม่ได้รับยา");
            checkStatusRepository.save(checkStatus);
            checkStatusRepository.save(checkStatus1);
        };
    }

}