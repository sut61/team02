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

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class TriageLevelController {

    @Autowired
    private  TriageLevelRepository triageLevelRepository;



    @GetMapping("/TriageLevel")
    public List<TriageLevel> TriageLevel(){
        return triageLevelRepository.findAll().stream().collect(Collectors.toList());
    }
}