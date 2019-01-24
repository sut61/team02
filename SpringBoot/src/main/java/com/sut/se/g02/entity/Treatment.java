package com.sut.se.g02.entity;



import lombok.*;
import javax.persistence.Id;
import javax.persistence.*;
import javax.persistence.GenerationType;
import java.awt.*;
import java.util.Date;
import java.sql.Timestamp;

import java.util.List;

@Data
@Entity
@Table(name = "treatment")
public class Treatment {
    @Id
    @SequenceGenerator(name = "treatment_seq",sequenceName = "treatment_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "treatment_seq")

    private @NonNull   Long id;
    private @NonNull Timestamp date;
    private @NonNull String symptom;
    //private @NonNull Integer amountMed;
    private @NonNull Integer dCon;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "IDDoctor",insertable = true)
    private Doctor doctor;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "IDPetInfo",insertable = true)
    private PetInfo petInfo;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "IDOwner",insertable = true)
    private Owner owner;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "IDMedicine",insertable = true)
    private Medicine medicine;





    public Treatment(){}

    public Treatment(Long id,Timestamp date,String symptom,Integer dCon,Doctor doctor,Owner owner,Medicine medicine){

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

    /*public void setAmountMed(Integer amountMed){
        this.amountMed = amountMed;
    }
    public Integer getAmountMed(){
        return amountMed;
    }*/
    
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
