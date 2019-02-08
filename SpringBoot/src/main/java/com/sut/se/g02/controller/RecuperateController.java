package com.sut.se.g02.controller;


import com.sut.se.g02.entity.*;
import com.sut.se.g02.repository.*;
import lombok.*;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.Collection;
import java.util.stream.Collectors;
import java.util.Date;
import java.util.Optional;
import java.sql.Timestamp;

@RestController 
@CrossOrigin(origins = "http://localhost:4200")
public class RecuperateController {
    @Autowired
    private RecuperateRepository recuperateRepository;
    @Autowired
    private TreatmentRepository treatmentRepository;
    @Autowired
    private CageRepository cageRepository;
    @Autowired
    private CageTypeRepository cageTypeRepository;
    @Autowired
    private NurseRepository nurseRepository;



    @GetMapping(path = "Recuperate", produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<Recuperate> Recuperate() {
        return recuperateRepository.findAll().stream().collect(Collectors.toList());
    }
    @GetMapping("/Recuperate/{id}")
    public Optional<Recuperate> recuperate(@PathVariable Long id) {
        Optional<Recuperate> a = recuperateRepository.findById(id);
        return a;
    }

    /*@GetMapping(path = "PetInfo", produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<PetInfo> PetInfo() {
        return petInfoRepository.findAll().stream().collect(Collectors.toList());
    }
    
     @GetMapping("/PetInfo/{id}")
    public Optional<PetInfo> petInfo(@PathVariable Long id)  {
        Optional<PetInfo> pa = petInfoRepository.findById(id);
        return pa;
    }*/

    @GetMapping(path = "Cage", produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<Cage> Cage() {
        return cageRepository.findAll().stream().collect(Collectors.toList());
    }
    
    @GetMapping("/Cage/{id}")
    public Optional<Cage> cage(@PathVariable Long id) {
        Optional<Cage> d = cageRepository.findById(id);
        return d;
    }
  

    @GetMapping(path = "CageType", produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<CageType> CageType() {
        return cageTypeRepository.findAll().stream().collect(Collectors.toList());
    }

    @GetMapping("/CageType/{id}")
    public Optional<CageType> cageType(@PathVariable Long id)  {
        Optional<CageType> pe = cageTypeRepository.findById(id);
        return pe;
    }

    /*@GetMapping(path = "Nurse", produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<Nurse> Nurse() {
        return nurseRepository.findAll().stream().collect(Collectors.toList());
    }
    
    @GetMapping("/Nurse/{id}")
    public Optional<Nurse> nurse(@PathVariable Long id) {
        Optional<Nurse> c = nurseRepository.findById(id);
        return c;
    }*/

    @PostMapping(path ="/Recuperate/{nameCageSelect}/{nameCageTypeSelect}/{treatSelect}/{note}/{nameNurseSelect}")
    @CrossOrigin(origins = "http://localhost:4200")
    public Recuperate recuperate(
                                            @PathVariable  Long nameCageSelect,
                                         
                                          
                                            @PathVariable  Long nameCageTypeSelect,
                                            @PathVariable  Long treatSelect,
                                            @PathVariable  String note,
                                            @PathVariable  Long nameNurseSelect){


           
            Cage cage = cageRepository.findById(nameCageSelect).get();
            CageType cageType = cageTypeRepository.findById(nameCageTypeSelect).get();
                Treatment treatment = treatmentRepository.findById(treatSelect).get();
            Nurse nurse = nurseRepository.findById(nameNurseSelect).get();
        
        Recuperate recuperate = new Recuperate();
       
        recuperate.setCage(cage);
        recuperate.setDate(new Timestamp(System.currentTimeMillis()));
        recuperate.setCageType(cageType);
       recuperate.setTreatment(treatment);
       recuperate.setNote(note);
        recuperate.setNurse(nurse);

        recuperateRepository.save(recuperate);
        return recuperate;
    } 

    

}