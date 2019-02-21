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

import java.util.List;

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



     @GetMapping("/Recuperate")
    public List<Recuperate> Recuperate(){
        return recuperateRepository.findAll().stream().collect(Collectors.toList());
    }


     @GetMapping("/Cage")
    public List<Cage> Cage(){
        return cageRepository.findAll().stream().collect(Collectors.toList());
    }


     @GetMapping("/CageType")
    public List<CageType> CageType(){
        return cageTypeRepository.findAll().stream().collect(Collectors.toList());
    }


  

    @PostMapping(path ="/Recuperate/{nameCageSelect}/{nameCageTypeSelect}/{treatSelect}/{note}/{nameNurseSelect}")
    @CrossOrigin(origins = "http://localhost:4200")
    public Recuperate recuperate(
                                            @PathVariable  Long nameCageSelect,
                                         
                                          
                                            @PathVariable  Long nameCageTypeSelect,
                                            @PathVariable  Long treatSelect,
                                            @PathVariable  String note,
                                            @PathVariable  Long nameNurseSelect){


           
            Cage cage = cageRepository.findByCageId(nameCageSelect);
            CageType cageType = cageTypeRepository.findByCageTypeId(nameCageTypeSelect);
                Treatment treatment = treatmentRepository.findByTreatmentId(treatSelect);
            Nurse nurse = nurseRepository.findByNurseId(nameNurseSelect);
        
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