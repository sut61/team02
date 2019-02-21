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

@Getter @Setter
@Entity
@Data
@Table(name = "Serve")
public class Serve {
    @Id
    @SequenceGenerator(name="serve_seq",sequenceName="serve_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="serve_seq")
    @Column(name="Serve_ID")

    @NotNull
    private  Long serveId;

    @NotNull
    @Pattern(regexp = "[-0-9ก-๛]+")
    @Size(min = 1, max = 30 )
    private String comment;


    public Serve() {
    }
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "Nurse_ID", insertable = true)
    @NotNull
    private  Nurse nurse;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "OWNER_ID", insertable = true)
    @NotNull
    private  Owner owner;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name= "IdType",insertable = true)
    @NotNull
    private Type type;


    public void setComment(String comment){this.comment=comment;}
    public String getComment(){return comment;}
    public void setOwner(Owner owner){
        this.owner = owner;
    }
    public Owner getOwner() {
        return owner;
    }
    public void setNurse(Nurse nurse){this.nurse=nurse;}
    public Nurse getNurse() { return nurse; }
    public void setType(Type type){this.type=type;}
    public Type getType(){return type;}



    public Serve(String comment, Nurse nurse,  Type type,Owner owner) {

        this.comment=comment;
        this.owner=owner;
        this.nurse=nurse;

        this.type=type;



    }
}

