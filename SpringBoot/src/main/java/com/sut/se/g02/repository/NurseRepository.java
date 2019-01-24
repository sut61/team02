package com.sut.se.g02.repository;

import com.sut.se.g02.entity.Nurse;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public
interface NurseRepository extends JpaRepository<Nurse, Long> {
	Nurse findByNameNurse(String nameNurse);
	Nurse findByPasswordNurse(String passwordNurse);
}