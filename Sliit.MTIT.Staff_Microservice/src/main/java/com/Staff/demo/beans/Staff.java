package com.Staff.demo.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="staff_management")
public class Staff {
	@Id
	@Column(name ="SID")
	int id;
	@Column(name ="Staff_Name")
	String Staff_Name;
	@Column(name ="Age")
	String Age;
	@Column(name ="Email")
	String Email;
	@Column(name ="Address")
	String Address;
	
	@Column(name ="Position")
	String Position;
	
	@Column(name ="working_experience")
	int working_experience;
	
	@Column(name ="Starting_date")
	String Starting_date;

	public Staff() {
		
		
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return Staff_Name;
	}

	public void setName(String name) {
		this.Staff_Name = name;
	}

	public String getAge() {
		return Age;
	}

	public void setAge(String age) {
		Age = age;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public String getPosition() {
		return Position;
	}

	public void setPosition(String position) {
		Position = position;
	}

	public int getWorking_experience() {
		return working_experience;
	}

	public void setWorking_experience(int working_experience) {
		this.working_experience = working_experience;
	}

	public String getStarting_date() {
		return Starting_date;
	}

	public void setStarting_date(String starting_date) {
		Starting_date = starting_date;
	}
	
	
	
}
 