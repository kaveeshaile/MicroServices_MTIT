package com.Staff.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Staff.demo.beans.Staff;

public interface StaffRepository extends JpaRepository< Staff , Integer> {

}
