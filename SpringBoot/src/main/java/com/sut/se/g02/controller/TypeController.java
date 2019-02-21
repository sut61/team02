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
public class TypeController {
    @Autowired
    private TypeRepository typeRepository;



    @GetMapping("/Type")
    public List<Type> Type(){
        return typeRepository.findAll().stream().collect(Collectors.toList());
    }


    

}