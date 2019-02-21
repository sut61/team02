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


import java.util.List;

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
   


    @GetMapping("/Triage")
    public List<Triage> Triage(){
        return triageRepository.findAll().stream().collect(Collectors.toList());
    }
    

   @PostMapping(path ="/Triage/{nameNurseSelect}/{namePetInfoSelect}/{symptom}/{triageLevelSelect}")
    public Triage triage( 
                            @PathVariable Long nameNurseSelect ,
                            @PathVariable Long namePetInfoSelect,
                            @PathVariable String symptom,
                            @PathVariable Long triageLevelSelect
                            
                                              ){
           
            Nurse nurse = nurseRepository.findByNurseId(nameNurseSelect);
            PetInfo  petInfo = petInfoRepository.findByPetId(namePetInfoSelect);
            TriageLevel  triageLevel = triageLevelRepository.findByLevelId(triageLevelSelect); 


        Triage triage = new Triage();
        
        triage.setNurse(nurse);
        triage.setPetInfo(petInfo);
        triage.setSymptom(symptom);
        triage.setTriageLevel(triageLevel);

        triageRepository.save(triage);
         return  triage;
    }


}
