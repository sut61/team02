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
@Table(name = "Move")
public class Move {
	@Id
	@SequenceGenerator(name="move_seq",sequenceName="move_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="move_seq")
	@Column(name="idMove")
    @NotNull
	private  Long id;

    private  Date date;

    @NotNull
    @Pattern(regexp="[a-zA-Zก-๛]+")
    @Size(min = 1, max = 20 )
	private String note;

	public Move(){

    }

    

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "Recuperatet_ID", insertable = true)
    private  Recuperate recuperate;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "IDOwner",insertable = true)
    private Owner owner;

   @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "IDCage",insertable = true)
    private  Cage cage;

 
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "IDCageType",insertable = true)
    private  CageType cageType;

   @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "IDNurse",insertable = true)
    private  Nurse nurse;

	

	public void setDate(Date date) {
		this.date = date;
	}

	public Date getDate(){
		return date;
	}

	
   public void setRecuperate(Recuperate recuperate){
        this.recuperate = recuperate;
    }
    public Recuperate getRecuperate() { 
        return recuperate; 
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

    public void setNote(String note){
		this.note=note;
	}
    public String getNote() { 
    	return note; 
    }

    public void setNurse(Nurse nurse){
		this.nurse=nurse;
	}
    public Nurse getNurse() { 
    	return nurse; 
    }

    public void setOwner (Owner owner) {
	}
    public Owner getOwner() {
    	return owner;
    }

    


	public Move (Long id,Recuperate recuperate,Owner owner,Cage cage,CageType cageType,Date date, String note,
		  Nurse nurse){
	 		this.recuperate = recuperate;
            this.owner = owner;
			this.cage = cage;
			
	 		this.cageType = cageType;
	 		this.date = date;
	 		this.note = note;
			this.nurse = nurse;
			
		}


}
