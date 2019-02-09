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

    @GetMapping(path = "Serve", produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<Serve> Serve() {
        return serveRepository.findAll().stream().collect(Collectors.toList());
    }

    @GetMapping("/Serve/{id}")
    public Optional<Serve> serve(@PathVariable Long id)  {
        Optional<Serve> serve = serveRepository.findById(id);
        return serve;
    }
    @PostMapping(path ="/Serve/{ownerNameSelect}/{TypeList}/{nameNurseSelect}/{comment}")
    @CrossOrigin(origins = "http://localhost:4200")
    public Serve serve(
            @PathVariable  Long ownerNameSelect,
            @PathVariable  Long TypeList,
            @PathVariable  Long nameNurseSelect,
             @PathVariable  String comment

    ){



        Owner owner = ownerRepository.findById(ownerNameSelect).get();
        Type type = typeRepository.findById(TypeList).get();
        Nurse nurse = nurseRepository.findById(nameNurseSelect).get();




        Serve serve = new Serve();
        serve.setOwner(owner);
        serve.setType(type);
        serve.setNurse(nurse);
        serve.setComment(comment);

        serveRepository.save(serve);
        return serve;
    }

}