package com.sut.se.g02.controller;
import lombok.Data;
import org.springframework.http.MediaType;
import com.sut.se.g02.entity.*;

import com.sut.se.g02.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.print.Doc;
import java.util.Date;
import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ServeController {
    @Autowired
    private ServeRepository serveRepository;
    @Autowired
    private NurseRepository nurseRepository ;
    @Autowired
    private OwnerRepository ownerRepository;
    @Autowired
    private TypeRepository typeRepository;



    @GetMapping("/Serve")
    public List<Serve> Serve(){
        return serveRepository.findAll().stream().collect(Collectors.toList());
    }

    @PostMapping(path ="/Serve/{ownerNameSelect}/{TypeList}/{nameNurseSelect}/{comment}")
    @CrossOrigin(origins = "http://localhost:4200")
    public Serve serve(
            @PathVariable  Long ownerNameSelect,
            @PathVariable  Long TypeList,
            @PathVariable  Long nameNurseSelect,
             @PathVariable  String comment

    ){



        Owner owner = ownerRepository.findByOwnerId(ownerNameSelect);
        Type type = typeRepository.findByTypeId(TypeList);
        Nurse nurse = nurseRepository.findByNurseId(nameNurseSelect);




        Serve serve = new Serve();
        serve.setOwner(owner);
        serve.setType(type);
        serve.setNurse(nurse);
        serve.setComment(comment);

        serveRepository.save(serve);
        return serve;
    }

}