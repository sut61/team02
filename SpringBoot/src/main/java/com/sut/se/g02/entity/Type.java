package com.sut.se.g02.entity;
import javax.validation.constraints.*;
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
@Table(name = "Type")
public class Type {
    @Id
    @SequenceGenerator(name="type_seq",sequenceName="type_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="type_seq")
    @Column(name="Type")
    @NotNull
    private  Long typeId;

    @NonNull
    private String List;




    public Type() {}

    public Type (Long typeId, String List){
        this.List = List;

    }


    public void setList(String List) {
        this.List = List;
    }
    public String getList() {
        return List;
    }



}
