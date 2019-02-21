package com.sut.se.g02.controller;

import com.sut.se.g02.entity.Doctor;
import com.sut.se.g02.repository.DoctorRepository;

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

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class DoctorController {

    @Autowired
    private final DoctorRepository doctorRepository;

    public DoctorController(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    @GetMapping("/Doctor/{nameDoctor}/{passwordDoctor}")
    public boolean customer2(@PathVariable String nameDoctor, @PathVariable String passwordDoctor) {
        Doctor doctor = doctorRepository.findByNameDoctor(nameDoctor);
        String x = doctor.getPasswordDoctor();
        return x.matches(passwordDoctor);
    }




    @GetMapping("/Doctor")
    public List<Doctor> Doctor(){
        return doctorRepository.findAll().stream().collect(Collectors.toList());
    }
    
}