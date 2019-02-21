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
public class PayController {


    
    @Autowired
    private PayInfoRepository payInfoRepository;

    @Autowired
    private StatusPayRepository statusPayRepository;

    @Autowired
    private NurseRepository nurseRepository;

    @Autowired
    private PayRepository payRepository;



    @GetMapping("/Pay")
    public List<Pay> Pay(){
        return payRepository.findAll().stream().collect(Collectors.toList());
    }



     
    @PostMapping(path ="/Pay/{payInfoSelect}/{statusPaySelect}/{note}/{nameNurseSelect}")
    @CrossOrigin(origins = "http://localhost:4200")  
    public Pay pay(
                    @PathVariable  Long payInfoSelect,
                    @PathVariable  Long statusPaySelect,
                    @PathVariable  String note,
                    @PathVariable  Long nameNurseSelect

                    ){



            PayInfo payInfo = payInfoRepository.findByPayInfoId(payInfoSelect);
            StatusPay statusPay = statusPayRepository.findByStatusPayId(statusPaySelect);
            Nurse nurse = nurseRepository.findByNurseId(nameNurseSelect);


        
        Pay pay = new Pay();
        pay.setDateandtime(new Timestamp(System.currentTimeMillis()));
        pay.setPayInfo(payInfo);
        pay.setStatusPay(statusPay);
        pay.setNote(note);
        pay.setNurse(nurse);
        
        payRepository.save(pay);
        return pay;

    } 
}