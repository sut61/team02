package com.sut.se.g02.entity;
import javax.persistence.*;
import lombok.*;
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
    private @NonNull Long ownerId;
    private @NonNull String OwnerPet;
    private @NonNull String ownerName;
    private @NonNull String ownerTel;



    public void setOwner(String ownerName,String OwnerPet){
        this.OwnerPet = OwnerPet;
        this.ownerName=ownerName;
    }
    public String getOwner(){return ownerName; }
    
    public Owner() {}
    public Owner( String ownerName,String ownerTel,String OwnerPet ) {
        this.ownerName=ownerName;
        this.OwnerPet=OwnerPet;

        this.ownerTel=ownerTel;


    }
}