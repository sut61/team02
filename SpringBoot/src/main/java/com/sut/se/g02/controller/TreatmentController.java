package com.sut.se.g02.controller;

import com.sut.se.g02.repository.*;
import com.sut.se.g02.entity.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.MediaType;

import java.util.Collection;
import java.util.Date;
import java.util.stream.Collectors;
import java.util.Optional;
import java.sql.Timestamp;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class TreatmentController {
    
    @Autowired
    private PetInfoRepository petInfoRepository;
    @Autowired
    private DoctorRepository doctorRepository;
    @Autowired
    private OwnerRepository ownerRepository;
    @Autowired
    private MedicineRepository medicineRepository;
    @Autowired
    private TreatmentRepository treatmentRepository;


 
    @GetMapping("/Treatment")
    public List<Treatment> Treatment(){
        return treatmentRepository.findAll().stream().collect(Collectors.toList());
    }
   

    
    @PostMapping(path ="/Treatment/{nameDoctorSelect}/{namePetInfoSelect}/{nameOwnerSelect}/{nameMedicineSelect}/{symptom}/{dCon}")
   

    public Treatment treatment(
            @PathVariable  Long nameDoctorSelect,
            @PathVariable  Long namePetInfoSelect,
            @PathVariable  Long nameOwnerSelect,
            @PathVariable  Long nameMedicineSelect,
            @PathVariable  String symptom,
            @PathVariable  int dCon



            ){

        Doctor doctor = doctorRepository.findByDoctorId(nameDoctorSelect);
        PetInfo petInfo = petInfoRepository.findByPetId(namePetInfoSelect);
        Owner owner = ownerRepository.findByOwnerId(nameOwnerSelect);
        Medicine medicine = medicineRepository.findByMedicineId(nameMedicineSelect);
        

        Treatment treatment = new Treatment();
        treatment.setDate(new Timestamp(System.currentTimeMillis()));
        treatment.setDoctor(doctor);
        treatment.setPetInfo(petInfo);
        treatment.setOwner(owner);
        treatment.setMedicine(medicine);
        treatment.setSymptom(symptom);
        treatment.setDCon(dCon);

        


        treatmentRepository.save(treatment);
        return treatment;
    }

}   
        
    



