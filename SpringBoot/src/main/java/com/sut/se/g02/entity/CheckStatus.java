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
@Table(name = "CheckStatus")
public class CheckStatus {
    @Id
    @SequenceGenerator(name="checkStatus_seq",sequenceName="checkStatus_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="checkStatus_seq")
    @Column(name="idCheckStatus")
    private @NonNull Long checkStatusId;
    private  String checkStatus;



    public CheckStatus(){

    }

    public CheckStatus(Long checkStatusId, String checkStatus){
        this.checkStatus = checkStatus;

    }


    public String getCheckStatus() {
        return checkStatus;
    }

    public void setCheckStatus(String checkStatus) {
        this.checkStatus = checkStatus;
    }


}
