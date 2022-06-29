package com.Staff.demo.controllers;

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

import com.Staff.demo.beans.Staff;
import com.Staff.demo.repositories.StaffRepository;
import com.Staff.demo.services.StaffServices;

@RestController
@RequestMapping("/hospital")
public class StaffController {

	@Autowired
	StaffServices staffService;
	
	@Autowired
	StaffRepository StaffRep;
	

	@GetMapping("/Staff")
	public List getStaffs() {
		return  staffService.getAllStaff();
		
	}
	@GetMapping("/Staff/{id}")
	public ResponseEntity<Staff> getStaffbyId(@PathVariable(value = "id")int id) {
		
		
		try {
			Staff staff=staffService.getSaffbyID(id);
			return new ResponseEntity<Staff>(staff,HttpStatus.OK);
		} catch ( Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			
		}
	}
		
		@GetMapping("/Staff/Staff_Name")
		public ResponseEntity<?> getStaffbyName(@RequestParam(value = "name")String Staff_Name ) {
			
			
			try {
				Staff staff=staffService.getStaffbyName(Staff_Name);
				return new ResponseEntity<Staff>(staff,HttpStatus.OK);
			} catch ( Exception e) {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
				
			}
		
		
	}
		
		@PostMapping("/addStaff")
		public Staff addStaff(@RequestBody Staff staff)

	{
			return staffService.addStaff(staff);

			
	}
		
		@PutMapping("/updateStaff/{id}")
		public ResponseEntity<?> updateStaff(@PathVariable(value = "id")int id,@RequestBody Staff staff)

	{
			try {
				Staff  existstaffdetails= staffService.getSaffbyID(id);
				
				existstaffdetails.setName(staff.getName());
				existstaffdetails.setAge(staff.getAge());
				existstaffdetails.setAddress(staff.getAddress());
				existstaffdetails.setEmail(staff.getEmail());
				existstaffdetails.setPosition(staff.getPosition());
				existstaffdetails.setWorking_experience(staff.getWorking_experience());
				existstaffdetails.setStarting_date(staff.getStarting_date());
				
				staffService.updateStaff(existstaffdetails);
				return new ResponseEntity<>("Updated successfully.....",HttpStatus.OK);
			
				
			} catch (Exception e) {
				return new ResponseEntity<>("Error......",HttpStatus.CONFLICT);
				
			}
	}
		@DeleteMapping("/deleteStaff/{id}")
		public ResponseEntity<?> deleteStaff(@PathVariable("id")int id)

	{
			staffService.deleteStaff(id);
			//channelingRep.deleteById(id);
			return new ResponseEntity<>("delete successful", HttpStatus.OK);
	}

		
}
