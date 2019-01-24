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
@Table(name = "Doctor")
public class Doctor {
	@Id
	@SequenceGenerator(name="doctor_seq",sequenceName="doctor_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="doctor_seq")
    @Column(name="Doctor")
	private @NonNull Long doctorId;
	private @NonNull String nameDoctor;
	private String passwordDoctor;

	public Doctor() {}

    public Doctor (Long doctorId, String nameDoctor, String passwordDoctor){
        this.nameDoctor = nameDoctor;
        this.passwordDoctor = passwordDoctor;
    }


	public void setNameDoctor(String nameDoctor) {
		this.nameDoctor = nameDoctor;
	}
	public String getNameDoctor() {
		return nameDoctor;
	}

	
	public void setPasswordDoctor(String passwordDoctor) {
		this.passwordDoctor = passwordDoctor;
	}

	public String getPasswordDoctor() {
		return passwordDoctor;
	}
}
