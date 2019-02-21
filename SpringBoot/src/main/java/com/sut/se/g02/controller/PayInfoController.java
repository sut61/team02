package com.sut.se.g02.controller;

import com.sut.se.g02.repository.*;
import com.sut.se.g02.entity.*;


import lombok.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
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
public class PayInfoController {

    @Autowired
    private OwnerRepository ownerRepository;
    @Autowired
    private TreatmentRepository treatmentRepository;
    @Autowired
    private MedicineRepository medicineRepository;
    @Autowired
    private NurseRepository nurseRepository;
    
    @Autowired
    private PayInfoRepository payInfoRepository;


    @GetMapping("/PayInfo")
    public List<PayInfo> PayInfo(){
        return payInfoRepository.findAll().stream().collect(Collectors.toList());
    }

     
    @PostMapping(path ="/PayInfo/{ownerNameSelect}/{treatmentIdSelect}/{priceSelect}/{note}/{nameNurseSelect}")
    @CrossOrigin(origins = "http://localhost:4200")  
    public PayInfo payInfo(
                    @PathVariable  Long ownerNameSelect,
                    @PathVariable  Long treatmentIdSelect,
                    @PathVariable  Long priceSelect,
                    @PathVariable  String note,
                    @PathVariable  Long nameNurseSelect

                    ){



            Owner owner = ownerRepository.findByOwnerId(ownerNameSelect);
            Treatment treatment = treatmentRepository.findByTreatmentId(treatmentIdSelect);
            Medicine medicine = medicineRepository.findByMedicineId(priceSelect);
            Nurse nurse = nurseRepository.findByNurseId(nameNurseSelect);


        
        PayInfo payInfo = new PayInfo();
        payInfo.setDateandtime(new Timestamp(System.currentTimeMillis()));
        payInfo.setOwner(owner);
        payInfo.setTreatment(treatment);
        payInfo.setMedicine(medicine);
        payInfo.setNote(note);
        payInfo.setNurse(nurse);
        
        payInfoRepository.save(payInfo);
        return payInfo;
    } 

}