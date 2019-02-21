package com.sut.se.g02.controller;

import com.sut.se.g02.entity.Medicine;
import com.sut.se.g02.repository.MedicineRepository;

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

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class MedicineController {
    @Autowired
    private  MedicineRepository medicineRepository;
    
   


    @GetMapping("/Medicine")
    public List<Medicine> Medicine(){
        return medicineRepository.findAll().stream().collect(Collectors.toList());
    }

}