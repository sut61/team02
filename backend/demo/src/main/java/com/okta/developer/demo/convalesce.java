package com.sut.sa.cpe.entity;

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
@Table(name = "Nurse")
public class Nurse {
	@Id
	@SequenceGenerator(name="nurse_seq",sequenceName="nurse_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="nurse_seq")
    @Column(name="idNurse")
    private @NonNull Long id;
	
	private @NonNull String nameNurse;
	

	public Nurse() {}

    public Nurse (Long id,String nameNurse){
        this.nameNurse = nameNurse;
       
    }

	public String getnameNurse() {
		return nameNurse;
	}

	public void setnameNurse(String nameNurse) {
		this.nameNurse = nameNurse;
	}


}
