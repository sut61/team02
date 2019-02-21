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
public class OrderMedicineController {
    @Autowired
    private OrderMedicineRepository orderMedicineRepository;
    @Autowired
    private NurseRepository nurseRepository;
    @Autowired
    private MedicineRepository medicineRepository;
    @Autowired
    private CompanyRepository companyRepository;



    @GetMapping("/OrderMedicine")
    public List<OrderMedicine> OrderMedicine(){
        return orderMedicineRepository.findAll().stream().collect(Collectors.toList());
    }

    @GetMapping("/Company")
    public List<Company> Company(){
        return companyRepository.findAll().stream().collect(Collectors.toList());
    }


    @PostMapping(path ="/OrderMedicine/{nameCompanySelect}/{nameMedicineSelect}/{number}/{note}/{nurseNameSelect}")
    @CrossOrigin(origins = "http://localhost:4200")
    public OrderMedicine orderMedicine(
            @PathVariable  Long nameCompanySelect,
            @PathVariable  Long nameMedicineSelect,
            @PathVariable  Integer number,
            @PathVariable  String note,
            @PathVariable  Long nurseNameSelect){


        Company company = companyRepository.findByCompanyId(nameCompanySelect);
        Medicine medicine = medicineRepository.findByMedicineId(nameMedicineSelect);
        Nurse nurse = nurseRepository.findByNurseId(nurseNameSelect);


        OrderMedicine orderMedicine = new OrderMedicine();
        orderMedicine.setCompany(company);
        orderMedicine.setMedicine(medicine);
        orderMedicine.setNumber(number);
        orderMedicine.setMedicine(medicine);
        orderMedicine.setNote(note);
        orderMedicine.setNurse(nurse);


        orderMedicineRepository.save(orderMedicine);
        return orderMedicine;
    }



}