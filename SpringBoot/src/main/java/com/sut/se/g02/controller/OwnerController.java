package com.sut.se.g02.controller;

import com.sut.se.g02.entity.Owner;
import com.sut.se.g02.repository.NurseRepository;
import com.sut.se.g02.repository.OwnerRepository;

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
public class OwnerController {

    @Autowired
    private  OwnerRepository ownerRepository;
    //private final OwnerRepository ownerRepository;

    public OwnerController(OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
    }
    @GetMapping(path = "Owner", produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<Owner> Owner() {
        return ownerRepository.findAll().stream().collect(Collectors.toList());
    } }