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
@Table(name = "PayInfo")
public class PayInfo {
    @Id
    @SequenceGenerator(name="payInfo_seq",sequenceName="payInfo_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="payInfo_seq")
    @Column(name="PayInfo_ID")
    private @NotNull Long id;
    private @NotNull Timestamp dateandtime;
    
    @NotNull
    @Pattern(regexp = "[-a-zA-Z0-9ก-๛\\s\\t]+")
    @Size(min = 1, max = 30 )
    private  String note;
    
    public PayInfo() {}


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "Nurse_ID", insertable = true)
    private  Nurse nurse;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "OWNER_ID", insertable = true)
    private  Owner owner;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "Treatment_ID", insertable = true)
    private  Treatment treatment;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "Medicine_ID", insertable = true)
    private  Medicine medicine;


    public void setDateandtime(Timestamp dateandtime) {
        this.dateandtime = dateandtime;
    }
    public Timestamp getDateandtime() {
        return dateandtime;
    }


    public void setNote(String note) {
        this.note = note;
    }
    public String getNote() {
        return note;
    }

    /*public void setSum(Integer sum) {
        this.sum = sum;
    }
    public Integer getSum() {
        return sum;
    }
*/
    public void setOwner(Owner owner){
        this.owner = owner;
    }
    public Owner getOwner() { 
        return owner; 
    }

   public void setTreatment(Treatment treatment){
        this.treatment = treatment;
    }
    public Treatment getTreatment() { 
        return treatment; 
    } 

    public void setNurse(Nurse nurse){
        this.nurse = nurse;
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

    public PayInfo (Long id, Timestamp dateandtime, Owner owner, Treatment treatment, Medicine medicine,String note,  Nurse nurse){
            this.dateandtime = dateandtime;
            this.owner = owner;
            this.treatment = treatment;
            this.medicine = medicine;
            this.note = note;
            this.nurse = nurse;
            
        }




}
