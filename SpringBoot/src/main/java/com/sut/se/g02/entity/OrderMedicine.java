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

import javax.persistence.ManyToOne;


@Entity
@Data
@Table(name = "OrderMedicine")
public class OrderMedicine {
	@Id
	@SequenceGenerator(name="orderMedicine_seq",sequenceName="orderMedicine_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="orderMedicine_seq")
	@Column(name="idOrderMedicine")
	private @NonNull Long id;
	private  String note;
	private  Integer number;


	public OrderMedicine(){

    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "IDCompany",insertable = true)
    private Company company;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "IDNurse",insertable = true)
    private Nurse nurse;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "IDMedicine",insertable = true)
    private Medicine medicine;


	public void setNote(String note){
		this.note = note;
	}
	public String getNote(){
		return note;
	}
	public void setNumber(Integer number){
		this.number = number;
	}
	public Integer getNumber(){
		return number;
	}



	public void setCompany(Company company){
		this.company=company;
	}
    public Company getCompany() {
    	return company;
    }

    public void setNurse(Nurse nurse){
		this.nurse=nurse;
	}
    public Nurse getNurse() {
    	return nurse;
    }

   public void setMedicine(Medicine medicine){
		this.medicine = medicine;
	}
    public Medicine getMedicine() {
    	return medicine;
    } 



	public OrderMedicine(Long id,Company company, Medicine medicine, Integer number, String note,
						 Nurse nurse){
	 		this.company = company;
			this.medicine = medicine;
			this.number = number;
			this.note = note;
			this.nurse = nurse;
		}


}
