package com.sut.se.g02.entity;

import lombok.*;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.SequenceGenerator;
import javax.persistence.GenerationType;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.validation.constraints.NotNull;

@Entity
@Data
@Table(name = "Status1")
public class Status1 {
    @Id
    @SequenceGenerator(name="status1_seq",sequenceName="status1_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="status1_seq")
    @Column(name="Status1_ID")
    @NotNull private Long statusId;
    @NotNull private  String status1;

    public Status1(){
    }

    public Status1 (Long statusId,String status1){
        this.status1 = status1;
    }

    public String getStatus1() {
        return status1;
    }

    public void setStatus1(String status1) {
        this.status1 = status1;
    }
}
