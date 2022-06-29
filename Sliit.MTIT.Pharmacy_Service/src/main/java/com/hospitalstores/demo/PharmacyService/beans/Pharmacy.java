package com.hospitalstores.demo.PharmacyService.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="pharamacy")
public class Pharmacy {

	@Id
	@Column(name="id")
	int id;
	
	@Column(name="pharmacy_name")
	String pharmacyName;
	
	@Column(name="drug_name")
	String drugName;
	
	@Column(name="drug_code")
	String drugCode;
	
	@Column(name="drug_price")
	String drugPrice;
	
	@Column(name="qty")
	int qty;
	
	@Column(name="head_name")
	String headName;
	
	public Pharmacy()
	{
		
	}
	
	
	public Pharmacy(int id, String pharmacyName, String drugName, String drugCode, String drugPrice, int qty, String headName) {
		this.id = id;
		this.pharmacyName = pharmacyName;
		this.drugName = drugName;
		this.drugCode = drugCode;
		this.drugPrice =drugPrice;
		this.qty = qty;
		this.headName = headName;
	}
	
	public String getPharmacyName() {
		return pharmacyName;
	}
	public void setPharmacyName(String pharmacyName) {
		this.pharmacyName = pharmacyName;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getDrugName() {
		return drugName;
	}
	public void setDrugName(String drugName) {
		this.drugName = drugName;
	}
	public String getDrugCode() {
		return drugCode;
	}
	public void setDrugCode(String drugCode) {
		this.drugCode = drugCode;
	}
	public String getDrugPrice() {
		return drugPrice;
	}
	public void setDrugPrice(String drugPrice) {
		this.drugPrice = drugPrice;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public String getHeadName() {
		return headName;
	}
	public void setHeadName(String headName) {
		this.headName = headName;
	}
	
}

