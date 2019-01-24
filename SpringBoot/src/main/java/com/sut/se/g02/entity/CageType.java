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
@Table(name = "CageType")
public class CageType {
	@Id
	@SequenceGenerator(name="cageType_seq",sequenceName="cageType_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="cageType_seq")
    @Column(name="idCageType")
	private @NonNull Long id;
	private  String nameCageType;
	


	public CageType(){

    }

    public CageType(Long id,String nameCageType){
        this.nameCageType = nameCageType;
        
    }


	public String getNameCageType() {
		return nameCageType;
	}

	public void setNameCageType(String nameCageType) {
		this.nameCageType = nameCageType;
	}



}
