package com.patientservice.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.patientservice.demo.beans.Patient;

public interface PatientRepository extends JpaRepository<Patient, Integer> {

}
