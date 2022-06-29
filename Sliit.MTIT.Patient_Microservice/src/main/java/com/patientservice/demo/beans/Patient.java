package com.patientservice.demo.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="patient")
public class Patient {

	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getDisease() {
		return disease;
	}
	public void setDisease(String disease) {
		this.disease = disease;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	public Patient(){
		
		
	}
	
	
	public Patient(int id, String pname, String address, String disease, int age) {
		super();
		this.id = id;
		this.pname = pname;
		this.address = address;
		this.disease = disease;
		this.age = age;
	}
	
	@Id
	@Column(name="id")
	
	int id;
	
	@Column(name="pname")
	String pname;
	
	@Column(name="address")
	String address;
	
	@Column(name="disease")
	String disease;
	
	@Column(name="age")
	int age;
	
	
	
	
	
	
}
