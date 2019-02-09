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


@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class StatusPayController {


    @Autowired
    private StatusPayRepository statusPayRepository;


	@GetMapping(path = "StatusPay", produces = MediaType.APPLICATION_JSON_VALUE)
	    public Collection<StatusPay> StatusPay() {
	        return statusPayRepository.findAll().stream().collect(Collectors.toList());
	}

    @GetMapping("/StatusPay/{id}")
    public Optional<StatusPay> statusPay(@PathVariable Long id){
        Optional<StatusPay> statusPay = statusPayRepository.findById(id);

        return statusPay;
    }


    
}