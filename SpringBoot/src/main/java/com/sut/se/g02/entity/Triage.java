package com.sut.se.g02.entity;

import javax.persistence.*;
import lombok.*;
import java.util.Date;

import javax.validation.constraints.*;


@Getter @Setter
@Entity
@Data
@Table(name = "Triage")
public class Triage {
    @Id
    @SequenceGenerator(name="triage_seq",sequenceName="triage_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="triage_seq")
    @Column(name="Triage_ID",unique = true, nullable = false)
    @NotNull
    private   Long triageId;

    @NotNull
    @Size(min=1,max=30)
    @Pattern(regexp = "[-a-zA-Z0-9ก-๛\\s\\t]+")
    private String symptom;
    


    public Triage() {
    }
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name= "IdTriageLevel",insertable = true)
    @NotNull
    private TriageLevel triageLevel;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name= "IdPetInfo",insertable = true)
    @NotNull
    private PetInfo petInfo;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name= "IdNurse",insertable = true)
    @NotNull
    private Nurse nurse;

    
   
    public void setTriageLevel(TriageLevel triageLevel){this.triageLevel=triageLevel;}
    public TriageLevel getTriageLevel(){return triageLevel;}

    public void setPetInfo(PetInfo petInfo){this.petInfo=petInfo;}
    public PetInfo getPetInfo(){return petInfo;}

    public void setNurse(Nurse nurse){this.nurse=nurse;}
    public Nurse getNurse() { return nurse; }

    public void setSymptom(String symptom){this.symptom=symptom;}
    public String getSymptom(){return symptom;}

    



    public Triage(TriageLevel triageLevel,PetInfo petInfo,Nurse nurse,String symptom) {

        this.triageLevel=triageLevel;
        this.petInfo=petInfo;
        this.nurse=nurse;
        this.symptom=symptom;
        



    }
}

