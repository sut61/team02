package com.sut.se.g02.controller;

import org.springframework.boot.json.JsonParseException;
import java.io.IOException;
import java.net.URLDecoder;
import java.util.Map;
import org.springframework.web.bind.annotation.PathVariable;

import com.sut.se.g02.entity.*;
import com.sut.se.g02.repository.*;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.Collection;
import java.util.stream.Collectors;
import java.util.Date;
import java.util.Optional;


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

    @GetMapping(path = "CancelApp", produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<CancelApp> CancelApp() {
        return cancelAppRepository.findAll().stream().collect(Collectors.toList());
    }

    @GetMapping("/CancelApp/{id}")
    public Optional<CancelApp> cancelApp(@PathVariable Long id) {
        Optional<CancelApp> ca = cancelAppRepository.findById(id);
        return ca;
    }

    @GetMapping(path = "Status1", produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<Status1> Status1() {
        return status1Repository.findAll().stream().collect(Collectors.toList());
    }

    @GetMapping("/Status1/{id}")
    public Optional<Status1> status1(@PathVariable Long id) {
        Optional<Status1> s = status1Repository.findById(id);
        return s;
    }
    @PostMapping(path = "/CancelApp/{nameAppointSelect}/{statusSelect}/{note}/{nameNurseSelect}")
    @CrossOrigin(origins = "http://localhost:4200")
    public CancelApp cancelApp(
            @PathVariable Long nameAppointSelect,
            @PathVariable Long statusSelect,
            @PathVariable String note,
            @PathVariable Long nameNurseSelect) {

        Appointment appointment = appointmentRepository.findById(nameAppointSelect).get();
        Status1 status1 = status1Repository.findById(statusSelect).get();
        Nurse nurse = nurseRepository.findById(nameNurseSelect).get();


        CancelApp cancelApp = new CancelApp();
        cancelApp.setAppointment(appointment);
        cancelApp.setStatus1(status1);
        cancelApp.setNote(note);
        cancelApp.setNurse(nurse);

        cancelAppRepository.save(cancelApp);
        return cancelApp;
    }
}
