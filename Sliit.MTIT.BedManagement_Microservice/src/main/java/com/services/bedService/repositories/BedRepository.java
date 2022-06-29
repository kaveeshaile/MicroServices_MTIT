package com.services.bedService.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.services.bedService.beans.Bed;

public interface BedRepository extends JpaRepository<Bed, Integer>{

}
