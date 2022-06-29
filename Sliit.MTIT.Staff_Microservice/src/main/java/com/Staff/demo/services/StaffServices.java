package com.Staff.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.Staff.demo.beans.Staff;
import com.Staff.demo.controllers.AddResponse;
import com.Staff.demo.repositories.StaffRepository;


@Component
@Service
public class StaffServices {
	
	@Autowired
	StaffRepository staffRepository;
	
	public List getAllStaff() {
		 
		
		return	staffRepository.findAll();

			
		}
	public Staff getSaffbyID(int id) {
		
		
		 return staffRepository.findById(id).get();


	}
	
	public Staff getStaffbyName(String Name) {


		List<Staff>staffs =staffRepository.findAll();
		Staff staff = null;
		for (Staff con: staffs) {
			if (con.getName().equalsIgnoreCase(Name))
				staff= con;
		}
				
		return staff;		



	
}
	public Staff addStaff(Staff staff)
	{

		
		staff.setId(getMaxId());
		staffRepository.save(staff);
		return staff;
		
	}


	public int getMaxId() {
		
		return staffRepository.findAll().size()+1;
		
	}

	public Staff updateStaff(Staff staff) {
		
		staffRepository.save(staff);
		return staff;
		
	}

	public AddResponse deleteStaff(int id) {
		staffRepository.deleteById(id);
		AddResponse response= new AddResponse();
		response.setMsg("deleted");
		response.setId(id);
		return response;
		
	}
}
