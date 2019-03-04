package com.sut.se.g02.entity;

import lombok.*;
import javax.persistence.Id;
import javax.persistence.*;
import javax.persistence.GenerationType;
import java.awt.*;
import java.util.Date;
import java.sql.Timestamp;

import java.util.List;
import javax.validation.constraints.*;

@Data
@Entity
@Table(name = "treatment")
public class Treatment {
    @Id
    @SequenceGenerator(name = "treatment_seq",sequenceName = "treatment_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "treatment_seq")
    @Column(name="Treatment_ID",unique = true, nullable = false)
    @NotNull  
    private  Long treatmentId;

    @NotNull
    private  Timestamp date;

    @NotNull
    @Size(min=1,max=30)
    @Pattern(regexp="[a-zA-Z0-9ก-๛\\s\\t]+") 
    private String symptom;
    

    @NotNull
    private  Integer dCon;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "IDDoctor",insertable = true)
    @NotNull
    private Doctor doctor;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "IDPetInfo",insertable = true)
    @NotNull
    private PetInfo petInfo;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "IDOwner",insertable = true)
    @NotNull
    private Owner owner;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "IDMedicine",insertable = true)
    @NotNull
    private Medicine medicine;





    public Treatment(){}

    public Treatment(Long treatmentId,Timestamp date,String symptom,Integer dCon,Doctor doctor,Owner owner,Medicine medicine){

        this.date = date;
        this.symptom = symptom;
        this.dCon = dCon;
        this.doctor =  doctor;
        this.owner = owner;
        this.medicine = medicine;
    }


    public void setDate(Timestamp date){
        this.date = date;
    }
    public Timestamp getDate(){
        return date;
    }

    public void setSymptom(String symptom){
        this.symptom = symptom;
    }
    public String getSymptom(){
        return symptom;
    }

    
    
    public void setDCon(Integer dCon){
        this.dCon = dCon;
    }
    public Integer getDCon(){
        return dCon;
    }
    public void setDoctor(Doctor doctor) {this.doctor = doctor;}
    public Doctor getDoctor(){ return doctor;}

    public void setPetInfo(PetInfo petInfo){ this.petInfo = petInfo;}
    public PetInfo getPetInfo(){ return petInfo; }

    public void setOwner (Owner owner) { this.owner = owner;}
    public Owner getOwner() {return owner;}

     public void setMedicine (Medicine medicine) { this.medicine = medicine;}
    public Medicine getMedicine() {return medicine;}

}
