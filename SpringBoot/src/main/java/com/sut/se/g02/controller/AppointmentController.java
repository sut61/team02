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


    @GetMapping("/Appointment")
    public List<Appointment> Appointment(){
        return appointmentRepository.findAll().stream().collect(Collectors.toList());
    }


    @GetMapping("/Period")
    public List<Period> Period(){
        return periodRepository.findAll().stream().collect(Collectors.toList());
    }

    

    @PostMapping(path = "/Appointment/{nameOwnerSelect}/{namePetSelect}/{nameDoctorSelect}/{date}/{periodsSelect}/{note}/{nameNurseSelect}")
    @CrossOrigin(origins = "http://localhost:4200")
    public Appointment appointment(
            @PathVariable Long nameOwnerSelect,
            @PathVariable Long namePetSelect,
            //@PathVariable Long telOwnerSelect,
            @PathVariable Long nameDoctorSelect,
            @PathVariable Date date,
            @PathVariable Long periodsSelect,
            @PathVariable String note,
            @PathVariable Long nameNurseSelect) {

        Owner owner = ownerRepository.findByOwnerId(nameOwnerSelect);
        //Owner owner1 = ownerRepository.findById(telOwnerSelect).get();
        PetInfo petInfo = petInfoRepository.findByPetId(namePetSelect);
        Doctor doctor = doctorRepository.findByDoctorId(nameDoctorSelect);
        Nurse nurse = nurseRepository.findByNurseId(nameNurseSelect);
        Period period = periodRepository.findByPeriodId(periodsSelect);


        Appointment appointment = new Appointment();
        appointment.setOwner(owner);
        appointment.setPetInfo(petInfo);
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
