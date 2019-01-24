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

/*
    @GetMapping(path = "Owner", produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<Owner> Owner() {
        return ownerRepository.findAll().stream().collect(Collectors.toList());
    }

    @GetMapping("/Owner/{id}")
    public Optional<Owner> owner(@PathVariable Long id){
        Optional<Owner> owner = ownerRepository.findById(id);

        return owner;
    }
*/
/*
    @GetMapping(path = "Treatment",produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<Treatment> Treatment(){
        return  treatmentRepository.findAll().stream().collect(Collectors.toList());
    }
    
    @GetMapping("/Treatment/{id}")
    public Optional<Treatment> treatment(@PathVariable Long id){
        Optional<Treatment> treat = treatmentRepository.findById(id);

        return treat;
    }
*/
/*
    @GetMapping(path = "Medicine", produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<Medicine> Medicine() {
        return medicineRepository.findAll().stream().collect(Collectors.toList());
    }

    @GetMapping("/Medicine/{id}")
    public Optional<Medicine> medicine(@PathVariable Long id)  {
        Optional<Medicine> med = medicineRepository.findById(id);
        return med;
    }
*/
/*
    @GetMapping(path = "Nurse", produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<Nurse> Nurse() {
        return nurseRepository.findAll().stream().collect(Collectors.toList());
    }


    @GetMapping("/Nurse/{id}")
    public Optional<Nurse> nurse(@PathVariable Long id){
        Optional<Nurse> nurse = nurseRepository.findById(id);

        return nurse;
    }
*/

	@GetMapping(path = "PayInfo", produces = MediaType.APPLICATION_JSON_VALUE)
	    public Collection<PayInfo> PayInfo() {
	        return payInfoRepository.findAll().stream().collect(Collectors.toList());
	}

    @GetMapping("/PayInfo/{id}")
    public Optional<PayInfo> payInfo(@PathVariable Long id){
        Optional<PayInfo> payinfo = payInfoRepository.findById(id);

        return payinfo;
    }


     
    @PostMapping(path ="/PayInfo/{ownerNameSelect}/{treatmentIdSelect}/{priceSelect}/{nameNurseSelect}")
    @CrossOrigin(origins = "http://localhost:4200")  
    public PayInfo payInfo(
                    @PathVariable  Long ownerNameSelect,
                    @PathVariable  Long treatmentIdSelect,
                    @PathVariable  Long priceSelect,
                    @PathVariable  Long nameNurseSelect

                    ){



            Owner owner = ownerRepository.findById(ownerNameSelect).get();
            Treatment treatment = treatmentRepository.findById(treatmentIdSelect).get();
            Medicine medicine = medicineRepository.findById(priceSelect).get();
            Nurse nurse = nurseRepository.findById(nameNurseSelect).get();


        
        PayInfo payInfo = new PayInfo();
        payInfo.setDateandtime(new Timestamp(System.currentTimeMillis()));
        payInfo.setOwner(owner);
        payInfo.setTreatment(treatment);
        payInfo.setMedicine(medicine);
        payInfo.setNurse(nurse);
        
        payInfoRepository.save(payInfo);
        return payInfo;
    } 
/*
    @GetMapping("/PayInfo/sum")
    public Long sum(@PathVariable  Long ownerNameSelect,
                    @RequestBody   Treatment treatment,
                    @PathVariable  Long nameNurseSelect){
        Long sum = this.sum;
        // System.out.println(sum);
        return  sum; 
        

    }*/

}