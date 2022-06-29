package com.channeling.demo.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name ="doc_channeling")
public class Channelling {
	@Id
	@Column(name ="UID")
	int id;
	@Column(name ="patient_name")
	String patient_name;
	@Column(name ="address")
	String address;
	@Column(name ="contact_num")
	String contact_num;
	@Column(name ="date")
	String date;
	@Column(name ="time")
	String time;
	@Column(name ="doc_name")
	String doc_name;
	@Column(name ="room_num")
	int room_num;
	
	
	public Channelling() {
		
		
	}
	public Channelling(int i, String string, String string2, String string3, String string4, String string5,
			String string6, String string7, int j) {
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPatient_name() {
		return patient_name;
	}
	public void setPatient_name(String patient_name) {
		this.patient_name = patient_name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getContact_num() {
		return contact_num;
	}
	public void setContact_num(String contact_num) {
		this.contact_num = contact_num;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getDoc_name() {
		return doc_name;
	}
	public void setDoc_name(String doc_name) {
		this.doc_name = doc_name;
	}
	public int getRoom_num() {
		return room_num;
	}
	public void setRoom_num(int room_num) {
		this.room_num = room_num;
	}
	
	
	

}
