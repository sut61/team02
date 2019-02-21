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
import java.util.List;
import javax.persistence.*;

@Entity
@Data
@Table(name = "StatusPay")
public class StatusPay {
	@Id
	@SequenceGenerator(name="statusPay_seq",sequenceName="statusPay_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="statusPay_seq")
    @Column(name="StatusPay_ID")
	private @NotNull Long statusPayId;
	private @NotNull String nameStatusPay;
	


	public StatusPay(){

    }

    public StatusPay(Long statusPayId,String nameStatusPay){
        this.nameStatusPay = nameStatusPay;
        
    }


	public String getNameStatusPay() {
		return nameStatusPay;
	}

	public void setNameStatusPay(String nameStatusPay) {
		this.nameStatusPay = nameStatusPay;
	}



}
