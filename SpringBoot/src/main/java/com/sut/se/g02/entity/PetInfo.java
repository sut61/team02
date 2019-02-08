package com.sut.se.g02.entity;
import javax.persistence.*;
import lombok.*;
import javax.validation.constraints.*;
import java.util.Date;
@Getter @Setter
@Entity
@Data
@Table(name = "PetInfo")
public class PetInfo {
    @Id
    @SequenceGenerator(name="petinfo_seq",sequenceName="petinfo_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="petinfo_seq")
    @Column(name="PETINFO_ID")

    private  Long petId;

    @Size(min=1,max=20)
    @Pattern(regexp = "[ก-๛a-zA-Z]+")
    private @NotNull String petName;

    // @Size(min=1,max=5)
    //  @Pattern(regexp="\\d+")
    private @NotNull Double weight;

    // @Size(min=1,max=5)
    //  @Pattern(regexp="\\d+")
    private @NotNull Double height;

    // @Size(min=1,max=4)
    // @Pattern(regexp="\\d+")
    private @NotNull Integer age;


    public PetInfo() {
    }
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name= "IdOwner",insertable = true)
    private Owner Owner;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name= "IdBreed",insertable = true)
    private Breed breed;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name= "IdNurse",insertable = true)
    private Nurse nurse;

    public void setAge(Integer age){this.age=age;}
    public int getAge(){return age;}

    public void setWeight(Double weight){this.weight=weight;}
    public Double getWeight(){return weight;}

    public void setHeight(Double height){this.height=height;}
    public Double getheight(){return height;}

    public void setPetName(String petName){this.petName=petName;}
    public String getPetName(){return petName;}
    public void setNurse(Nurse nurse){this.nurse=nurse;}
    public Nurse getNurse() { return nurse; }
    public void setBreed(Breed breed){this.breed=breed;}
    public Breed getBreed(){return breed;}



    public PetInfo(String petName,Double height,Double weight,Integer age, Nurse nurse,  Breed breed,Owner owner) {

        this.age=age;
        this.Owner=owner;
        this.height=height;
        this.weight=weight;
        this.nurse=nurse;
        this.petName=petName;
        this.breed=breed;



    }
}

