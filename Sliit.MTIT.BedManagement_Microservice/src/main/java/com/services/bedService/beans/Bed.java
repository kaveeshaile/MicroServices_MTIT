package com.services.bedService.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Bed")
public class Bed {

	@Id
	@Column(name="bed_id")
	int bedID;
	
	@Column(name="bed_number")
	String bedNumber;
	
	@Column(name="bed_type")
	String bedType;
	
	@Column(name="bed_floor")
	int bedFloor;

	@Column(name="bed_room")
	String bedRoom;
	
	@Column(name="special_considerations")
	String specialConsiderations;
	
	//default constructor
	public Bed() {
	}

	//parameterized constructor
	public Bed(int bedID, int bedFloor, String bedNumber, String bedType, String bedRoom,
			String specialConsiderations) {
		super();
		this.bedID = bedID;
		this.bedFloor = bedFloor;
		this.bedNumber = bedNumber;
		this.bedType = bedType;
		this.bedRoom = bedRoom;
		this.specialConsiderations = specialConsiderations;
	}

	public int getBedID() {
		return bedID;
	}

	public void setBedID(int bedID) {
		this.bedID = bedID;
	}

	public int getBedFloor() {
		return bedFloor;
	}

	public void setBedFloor(int bedFloor) {
		this.bedFloor = bedFloor;
	}

	public String getBedNumber() {
		return bedNumber;
	}

	public void setBedNumber(String bedNumber) {
		this.bedNumber = bedNumber;
	}

	public String getBedType() {
		return bedType;
	}

	public void setBedType(String bedType) {
		this.bedType = bedType;
	}

	public String getBedRoom() {
		return bedRoom;
	}

	public void setBedRoom(String bedRoom) {
		this.bedRoom = bedRoom;
	}

	public String getSpecialConsiderations() {
		return specialConsiderations;
	}

	public void setSpecialConsiderations(String specialConsiderations) {
		this.specialConsiderations = specialConsiderations;
	}
	
	

}
