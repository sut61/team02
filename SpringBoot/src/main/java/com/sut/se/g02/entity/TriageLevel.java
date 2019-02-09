package com.sut.se.g02.entity;

import lombok.*;

import javax.persistence.*;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import javax.persistence.Column;
import javax.persistence.Entity;

@Data
@Entity
@Table(name="TriageLevel")
public class TriageLevel {
	@Id
	@SequenceGenerator(name="triagelevel_seq",sequenceName="triagelevel_seq")       
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="triagelevel_seq")      
	@Column(name="TriageLevel_ID")

	private @NotNull Long levelId;
	private @NotNull String levelName;
	

	public TriageLevel(){}
	public TriageLevel(Long levelId, String levelName){
		
		this.levelName = levelName;
	}

	public void setLevelName(String levelName){
		this.levelName = levelName;
	}

	public String getLevelName(){
		return levelName;
	}

	

}
