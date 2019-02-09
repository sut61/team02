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
@Table(name = "CancelApp")
public class CancelApp {
    @Id
    @SequenceGenerator(name="cancel_seq",sequenceName="cancel_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="cancel_seq")
    @Column(name="CancelApp_ID")
    @NotNull
    private Long id;
    @NotNull
    @Size (min=1,max=40)
    @Pattern(regexp = "[-a-zA-Z0-9ก-๛\\s\\t]+")
    private String note;
    public CancelApp(){
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "IDStatus1",insertable = true)
    private  Status1 status1;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "IDAppointment",insertable = true)
    private   Appointment appointment;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "IDNurse",insertable = true)
    private   Nurse nurse;


    public void setNote(String note){
        this.note = note;
    }

    public String getNote(){
        return note;
    }

    public void setAppointment(Appointment appointment){
        this.appointment = appointment;
    }
    public Appointment getAppointment() {
        return appointment;
    }

    public void setStatus1(Status1 status1){
        this.status1=status1;
    }
    public Status1 getStatus1() {
        return status1;
    }

    public void setNurse(Nurse nurse){
        this.nurse=nurse;
    }
    public Nurse getNurse() {
        return nurse;
    }

    public CancelApp (Long id,Status1 status1,String note,
                        Nurse nurse,Appointment appointment){

        this.status1 = status1;
        this.note = note;
        this.nurse = nurse;
        this.appointment = appointment;
    }
}
