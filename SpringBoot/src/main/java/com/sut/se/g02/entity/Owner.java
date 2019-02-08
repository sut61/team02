package com.sut.se.g02.entity;
import javax.persistence.*;
import lombok.*;
import javax.validation.constraints.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.ArrayList;
import java.util.List;

@Getter @Setter
@Entity
@Data
@Table(name = "owner")
public class Owner {
    @Id
    @SequenceGenerator(name="owner_seq",sequenceName="owner_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="owner_seq")
    @Column(name="OWNER_ID")
    @NotNull
    private  Long ownerId;



    @NotNull
    @Pattern(regexp = "[ก-๛\\s\\t]+")
    @Size(min = 1, max = 30 )
    private @NotNull String ownerName;

    @NotNull
    @Size(min=1,max=10)
    @Pattern(regexp = "[0-9]+")
    private String ownerTel;



    public void setOwner(String ownerName){
        this.ownerName=ownerName;
    }
    public String getOwner(){return ownerName; }

    public Owner() {}
    public Owner( String ownerName,String ownerTel) {
        this.ownerName=ownerName;
        this.ownerTel=ownerTel;


    }
}