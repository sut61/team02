package com.sut.sa.g10.entity;

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
@Table(name = "PaymentInform")
public class PaymentInform {
	@Id
	private @NonNull Long id;

	public PaymentInform() {}

    public PaymentInform (Long id){
        
    }

	
}
