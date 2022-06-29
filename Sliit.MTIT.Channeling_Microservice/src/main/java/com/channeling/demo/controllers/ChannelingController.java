package com.channeling.demo.controllers;

import java.security.PublicKey;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
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


import com.channeling.demo.beans.Channelling;
import com.channeling.demo.repositories.ChannelingRepository;
import com.channeling.demo.services.ChannelingService;

import net.bytebuddy.asm.Advice.Return;

@RestController
@RequestMapping("/api")
public class ChannelingController {


	@Autowired
	ChannelingService channelingService;
	
	@Autowired
	ChannelingRepository channelingRep;

	@GetMapping("/Channelings")
	public List getChannelings() {
		return  channelingService.getAllChannelings();
		
	}
	
	@GetMapping("/Channelings/{id}")
	public ResponseEntity<Channelling> getChannelingbyId(@PathVariable(value = "id")int id) {
		
		
		try {
			Channelling channelling=channelingService.getChannelingbyID(id);
			return new ResponseEntity<Channelling>(channelling,HttpStatus.OK);
		} catch ( Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			
		}
		
	}
	@GetMapping("/Channelings/patient_name")
	public ResponseEntity<?> getChannelingbyName(@RequestParam(value = "name")String patient_name ) {
		
		
		try {
			Channelling channelling=channelingService.getChannelingbyName(patient_name);
			return new ResponseEntity<Channelling>(channelling,HttpStatus.OK);
		} catch ( Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			
		}
	}

	@PostMapping("/addchanneling")
	public Channelling addChannelling(@RequestBody Channelling channelling)

{
		return channelingService.addChanneling(channelling);

		
}
	
	@PutMapping("/updatechanneling/{id}")
	public ResponseEntity<?> updateChannelling(@PathVariable(value = "id")int id,@RequestBody Channelling channelling)

{
		try {
			Channelling existChannelling= channelingService.getChannelingbyID(id);
			
			existChannelling.setAddress(channelling.getAddress());
			existChannelling.setContact_num(channelling.getContact_num());
			existChannelling.setDate(channelling.getDate());
			existChannelling.setTime(channelling.getTime());
			existChannelling.setDoc_name(channelling.getDoc_name());
			existChannelling.setRoom_num(channelling.getRoom_num());
			existChannelling.setAddress(channelling.getAddress());
			
			channelingService.updateChannelling(existChannelling);
			return new ResponseEntity<>("Updated successfully.....",HttpStatus.OK);
		
			
		} catch (Exception e) {
			return new ResponseEntity<>("Error......",HttpStatus.CONFLICT);
			
		}
}
	
	
	@DeleteMapping("/deletechanneling/{id}")
	public ResponseEntity<?> deleteChannelling(@PathVariable("id")int id)

{
		channelingService.deleteChanneling(id);
		//channelingRep.deleteById(id);
		return new ResponseEntity<>("delete successful", HttpStatus.OK);
}

	
	}


