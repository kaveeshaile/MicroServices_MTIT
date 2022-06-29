package com.channeling.demo.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.transform.impl.AddStaticInitTransformer;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import com.channeling.demo.beans.Channelling;
import com.channeling.demo.controllers.AddResponse;
import com.channeling.demo.repositories.ChannelingRepository;


@Component
@Service
public class ChannelingService {

	@Autowired
	ChannelingRepository channelingRep;
public List getAllChannelings() {
 
return	channelingRep.findAll();

	
}
public Channelling getChannelingbyID(int id) {
	
	
	 return channelingRep.findById(id).get();


}

public Channelling getChannelingbyName(String patient_name) {


		List<Channelling>channellings =channelingRep.findAll();
		Channelling channelling = null;
		for (Channelling con: channellings) {
			if (con.getPatient_name().equalsIgnoreCase(patient_name))
				channelling= con;
		}
				
		return channelling;		



	
}
public Channelling addChanneling(Channelling channelling)
{

	
	channelling.setId(getMaxId());
	channelingRep.save(channelling);
	return channelling;
	
}


public int getMaxId() {
	
	return channelingRep.findAll().size()+1;
	
}

public Channelling updateChannelling(Channelling channelling) {
	
	channelingRep.save(channelling);
	return channelling;
	
}

public AddResponse deleteChanneling(int id) {
	channelingRep.deleteById(id);
	AddResponse response= new AddResponse();
	response.setMsg("deleted");
	response.setId(id);
	return response;
	
}
}
