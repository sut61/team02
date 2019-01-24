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
public class AppointmentController {
    @Autowired
    private AppointmentRepository appointmentRepository;
    @Autowired
    private PetInfoRepository petInfoRepository;
    @Autowired
    private DoctorRepository doctorRepository;
    @Autowired
    private NurseRepository nurseRepository;
    @Autowired
    private PeriodRepository periodRepository;
    @Autowired
    private OwnerRepository ownerRepository;


    @GetMapping(path = "Appointment", produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<Appointment> Appointment() {
        return appointmentRepository.findAll().stream().collect(Collectors.toList());
    }

    @GetMapping("/Appointment/{id}")
    public Optional<Appointment> appointment(@PathVariable Long id) {
        Optional<Appointment> a = appointmentRepository.findById(id);
        return a;
    }

    /*@GetMapping(path = "PetInfo", produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<PetInfo> PetInfo() {
        return petInfoRepository.findAll().stream().collect(Collectors.toList());
    }

    @GetMapping("/PetInfo/{id}")
    public Optional<PetInfo> petInfo(@PathVariable Long id) {
        Optional<PetInfo> p = petInfoRepository.findById(id);
        return p;
    }*/

    /*@GetMapping(path = "Doctor", produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<Doctor> Doctor() {
        return doctorRepository.findAll().stream().collect(Collectors.toList());
    }

    @GetMapping("/Doctor/{id}")
    public Optional<Doctor> doctor(@PathVariable Long id) {
        Optional<Doctor> d = doctorRepository.findById(id);
        return d;
    }
    @GetMapping(path = "Nurse", produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<Nurse> Nurse() {
        return nurseRepository.findAll().stream().collect(Collectors.toList());
    }

    @GetMapping("/Nurse/{id}")
    public Optional<Nurse> nurse (@PathVariable Long id) {
        Optional<Nurse> n = nurseRepository.findById(id);
        return n;
    }*/

    @GetMapping(path = "Period", produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<Period> Period() {
        return periodRepository.findAll().stream().collect(Collectors.toList());
    }

    @GetMapping("/Period/{id}")
    public Optional<Period> period(@PathVariable Long id) {
        Optional<Period> pe = periodRepository.findById(id);
        return pe;
    }


    /*@GetMapping(path = "Owner", produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<Owner> Owner() {
        return ownerRepository.findAll().stream().collect(Collectors.toList());
    }

    @GetMapping("/Owner/{id}")
    public Optional<Owner> owner(@PathVariable Long id) {
        Optional<Owner> o = ownerRepository.findById(id);
        return o;
    }*/

    @PostMapping(path = "/Appointment/{nameOwnerSelect}/{nameDoctorSelect}/{date}/{periodsSelect}/{note}/{nameNurseSelect}")
    @CrossOrigin(origins = "http://localhost:4200")
    public Appointment appointment(
            @PathVariable Long nameOwnerSelect,
            //@PathVariable Long namePetSelect,
            //@PathVariable Long telOwnerSelect,
            @PathVariable Long nameDoctorSelect,
            @PathVariable Date date,
            @PathVariable Long periodsSelect,
            @PathVariable String note,
            @PathVariable Long nameNurseSelect) {

        Owner owner = ownerRepository.findById(nameOwnerSelect).get();
        //Owner owner1 = ownerRepository.findById(telOwnerSelect).get();
        //PetInfo petInfo = petInfoRepository.findById(namePetSelect).get();
        Doctor doctor = doctorRepository.findById(nameDoctorSelect).get();
        Nurse nurse = nurseRepository.findById(nameNurseSelect).get();
        Period period = periodRepository.findById(periodsSelect).get();


        Appointment appointment = new Appointment();
        appointment.setOwner(owner);
        //appointment.setPetInfo(petInfo);
        //appointment.setOwner(owner1);
        appointment.setDoctor(doctor);
        appointment.setDate(date);
        appointment.setPeriod(period);
        appointment.setNote(note);
        appointment.setNurse(nurse);

        appointmentRepository.save(appointment);
        return appointment;
    }

}
