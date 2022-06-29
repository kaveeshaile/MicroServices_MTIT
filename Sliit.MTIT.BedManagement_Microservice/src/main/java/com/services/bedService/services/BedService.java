package com.services.bedService.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.services.bedService.controllers.AddResponse;
import com.services.bedService.beans.Bed;
import com.services.bedService.repositories.BedRepository;

@Component
@Service
public class BedService {

	@Autowired
	BedRepository bedRep;
	
	public List<Bed> getAllBeds() {
		return bedRep.findAll();
	}
	
	public Bed getBedbyID(int id) {
		return bedRep.findById(id).get();
	}

	public Bed getBedbyName(String bedName) {
		List<Bed> beds = bedRep.findAll();
		Bed bed = null;
		
		for(Bed b:beds) {
			if(b.getBedNumber().equalsIgnoreCase(bedName))
				bed = b;
		}
		
		return bed;
	}
	
	public Bed addBed(Bed bed) {
		//bed.setBedID(getMaxId());
		bedRep.save(bed);
		return getBedbyID(bedRep.findAll().size());
		//return bed;
	}
	
/*
	public int getMaxId() {
		return bedRep.findAll().size()+1;
	}
*/
	
	public Bed updateBed(Bed bed) {
		return bedRep.save(bed);
	}

	public AddResponse deleteBed(int id) {
		bedRep.deleteById(id);
		
		AddResponse res = new AddResponse();
		res.setMsg("Bed deleted!");
		res.setId(id);
		return res;
	}
	
}
