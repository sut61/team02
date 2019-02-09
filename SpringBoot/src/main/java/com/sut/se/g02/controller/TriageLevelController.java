package com.sut.se.g02.controller;

import com.sut.se.g02.entity.*;
import com.sut.se.g02.repository.*;

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
public class TriageLevelController {

    @Autowired
    private  TriageLevelRepository triageLevelRepository;


    @GetMapping(path = "TriageLevel", produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<TriageLevel> TriageLevel() {
        return triageLevelRepository.findAll().stream().collect(Collectors.toList());
    }
    
    @GetMapping("/triageLevel/{id}")
    public Optional<TriageLevel> triageLevel(@PathVariable Long id) {
        Optional<TriageLevel> triageLevel = triageLevelRepository.findById(id);
        return triageLevel;
    }

}