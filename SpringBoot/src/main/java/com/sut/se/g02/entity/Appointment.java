package com.sut.se.g02.entity;

import lombok.*;
import javax.persistence.Id;
import javax.persistence.*;
import javax.persistence.GeneratedValue;
import javax.persistence.SequenceGenerator;
import javax.persistence.GenerationType;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import java.util.Date;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Data
@Table(name = "Appointment")
public class Appointment {
    @Id
    @SequenceGenerator(name="appointment_seq",sequenceName="appointment_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="appointment_seq")
    @Column(name="Appointment_ID")
    @NotNull private Long id;
    @NotNull private  Date date;
    @NotNull
    @Size(min=1,max=40)
    @Pattern(regexp = "[-a-zA-Z0-9ก-๛\\s\\t]+")
    private  String note;

    public Appointment(){
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "IDDoctor", insertable = true)
    private  Doctor doctor;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "IDPetInfo", insertable = true)
    private  PetInfo petInfo;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "IDPeriod", insertable = true)
    private  Period period;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "IDOwner", insertable = true)
    private   Owner owner;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "IDNurse", insertable = true)
    private   Nurse nurse;

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getDate(){
        return date;
    }


    public void setNote(String note){
        this.note = note;
    }

    public String getNote(){
        return note;
    }

    public void setDoctor (Doctor doctor){
        this.doctor = doctor;
    }
    public Doctor getDoctor() {
        return doctor;
    }

    public void setPeriod(Period period){
        this.period=period;
    }
    public Period getPeriod() {
        return period;
    }

    public void setPetInfo(PetInfo petInfo){
        this.petInfo=petInfo;
    }
    public PetInfo getPetInfo() {
        return petInfo;
    }

    public void setOwner(Owner owner){
        this.owner=owner;
    }
    public Owner getOwner() {
        return owner;
    }

    public void setNurse(Nurse nurse){
        this.nurse=nurse;
    }
    public Nurse getNurse() {
        return nurse;
    }

    public Appointment (Long id,Doctor doctor,Date date,Period period,String note,PetInfo petInfo,
                        Nurse nurse,Owner owner){
        this.petInfo=petInfo;
        this.doctor = doctor;
        this.date = date;
        this.period = period;
        this.note = note;
        this.nurse = nurse;
        this.owner = owner;
    }

}
