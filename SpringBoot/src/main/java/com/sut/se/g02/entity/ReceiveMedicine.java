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

import javax.validation.constraints.*;


@Getter@Setter
@Entity
@Data
@Table(name = "ReceiveMedicine")
public class ReceiveMedicine {
    @Id
    @SequenceGenerator(name="receiveMedicine_seq",sequenceName="receiveMedicine_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="receiveMedicine_seq")
    @Column(name="idReceiveMedicine")
    private @NotNull Long id;

    @Pattern(regexp = "[-0-9ก-๛]+")
    @Size (min = 1,max = 30)
    private @NotNull String noteNew;


    public void setNoteNew(String noteNew){

        this.noteNew = noteNew;
    }
    public String getNoteNew() {
        return noteNew;
    }


    public ReceiveMedicine(){

    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "IDCheckStatus",insertable = true)
    private CheckStatus checkStatus;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "IDNurse",insertable = true)
    private Nurse nurse;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "IDOrderMedicine",insertable = true)
    private OrderMedicine orderMedicine;

    public void setOrderMedicine(OrderMedicine orderMedicine) {
        this.orderMedicine = orderMedicine;
    }

    public OrderMedicine getOrderMedicine() { return orderMedicine; }
    public void setCheckStatus(CheckStatus checkStatus){

        this.checkStatus = checkStatus;
    }
    public CheckStatus getCheckStatus() {

        return checkStatus;
    }

    public void setNurse(Nurse nurse){
        this.nurse=nurse;
    }
    public Nurse getNurse() {
        return nurse;
    }



    public ReceiveMedicine(Long id,CheckStatus checkStatus, String noteNew,
                         Nurse nurse, OrderMedicine orderMedicine){
        this.orderMedicine = orderMedicine;
        this.checkStatus = checkStatus;
        this.noteNew = noteNew;
        this.nurse = nurse;
    }

}
