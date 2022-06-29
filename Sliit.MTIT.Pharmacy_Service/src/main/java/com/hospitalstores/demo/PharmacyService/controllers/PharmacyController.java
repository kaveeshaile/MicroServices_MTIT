package com.hospitalstores.demo.PharmacyService.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hospitalstores.demo.PharmacyService.beans.Pharmacy;
import com.hospitalstores.demo.PharmacyService.service.HospitalServiceStore;

@RestController
@RequestMapping("/store")
public class PharmacyController {
	
	
	
	@Autowired
	HospitalServiceStore hospitalserviceStore;
	
	@GetMapping("/getpharmacies")
	public List<Pharmacy> getPharmacies()
	{
		return hospitalserviceStore.getAllPharmacies();
	}
	
	@GetMapping("/getpharmacies/{id}")
	public ResponseEntity<Pharmacy> getPharmacyByID(@PathVariable(value = "id")int id)
	{
		try {
			Pharmacy pharmacy=hospitalserviceStore.getPharmacybyID(id);
			return new ResponseEntity<Pharmacy>(pharmacy,HttpStatus.OK);
		}
		catch(Exception e)
		{
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/getpharmacies/pharmacyname")
	public ResponseEntity<Pharmacy> getPharmacyByID(@RequestParam(value = "name")String pharmacyName)
	{
		try {
			Pharmacy pharmacy=hospitalserviceStore.getPharmacybyName(pharmacyName);
			return new ResponseEntity<Pharmacy>(pharmacy,HttpStatus.OK);
		}
		catch(Exception e)
		{
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/addpharmacy")
	public Pharmacy addPharmacy(@RequestBody Pharmacy pharmacy)
	{
		return hospitalserviceStore.addPharmacy(pharmacy);
	}
	
	@PutMapping("/updatepharmacy")
	public ResponseEntity<Pharmacy> updatePharmacy(@PathVariable(value="id") int id,@RequestBody Pharmacy pharmacy)
	{
		try {
			Pharmacy exitPharmacy=hospitalserviceStore.getPharmacybyID(id);
			
			exitPharmacy.setPharmacyName(pharmacy.getPharmacyName());
			exitPharmacy.setHeadName(pharmacy.getHeadName());
			
			Pharmacy updated_pharmacy=hospitalserviceStore.updatePharmacy(exitPharmacy);
			return new ResponseEntity<Pharmacy>(updated_pharmacy,HttpStatus.OK);
		}
		catch(Exception e)
		{
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/deletepharmacy/{id}")
	public AddResponse deletePharmacy(@PathVariable(value = "id")int id)
	{
		return hospitalserviceStore.deletePharmacy(id);
	}
	
}
