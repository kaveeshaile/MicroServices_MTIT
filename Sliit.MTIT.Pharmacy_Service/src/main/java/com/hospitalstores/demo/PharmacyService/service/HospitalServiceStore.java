package com.hospitalstores.demo.PharmacyService.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.hospitalstores.demo.PharmacyService.beans.Pharmacy;
import com.hospitalstores.demo.PharmacyService.controllers.AddResponse;
import com.hospitalstores.demo.PharmacyService.repositories.pharmacyRepository;

@Component
@Service
public class HospitalServiceStore {
	
	@Autowired
	pharmacyRepository pharmacyrep;
	
	public List<Pharmacy> getAllPharmacies()
	{
		return pharmacyrep.findAll();	
	}
	
	public Pharmacy getPharmacybyID(int id)
	{
		return pharmacyrep.findById(id).get();
	}

	public Pharmacy getPharmacybyName(String pharmacyName)
	{
		List<Pharmacy> pharmacies=pharmacyrep.findAll();
		Pharmacy pharmacy = null;
		
		for(Pharmacy con:pharmacies) 
		{
			if(con.getPharmacyName().equalsIgnoreCase(pharmacyName))
				pharmacy=con;
		}
		return pharmacy;
	}
	
	public Pharmacy addPharmacy(Pharmacy pharmacy)
	{
		pharmacy.setId(getMaxId());
		pharmacyrep.save(pharmacy);
		return pharmacy;
	}
	
	public  int getMaxId()
	{
		 return pharmacyrep.findAll().size()+1;
	}
	
	public Pharmacy updatePharmacy(Pharmacy pharmacy)
	{
		pharmacyrep.save(pharmacy);
		return pharmacy;
	}
	
	public AddResponse deletePharmacy(int id)
	{
		pharmacyrep.deleteById(id);
		
		AddResponse res=new AddResponse();
		res.setMsg("Pharmacy Deleted Successfully....!!");
		res.setId(id);
		return res;
	}
}