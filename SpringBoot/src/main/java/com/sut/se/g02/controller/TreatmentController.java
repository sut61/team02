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


    

    @GetMapping(path = "Treatment",produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<Treatment> Treatment(){
        return  treatmentRepository.findAll().stream().collect(Collectors.toList());
    }
    @GetMapping("/Treatment/{id}")
    public Optional<Treatment> treatment(@PathVariable Long id){
        Optional<Treatment> treat = treatmentRepository.findById(id);

        return treat;
    }

   

    /*@GetMapping(path = "PetInfo", produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<PetInfo> PetInfo() {
        return petInfoRepository.findAll().stream().collect(Collectors.toList());
    }
    @GetMapping("/PetInfo/{id}")
    public Optional<PetInfo> petInfo(@PathVariable Long id)  {
        Optional<PetInfo> petInfo = petInfoRepository.findById(id);
        return petInfo;
    }*/

    /*@GetMapping(path = "Owner", produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<Owner> Owner() {
        return ownerRepository.findAll().stream().collect(Collectors.toList());
    }
    @GetMapping("/Owner/{id}")
    public Optional<Owner> owner(@PathVariable Long id)  {
        Optional<Owner> owner = ownerRepository.findById(id);
        return owner;
    }*/


    /*@GetMapping(path = "Medicine", produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<Medicine> Medicine() {
        return medicineRepository.findAll().stream().collect(Collectors.toList());
    }

     @GetMapping("/Medicine/{id}")
    public Optional<Medicine> medicine(@PathVariable Long id)  {
        Optional<Medicine> medicine = medicineRepository.findById(id);
        return medicine;
    }
*/
    @PostMapping(path ="/Treatment/{nameDoctorSelect}/{namePetInfoSelect}/{nameOwnerSelect}/{nameMedicineSelect}/{symptom}/{dCon}")
   

    public Treatment treatment(
            @PathVariable  Long nameDoctorSelect,
            @PathVariable  Long namePetInfoSelect,
            @PathVariable  Long nameOwnerSelect,
            @PathVariable  Long nameMedicineSelect,
            @PathVariable  String symptom,
            @PathVariable  int dCon



            ){

        Doctor doctor = doctorRepository.findById(nameDoctorSelect).get();
        PetInfo petInfo = petInfoRepository.findById(namePetInfoSelect).get();
        Owner owner = ownerRepository.findById(nameOwnerSelect).get();
        Medicine medicine = medicineRepository.findById(nameMedicineSelect).get();
        

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
        
    



