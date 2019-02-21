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
import javax.validation.constraints.*;
import java.util.List;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Collection;


@Entity
@Data
@Table(name = "Recuperate")
public class Recuperate {
	@Id
	@SequenceGenerator(name="recuperate_seq",sequenceName="recuperate_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="recuperate_seq")
	@Column(name="idRecuperate")
	@NotNull
    private   Long recuperateId;
    @NotNull
    private   Timestamp date;
    
    @NotNull
    @Pattern(regexp = "[-a-zA-Z]+")
    @Size(min = 1, max = 20 )
	private String note;


	
	

	public Recuperate(){

    }

    

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "Treatment_ID", insertable = true)
    @NotNull
    private  Treatment treatment;

   @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "IDCage",insertable = true)
    @NotNull
    private  Cage cage;

 
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "IDCageType",insertable = true)
    @NotNull
    private  CageType cageType;

   @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "IDNurse",insertable = true)
    @NotNull
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

    public void setNote(String note){
		this.note=note;
	}
    public String getNote() { 
    	return note; 
    }

    


	public Recuperate (Long id,Cage cage,Timestamp date,CageType cageType, Treatment treatment,String note,
		  Nurse nurse){
	 		
			this.cage = cage;
			this.date = date;
	 		this.cageType = cageType;
	 		this.treatment = treatment;
	 		this.note = note;
			this.nurse = nurse;
		}


}
