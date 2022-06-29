package com.patientservice.demo.controller;

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

import com.patientservice.demo.beans.Patient;
import com.patientservice.demo.repositories.PatientRepository;
import com.patientservice.demo.services.PatientService;


@RestController
@RequestMapping("/patient")

public class PatientController<Addresponse> {

	
	
	
@Autowired
PatientService<?> patientservice;
PatientRepository Prepo;

@GetMapping("/getpatients")
public List<Patient> getpaitents()
{
	
return patientservice.getAllPatients();


}
	
@GetMapping("/getpatients/{id}")
public ResponseEntity<Patient> getpatientById(@PathVariable(value="id") int id)
{
	try {
		
		Patient patient= patientservice.getPatientbyID(id);
		return new ResponseEntity<Patient>(patient,HttpStatus.OK);
		
		
	}
	catch(Exception e)
	{
		
		
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
	}

}


@GetMapping("/getpatients/patientname")
public ResponseEntity<Patient> getpatientByName(@RequestParam(value="pname") String pname)
{

try {
		
		Patient patient= patientservice.getpatientbyName(pname);
		return new ResponseEntity<Patient>(patient,HttpStatus.OK);
		
		
	}
	catch(Exception e)
	{
		
		
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
	}

}
	
@PostMapping("/addpatient")
public Patient addPatient(@RequestBody Patient patient)
{
	return patientservice.addPatient(patient);

}
	
@PutMapping("/updatepatient/{id}")
public ResponseEntity<Patient> updatePatient(@PathVariable(value="id") int id, @RequestBody Patient patient)
{
try {
		
		Patient existpatient= patientservice.getPatientbyID(id);
		existpatient.setPname(patient.getPname());
		existpatient.setAddress(patient.getAddress());
		existpatient.setDisease(patient.getDisease());
		existpatient.setAge(patient.getAge());
		
		Patient Updated_Patient=patientservice.updatePatient(existpatient);
		return new ResponseEntity<Patient>(Updated_Patient,HttpStatus.OK);
		
		
	}
	catch(Exception e)
	{
		
		
		return new ResponseEntity<>(HttpStatus.CONFLICT);
		
	}

}
@DeleteMapping("/deletepatient/{id}")
public  ResponseEntity<?>  deletepatient(@PathVariable (value="id") int id)
{
	 patientservice.deletepatient(id);
	 return new ResponseEntity<>("Delete Sucessfuly!", HttpStatus.OK);
	 

}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
