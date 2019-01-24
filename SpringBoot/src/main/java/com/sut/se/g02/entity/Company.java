package com.sut.se.g02.entity;

import lombok.*;

import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.SequenceGenerator;
import javax.persistence.GenerationType;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import java.util.List;
import javax.persistence.*;

@Entity
@Data
@Table(name = "Company")
public class Company {
	@Id
	@SequenceGenerator(name="company_seq",sequenceName="company_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="company_seq")
    @Column(name="idCompany")
	private @NonNull Long id;
	private  String nameCompany;



	public Company(){

    }

    public Company(Long id, String nameCompany){
        this.nameCompany = nameCompany;

    }


	public String getNameCompany() {
		return nameCompany;
	}

	public void setNameCompany(String nameCompany) {
		this.nameCompany = nameCompany;
	}


}
