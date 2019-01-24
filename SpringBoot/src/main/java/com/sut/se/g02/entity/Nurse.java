package com.sut.se.g02.entity;

import lombok.*;

import javax.persistence.*;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import javax.persistence.Column;
import javax.persistence.Entity;

@Data
@Entity
@Table(name="Nurse")
public class Nurse {
	@Id
	@SequenceGenerator(name="nurse_seq",sequenceName="nurse_seq")       
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="nurse_seq")      
	@Column(name="Nurse_ID")
	private @NonNull Long nurseId;
	private @NonNull String nameNurse;
	private String passwordNurse;

	public Nurse(){}
	public Nurse(Long nurseId, String nameNurse, String passwordNurse){
		this.nameNurse = nameNurse;
		this.passwordNurse = passwordNurse;
	}

	public void setNameNurse(String nameNurse){
		this.nameNurse = nameNurse;
	}

	public String getNameNurse(){
		return nameNurse;
	}

	public void setPasswordNurse(String passwordNurse){
		this.passwordNurse = passwordNurse;
	}

	public String getPasswordNurse(){
		return passwordNurse;
	}

}
