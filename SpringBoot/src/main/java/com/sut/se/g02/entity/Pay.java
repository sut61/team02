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
@Table(name = "Pay")
public class Pay {
	@Id
	@SequenceGenerator(name="pay_seq",sequenceName="pay_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="pay_seq")
    @Column(name="Pay_ID")
	private @NotNull Long id;
	private @NotNull Timestamp dateandtime;

    @NotNull
    @Pattern(regexp = "[-a-zA-Z0-9ก-๛\\s\\t]+")
    @Size(min = 1, max = 30 )
    private  String note;
	
	public Pay() {}


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



    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "PayInfo_ID", insertable = true)
    private  PayInfo payInfo;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "StatusPay_ID", insertable = true)
    private  StatusPay statusPay;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "Nurse_ID", insertable = true)
    private  Nurse nurse;

    
    
    public void setPayInfo(PayInfo payInfo){
        this.payInfo = payInfo;
    }
    public PayInfo getPayInfo() { 
        return payInfo; 
    }

    public void setStatusPay(StatusPay statusPay){
        this.statusPay = statusPay;
    }
    public StatusPay getStatusPay() { 
        return statusPay; 
    }

    public void setNurse(Nurse nurse){
        this.nurse = nurse;
    }
    public Nurse getNurse() { 
        return nurse; 
    }


    

    public Pay (Long id, Timestamp dateandtime, PayInfo payInfo, StatusPay statusPay, String note,  Nurse nurse){
            this.dateandtime = dateandtime;
            this.payInfo = payInfo;
            this.statusPay = statusPay;
            this.note = note;
            this.nurse = nurse;
            
        }

}
