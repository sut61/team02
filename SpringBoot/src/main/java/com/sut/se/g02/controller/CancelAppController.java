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

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class CancelAppController {
    @Autowired
    private CancelAppRepository cancelAppRepository;
    @Autowired
    private AppointmentRepository appointmentRepository;
    @Autowired
    private NurseRepository nurseRepository;
    @Autowired
    private Status1Repository status1Repository;



    @GetMapping("/CancelApp")
    public List<CancelApp> CancelApp(){
        return cancelAppRepository.findAll().stream().collect(Collectors.toList());
    }

    @GetMapping("/Status1")
    public List<Status1> Status1(){
        return status1Repository.findAll().stream().collect(Collectors.toList());
    }



    @PostMapping(path = "/CancelApp/{nameAppointSelect}/{statusSelect}/{note}/{nameNurseSelect}")
    @CrossOrigin(origins = "http://localhost:4200")
    public CancelApp cancelApp(
            @PathVariable Long nameAppointSelect,
            @PathVariable Long statusSelect,
            @PathVariable String note,
            @PathVariable Long nameNurseSelect) {

        Appointment appointment = appointmentRepository.findByAppointmentId(nameAppointSelect);
        Status1 status1 = status1Repository.findByStatusId(statusSelect);
        Nurse nurse = nurseRepository.findByNurseId(nameNurseSelect);


        CancelApp cancelApp = new CancelApp();
        cancelApp.setAppointment(appointment);
        cancelApp.setStatus1(status1);
        cancelApp.setNote(note);
        cancelApp.setNurse(nurse);

        cancelAppRepository.save(cancelApp);
        return cancelApp;
    }
}
