package com.sut.sa.g10.entity;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.GenerationType;
import lombok.*;

@Entity
@Data
@Table(name = "Medicine")

public class Medicine {
    @Id
    @SequenceGenerator(name="medicine_seq",sequenceName="medicine_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="medicine_seq")
    @Column(name="IdMedicine")
    private @NonNull Long id;
    private  String nameMedicine;
    private  String typeMedicine;

    public Medicine(){}
    public Medicine(Long id, String nameMedicine, String typeMedicine) {
        this.nameMedicine = nameMedicine;
        this.typeMedicine = typeMedicine;
    }

    public void setNameMedicine(String nameMedicine){
        this.nameMedicine = nameMedicine;
    }
    public String getNameMedicine(){
        return nameMedicine;
    }
    public void setTypeMedicine(String typeMedicine){
        this.typeMedicine = typeMedicine;
    }
    public String getTypeMedicine(){
        return typeMedicine;
    }
}

