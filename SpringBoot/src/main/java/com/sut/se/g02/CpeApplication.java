package com.sut.se.g02;

import lombok.*;
import com.sut.se.g02.repository.*;
import com.sut.se.g02.entity.*;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.filter.CharacterEncodingFilter;
import java.sql.Timestamp;
import java.util.Date;


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
    ApplicationRunner init(NurseRepository nurseRepository, 
    						DoctorRepository doctorRepository,
                           BreedRepository breedRepository,
                           MedicineRepository medicineRepository,
                           PeriodRepository periodRepository,
                           Status1Repository status1Repository,
                           CageRepository cageRepository,
                           CageTypeRepository cageTypeRepository,
                           CompanyRepository companyRepository, 
                           StatusPayRepository statusPayRepository,
                           TypeRepository typeRepository,
                           TriageLevelRepository triageLevelRepository,
                           CheckStatusRepository checkStatusRepository,
             			   PayInfoRepository payInfoRepository,
             			   OwnerRepository ownerRepository,
             			   TreatmentRepository treatmentRepository,
             			   PetInfoRepository petInfoRepository,
             			   RecuperateRepository recuperateRepository,
             			   AppointmentRepository appointmentRepository,
             			   OrderMedicineRepository orderMedicineRepository,
             			   CancelAppRepository cancelAppRepository,
             			   TriageRepository triageRepository,
             			   MoveRepository moveRepository,
             			   PayRepository payRepository,
             			   ReceiveMedicineRepository receiveMedicineRepository) {
        return args ->{

        //-------Nurse--------------------------------
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

        //-------Doctor--------------------------------

            Doctor doctor = new Doctor();
            Doctor doctor1 = new Doctor();
            doctor.setNameDoctor("แพทย์หญิงสสิตา วงษ์พยัคฆ์");
            doctor.setPasswordDoctor("D01");
            doctor1.setNameDoctor("แพทย์หญิงปภานัน เสาวิชิต");
            doctor1.setPasswordDoctor("D02");
            doctorRepository.save(doctor);
            doctorRepository.save(doctor1);

        //-------Breed--------------------------------

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

        //-------Medicine--------------------------------

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

        //-------Period--------------------------------    

            Period period = new Period();
            Period period1 = new Period();
            period.setPeriods("10.00-12.00");
            period1.setPeriods("13.00-15.00");
            periodRepository.save(period);
            periodRepository.save(period1);

        //-------CageType--------------------------------

            CageType cageType = new CageType();
            CageType cageType1 = new CageType();
            cageType.setNameCageType("A:กรงเดี่ยว");
            cageType1.setNameCageType("B:กรงรวม");
            cageTypeRepository.save(cageType);
            cageTypeRepository.save(cageType1);
             
        //-------Cage--------------------------------

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

        //-------Company--------------------------------

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

        //-------StatusPay--------------------------------

            StatusPay statusPay = new StatusPay();
            StatusPay statusPay1 = new StatusPay();
            statusPay.setNameStatusPay("ชำระเงินแล้ว");
            statusPay1.setNameStatusPay("ยังไม่ชำระเงิน");
            statusPayRepository.save(statusPay);
            statusPayRepository.save(statusPay1);

        //-------Type--------------------------------

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


        //-------TriageLevel--------------------------------
            
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


        //-------Status1--------------------------------

            Status1 status1 = new Status1();
            Status1 status11 = new Status1();
            status1.setStatus1("ไม่ยกเลิก");
            status11.setStatus1("ยกเลิก");
            status1Repository.save(status1);
            status1Repository.save(status11);

        //-------CheckStatus--------------------------------

            CheckStatus checkStatus = new CheckStatus();
            CheckStatus checkStatus1 = new CheckStatus();
            checkStatus.setCheckStatus("รับยาเรียบร้อย");
            checkStatus1.setCheckStatus("ยังไม่ได้รับยา");
            checkStatusRepository.save(checkStatus);
            checkStatusRepository.save(checkStatus1);



//////////////////// Sprint 1 /////////////////////////////////////////////////////

            //--------Owner------------

            Owner owner = new Owner();
            Owner owner1 = new Owner();
            owner.setOwnerName("แก้ว");
			owner.setOwnerTel("0806195098");

            owner1.setOwnerName("ฟิว");
			owner1.setOwnerTel("0909999999");

			ownerRepository.save(owner);
            ownerRepository.save(owner1);

			System.out.println("");
			ownerRepository.findAll().forEach(System.out::println);
			System.out.println("");

            //--------PetInfo------------

            PetInfo petInfo = new PetInfo();
            PetInfo petInfo1 = new PetInfo();
            petInfo.setPetName("nini");
            petInfo.setOwner(owner);
            petInfo.setAge(5);
            petInfo.setWeight(20.0);
            petInfo.setHeight(30.0);
			petInfo.setBreed(breed1);
            petInfo.setNurse(nurse);

            petInfo1.setPetName("lili");
            petInfo1.setOwner(owner1);
            petInfo1.setAge(5);
            petInfo1.setWeight(20.0);
            petInfo1.setHeight(30.0);
			petInfo1.setBreed(breed1);
            petInfo1.setNurse(nurse);

            petInfoRepository.save(petInfo);
            petInfoRepository.save(petInfo1);



            //--------Treatment------------

            Treatment treatment = new Treatment();
            treatment.setDate(new Timestamp(System.currentTimeMillis()));
            treatment.setDoctor(doctor);
	        treatment.setPetInfo(petInfo);
	        treatment.setOwner(owner);
	        treatment.setMedicine(medicine);
	        treatment.setSymptom("ป่วย");
	        treatment.setDCon(3);
	        treatmentRepository.save(treatment);





            //--------PaymentInfo------------

            PayInfo payInfo = new PayInfo();
            payInfo.setDateandtime(new Timestamp(System.currentTimeMillis()));
	        payInfo.setOwner(owner);
	        payInfo.setTreatment(treatment);
	        payInfo.setMedicine(medicine);
	        payInfo.setNote("มีเงินจ่าย");
	        payInfo.setNurse(nurse3);
	        payInfoRepository.save(payInfo);





            //--------Recuperate------------

            Recuperate recuperate = new Recuperate();
            recuperate.setCage(cage);
	        recuperate.setDate(new Timestamp(System.currentTimeMillis()));
	        recuperate.setCageType(cageType);
	        recuperate.setTreatment(treatment);
	        recuperate.setNote("Sick");
	        recuperate.setNurse(nurse2);
	        recuperateRepository.save(recuperate);




            //--------Appointment------------

            Appointment appointment = new Appointment();
	        appointment.setOwner(owner);
	        appointment.setPetInfo(petInfo);
	        appointment.setDoctor(doctor);
	        appointment.setDate(new Date());
	        appointment.setPeriod(period);
	        appointment.setNote("ป่วย");
	        appointment.setNurse(nurse1);

        	appointmentRepository.save(appointment);;




            //--------OrderMedicine------------

            OrderMedicine orderMedicine = new OrderMedicine();
	        orderMedicine.setCompany(company);
	        orderMedicine.setMedicine(medicine);
	        orderMedicine.setNumber(20);
	        orderMedicine.setMedicine(medicine);
	        orderMedicine.setNote("ยาหมด");
	        orderMedicine.setNurse(nurse5);

	        orderMedicineRepository.save(orderMedicine);


            OrderMedicine orderMedicine2 = new OrderMedicine();
            orderMedicine2.setCompany(company);
            orderMedicine2.setMedicine(medicine);
            orderMedicine2.setNumber(20);
            orderMedicine2.setMedicine(medicine);
            orderMedicine2.setNote("ยาหมด");
            orderMedicine2.setNurse(nurse5);

            orderMedicineRepository.save(orderMedicine2);



//////////////////// Sprint 2 /////////////////////////////////////////////////////

            //--------CancelApp------------

            CancelApp cancelApp = new CancelApp();
	        cancelApp.setAppointment(appointment);
	        cancelApp.setStatus1(status1);
	        cancelApp.setNote("ไม่ว่าง");
	        cancelApp.setNurse(nurse1);

	        cancelAppRepository.save(cancelApp);




            CancelApp cancelApp1 = new CancelApp();
	        cancelApp1.setAppointment(appointment);
	        cancelApp1.setStatus1(status11);
	        cancelApp1.setNote("-");
	        cancelApp1.setNurse(nurse1);

	        cancelAppRepository.save(cancelApp1);




             //--------Triage------------

            Triage triage = new Triage();
        
	        triage.setNurse(nurse);
	        triage.setPetInfo(petInfo);
	        triage.setSymptom("ป่วยหนักมาก");
	        triage.setTriageLevel(triagelevel);

	        triageRepository.save(triage);




            //--------Move------------

            Move move = new Move();
	        move.setRecuperate(recuperate);
	        move.setOwner(owner);
	        move.setCage(cage);
	        move.setDate(new Date());
	        move.setNote("ABCD");
	        move.setNurse(nurse2);

	        moveRepository.save(move);




            //--------Pay------------

            Pay pay = new Pay();
	        pay.setDateandtime(new Timestamp(System.currentTimeMillis()));
	        pay.setPayInfo(payInfo);
	        pay.setStatusPay(statusPay);
	        pay.setNote("รวยมาก");
	        pay.setNurse(nurse3);
	        
	        payRepository.save(pay);



            Pay pay1 = new Pay();
	        pay1.setDateandtime(new Timestamp(System.currentTimeMillis()));
	        pay1.setPayInfo(payInfo);
	        pay1.setStatusPay(statusPay1);
	        pay1.setNote("รวยมาก");
	        pay1.setNurse(nurse3);
	        
	        payRepository.save(pay1);




	        //--------ReceiveMedicine------------

            ReceiveMedicine receiveMedicine = new ReceiveMedicine();
	        receiveMedicine.setOrderMedicine(orderMedicine);
	        receiveMedicine.setNoteNew("โอเค");
	        receiveMedicine.setCheckStatus(checkStatus);
	        receiveMedicine.setNurse(nurse5);


	        receiveMedicineRepository.save(receiveMedicine);



            ReceiveMedicine receiveMedicine1 = new ReceiveMedicine();
	        receiveMedicine1.setOrderMedicine(orderMedicine);
	        receiveMedicine1.setNoteNew("ไม่รู็สิ");
	        receiveMedicine1.setCheckStatus(checkStatus1);
	        receiveMedicine1.setNurse(nurse5);


	        receiveMedicineRepository.save(receiveMedicine);





        };
    }

}