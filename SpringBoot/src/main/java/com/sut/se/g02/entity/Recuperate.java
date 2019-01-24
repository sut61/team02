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
import java.util.List;
import java.util.Date;
import java.sql.Timestamp;
import javax.validation.constraints.NotNull;


@Entity
@Data
@Table(name = "Recuperate")
public class Recuperate {
	@Id
	@SequenceGenerator(name="appointmentsheet_seq",sequenceName="appointmentsheet_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="appointmentsheet_seq")
	@Column(name="idRecuperate")
	private @NonNull Long id;
	private  Timestamp date;
	

	public Recuperate(){

    }

    

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "Treatment_ID", insertable = true)
    private  Treatment treatment;

   @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "IDCage",insertable = true)
    private  Cage cage;

 
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "IDCageType",insertable = true)
    private  CageType cageType;

   @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "IDNurse",insertable = true)
    private  Nurse nurse;

	

	public void setDate(Timestamp date) {
		this.date = date;
	}

	public Timestamp getDate(){
		return date;
	}

	
   public void setTreatment(Treatment treatment){
        this.treatment = treatment;
    }
    public Treatment getTreatment() { 
        return treatment; 
    } 




	

    public void setCage(Cage cage){
		this.cage=cage;
	}
    public Cage getCage() { 
    	return cage; 
    }

   public void setCageType(CageType cageType){
		this.cageType=cageType;
	}
    public CageType getCageType() { 
    	return cageType; 
    } 

    public void setNurse(Nurse nurse){
		this.nurse=nurse;
	}
    public Nurse getNurse() { 
    	return nurse; 
    }

    


	public Recuperate (Long id,Cage cage,Timestamp date,CageType cageType, Treatment treatment,String note,
		  Nurse nurse){
	 		
			this.cage = cage;
			this.date = date;
	 		this.cageType = cageType;
	 		this.treatment = treatment;
			this.nurse = nurse;
		}


}
