package com.sut.se.g02.entity;

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
@Table(name="Medicine")
public class Medicine {

		@Id
        @SequenceGenerator(name = "med_seq",sequenceName = "med_seq")
        @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "med_seq")
        @Column(name = "Medicine_ID")
        private @NonNull Long medicineId;
        private @NonNull String nameMed;
        private @NonNull Integer amountMed;
        private @NonNull String type;
        private @NonNull Integer price;
        

    public Medicine(){}

    public Medicine(Long medicineId,String nameMed,Integer amountMed,String type,Integer price){
        
        this.nameMed = nameMed;
        this.amountMed = amountMed;
        this.type = type;
        this.price = price;
        
    }
    public void setNameMed(String nameMed){
        this.nameMed = nameMed;
    }
    public String getNameMed(){
        return nameMed;
    }

    public void setAmountMed(Integer amountMed){
        this.amountMed = amountMed;
    }
    public Integer getAmountMed(){
        return amountMed;
    }

    public void setType(String type){
        this.type = type;
    }
    public String getType(){
        return type;
    }

    public void setPrice(Integer price){
        this.price = price;
    }
    public Integer getPrice(){
        return price;
    }
}

