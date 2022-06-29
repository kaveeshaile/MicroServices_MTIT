package com.patientservice.demo.services;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.patientservice.demo.beans.Patient;
import com.patientservice.demo.repositories.PatientRepository;




@Component
@Service
public class PatientService <AddResponse> {
//<Addresponse>
	
	@Autowired
	
	PatientRepository Prepo;
	
	
	
	
	public List<Patient> getAllPatients()
	{
		
		return  Prepo.findAll();
		
	}
	
	 

	public Patient getPatientbyID(int id)
	{
		return Prepo.findById(id).get();
		
	}
	
	public Patient getpatientbyName(String pname)
	{
		List<Patient> patients=Prepo.findAll();
		Patient patient = null;
		for(Patient con:patients)
		{
			if(con.getPname().equalsIgnoreCase(pname))
				patient=con;
			
		}
		return patient;
	}
	
	public Patient addPatient(Patient patient)
	{
		patient.setId(getMaxId());
		Prepo.save(patient);
		return patient;
	}


	private int getMaxId() {
		return Prepo.findAll().size()+1;
	}
	
	public Patient updatePatient(Patient patient)
	{
	Prepo.save(patient);
	return patient;
	
	}



	public void deletepatient(int id) {
//		// TODO Auto-generated method stub
//		Prepo.deleteById(id);
//		AddResponse res = new AddResponse();
//		res.SetMsg("Patient Deleted!!");
//		res.setId(id);		
//			return res;
	}
	
//	public AddResponse deletePatient(int id)
//	{
//		
//		
//		Prepo.deleteById(id);
//		AddResponse res = new AddResponse();
//		res.SetMsg("Patient Deleted!!");
//		res.setId(id);		
//			return res;
//		
//		
//	}
//	
	
	
}
