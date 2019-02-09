package com.sut.se.g02.controller;
import lombok.Data;
import org.springframework.http.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.sut.se.g02.entity.*;
import com.sut.se.g02.repository.*;

import javax.print.Doc;
import java.util.Date;
import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class TriageController {

    @Autowired
    private TriageRepository triageRepository;
    @Autowired
    private PetInfoRepository petInfoRepository;
    @Autowired
    private NurseRepository nurseRepository;
    @Autowired
    private TriageLevelRepository triageLevelRepository;
   


    @GetMapping(path = "Triage", produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<Triage> Triage() {
        return triageRepository.findAll().stream().collect(Collectors.toList());
    }

    @GetMapping("/Triage/{id}")
    public Optional<Triage> triage(@PathVariable Long id)  {
        Optional<Triage> triage = triageRepository.findById(id);
        return triage;
    }

    
    

   @PostMapping(path ="/Triage/{nameNurseSelect}/{namePetInfoSelect}/{symptom}/{triageLevelSelect}")
    public Triage triage( 
                            @PathVariable Long nameNurseSelect ,
                            @PathVariable Long namePetInfoSelect,
                            @PathVariable String symptom,
                            @PathVariable Long triageLevelSelect
                            
                                              ){
           
            Nurse nurse = nurseRepository.findById(nameNurseSelect).get();
            PetInfo  petInfo = petInfoRepository.findById(namePetInfoSelect).get();
            TriageLevel  triageLevel = triageLevelRepository.findById(triageLevelSelect).get(); 


        Triage triage = new Triage();
        
        triage.setNurse(nurse);
        triage.setPetInfo(petInfo);
        triage.setSymptom(symptom);
        triage.setTriageLevel(triageLevel);

        triageRepository.save(triage);
         return  triage;
    }







}
