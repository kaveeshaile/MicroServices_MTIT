package com.services.bedService.controllers;

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

import com.services.bedService.beans.Bed;
import com.services.bedService.services.BedService;

@RestController
@RequestMapping("/beds")
public class BedController {

	@Autowired
	BedService bedService;
	
	@GetMapping("/getbeds")
	public List<Bed> getBeds() {
		return bedService.getAllBeds();
	}
	
	@GetMapping("/getbeds/{id}")
	public ResponseEntity<Bed> getBedbyId(@PathVariable(value="id") int id) {
		try {
			Bed bed = bedService.getBedbyID(id);
			return new ResponseEntity<Bed>(bed, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/getbeds/bedname")
	public ResponseEntity<Bed> getBedbyName(@RequestParam(value="name") String bedName) {
		try {
			Bed bed = bedService.getBedbyName(bedName);
			return new ResponseEntity<Bed>(bed, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/addbed")
	public Bed addBed(@RequestBody Bed bed) {
		return bedService.addBed(bed);
	}
	
	@PutMapping("/updatebed/{id}")
	public ResponseEntity<Bed> updateBed(@PathVariable(value="id") int id, @RequestBody Bed bed) {
		try {
			Bed existBed = bedService.getBedbyID(id);
			
			existBed.setBedNumber(bed.getBedNumber());
			existBed.setBedType(bed.getBedType());
			existBed.setBedFloor(bed.getBedFloor());
			existBed.setBedRoom(bed.getBedRoom());
			existBed.setSpecialConsiderations(bed.getSpecialConsiderations());
			
			Bed updatedBed = bedService.updateBed(existBed);
			return new ResponseEntity<Bed>(updatedBed, HttpStatus.OK);
			
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
	}
	
	@DeleteMapping("/deletebed/{id}")
	public AddResponse deleteBed(@PathVariable(value="id") int id) {
		return bedService.deleteBed(id);
	}
}
