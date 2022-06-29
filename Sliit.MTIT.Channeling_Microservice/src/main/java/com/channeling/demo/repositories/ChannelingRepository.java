package com.channeling.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.channeling.demo.beans.Channelling;

public interface ChannelingRepository extends JpaRepository<Channelling, Integer>
{

	
}
