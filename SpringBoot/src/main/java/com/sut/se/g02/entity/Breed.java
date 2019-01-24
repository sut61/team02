package com.sut.se.g02.entity;
import javax.persistence.*;
import lombok.*;
@Getter @Setter
@Entity
@Data
@Table(name="Breed")
public class Breed {
    @Id
    @SequenceGenerator(name="BREED_seq",sequenceName="BREED_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="BREED_seq")
    @Column(name = "IdBreed")
    private @NonNull Long iD;
    private@NonNull String type;
    public void setBreedName(String type){
        this.type=type;
    }
    public String getBreedName(){
        return type;
    }


    public Breed() {}
    public Breed(String type ) {
        this.type=type;

    }

}
