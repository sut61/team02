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



    @GetMapping(path = "OrderMedicine", produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<OrderMedicine> OrderMedicine() {
        return orderMedicineRepository.findAll().stream().collect(Collectors.toList());
    }
    @GetMapping("/OrderMedicine/{id}")
    public Optional<OrderMedicine> orderMedicine(@PathVariable Long id) {
        Optional<OrderMedicine> o = orderMedicineRepository.findById(id);
        return o;
    }

    @GetMapping(path = "Company", produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<Company> Company() {
        return companyRepository.findAll().stream().collect(Collectors.toList());
    }

    @GetMapping("/Company/{id}")
    public Optional<Company> company(@PathVariable Long id)  {
        Optional<Company> c = companyRepository.findById(id);
        return c;
    }


    @PostMapping(path ="/OrderMedicine/{nameCompanySelect}/{nameMedicineSelect}/{number}/{note}/{nurseNameSelect}")
    @CrossOrigin(origins = "http://localhost:4200")
    public OrderMedicine orderMedicine(
            @PathVariable  Long nameCompanySelect,
            @PathVariable  Long nameMedicineSelect,
            @PathVariable  Integer number,
            @PathVariable  String note,
            @PathVariable  Long nurseNameSelect){


        Company company = companyRepository.findById(nameCompanySelect).get();
        Medicine medicine = medicineRepository.findById(nameMedicineSelect).get();
        Nurse nurse = nurseRepository.findById(nurseNameSelect).get();


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