package com.se.lab4.demo;

import lombok.*;

import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Entity;

import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.GenerationType;
import javax.persistence.*;

@Entity
@Data
@Table(name="Treatment")
public class Treatment {
    @Id
    @SequenceGenerator(name = "treatment_seq",sequenceName = "treatment_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "treatment_seq")
    private @NonNull Long id;
    private @NonNull String name;

    public Treatment() {}

    public Treatment(Long id,String name) {

        this.name = name;

    }


    public void setName(String name) {

        this.name = name;
    }
    public String getName() {
        return name;
    }


}