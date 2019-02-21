package com.sut.se.g02.controller;

import com.sut.se.g02.entity.*;
import com.sut.se.g02.repository.*;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.Collection;
import java.util.stream.Collectors;
import java.util.Optional;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ReceiveMedicineController {
    @Autowired
    private ReceiveMedicineRepository receiveMedicineRepository;
    @Autowired
    private OrderMedicineRepository orderMedicineRepository;
    @Autowired
    private NurseRepository nurseRepository;
    @Autowired
    private CheckStatusRepository checkStatusRepository;



     @GetMapping("/ReceiveMedicine")
    public List<ReceiveMedicine> ReceiveMedicine(){
        return receiveMedicineRepository.findAll().stream().collect(Collectors.toList());
    }


     @GetMapping("/CheckStatus")
    public List<CheckStatus> CheckStatus(){
        return checkStatusRepository.findAll().stream().collect(Collectors.toList());
    }

    @PostMapping(path ="/ReceiveMedicine/{orderMedicineIdSelect}/{noteNew}/{checkStatusSelect}/{nurseNameSelect}")
    @CrossOrigin(origins = "http://localhost:4200")
    public ReceiveMedicine receiveMedicine(
            @PathVariable  Long orderMedicineIdSelect,
            @PathVariable  String noteNew,
            @PathVariable  Long checkStatusSelect,
            @PathVariable  Long nurseNameSelect){


        OrderMedicine orderMedicine = orderMedicineRepository.findByOrderMedicineId(orderMedicineIdSelect);
        CheckStatus checkStatus = checkStatusRepository.findByCheckStatusId(checkStatusSelect);
        Nurse nurse = nurseRepository.findByNurseId(nurseNameSelect);


        ReceiveMedicine receiveMedicine = new ReceiveMedicine();
        receiveMedicine.setOrderMedicine(orderMedicine);
        receiveMedicine.setNoteNew(noteNew);
        receiveMedicine.setCheckStatus(checkStatus);
        receiveMedicine.setNurse(nurse);


        receiveMedicineRepository.save(receiveMedicine);
        return receiveMedicine;
    }



}