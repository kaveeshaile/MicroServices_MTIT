package com.hospitalstores.demo.PharmacyService.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hospitalstores.demo.PharmacyService.beans.Pharmacy;



public interface pharmacyRepository extends JpaRepository<Pharmacy,Integer>{

}
