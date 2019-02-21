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
import java.sql.Timestamp;

import java.util.List;

@RestController 
@CrossOrigin(origins = "http://localhost:4200")
public class MoveController {
    @Autowired
    private MoveRepository moveRepository;
    @Autowired
    private RecuperateRepository recuperateRepository;
    @Autowired
    private OwnerRepository ownerRepository;
    @Autowired
    private CageRepository cageRepository;
    
    @Autowired
    private NurseRepository nurseRepository;



    @GetMapping("/Move")
    public List<Move> Move(){
        return moveRepository.findAll().stream().collect(Collectors.toList());
    }


    @PostMapping(path ="/Move/{recSelect}/{nameOwnerSelect}/{nameCageSelect}/{date}/{note}/{nameNurseSelect}")
    @CrossOrigin(origins = "http://localhost:4200")
    public Move move(
                                      
                                            @PathVariable  Long recSelect,
                                            @PathVariable Long nameOwnerSelect,
                                            @PathVariable  Long nameCageSelect,
                                            
                                          
                                            
                                            
                                            @PathVariable  Date date,
                                            @PathVariable  String note,
                                            @PathVariable  Long nameNurseSelect){

            Recuperate recuperate = recuperateRepository.findByRecuperateId(recSelect);
            Owner owner = ownerRepository.findByOwnerId(nameOwnerSelect);
            Cage cage = cageRepository.findByCageId(nameCageSelect);
            
            
            Nurse nurse = nurseRepository.findByNurseId(nameNurseSelect);
        
        Move move = new Move();
        move.setRecuperate(recuperate);
        move.setOwner(owner);
        move.setCage(cage);
        
        
      move.setDate(date);
       move.setNote(note);
        move.setNurse(nurse);

        moveRepository.save(move);
        return move;
    } 

    

}