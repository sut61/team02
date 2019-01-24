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

@Entity
@Data
@Table(name = "Appointment")
public class Appointment {
    @Id
    @SequenceGenerator(name="appointment_seq",sequenceName="appointment_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="appointment_seq")
    @Column(name="Appointment_ID")
    private @NonNull Long id;
    private  Date date;
    private  String note;

    public Appointment(){
    }


    @ManyToOne(fetch = FetchType.LAZY,  targetEntity = Doctor.class)
    @JoinColumn(name = "IDDoctor")
    private  Doctor doctor;


    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Period.class)
    @JoinColumn(name = "IDPeriod")
    private  Period period;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Owner.class)
    @JoinColumn(name = "IDOwner")
    private   Owner owner;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Nurse.class)
    @JoinColumn(name = "IDNurse")
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

    public Appointment (Long id,Doctor doctor,Date date,Period period,String note,
                             Nurse nurse,Owner owner){

        this.doctor = doctor;
        this.date = date;
        this.period = period;
        this.note = note;
        this.nurse = nurse;
        this.owner = owner;
    }

}
