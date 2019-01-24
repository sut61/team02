package com.sut.se.g02.entity;

import lombok.*;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.SequenceGenerator;
import javax.persistence.GenerationType;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;

@Entity
@Data
@Table(name = "Period")

public class Period {
    @Id
    @SequenceGenerator(name="period_seq",sequenceName="period_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="period_seq")
    @Column(name="idPeriod")
    private @NonNull Long id;
    private @NonNull String periods;

    public Period(){
    }

    public Period (Long id,String periods){
        this.periods = periods;
    }

    public String getPeriods() {
        return periods;
    }

    public void setPeriods(String periods) {
        this.periods = periods;
    }
}

