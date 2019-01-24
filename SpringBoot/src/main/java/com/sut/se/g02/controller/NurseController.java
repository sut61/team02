package com.sut.se.g02.controller;

import com.sut.se.g02.entity.Nurse;
import com.sut.se.g02.repository.NurseRepository;

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

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class NurseController {

    @Autowired
    private final NurseRepository nurseRepository;

    public NurseController(NurseRepository nurseRepository) {
        this.nurseRepository = nurseRepository;
    }

    @GetMapping("/Nurse/{nameNurse}/{passwordNurse}")
    public boolean customer1(@PathVariable String nameNurse, @PathVariable String passwordNurse) {
        Nurse nurse = nurseRepository.findByNameNurse(nameNurse);
        String x = nurse.getPasswordNurse();
        return x.matches(passwordNurse);
    }

    @GetMapping(path = "Nurse", produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<Nurse> Nurse() {
        return nurseRepository.findAll().stream().collect(Collectors.toList());
    }
    
    @GetMapping("/Nurse/{id}")
    public Optional<Nurse> nurse(@PathVariable Long id) {
        Optional<Nurse> n = nurseRepository.findById(id);
        return n;
    }

}