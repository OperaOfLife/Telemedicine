package sg.edu.iss.telemedicine.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import sg.edu.iss.telemedicine.domain.Patient;
import sg.edu.iss.telemedicine.repo.PatientRepository;

@Service
public class PatientServiceImpl implements PatientService
{

	
	@Autowired
	PatientRepository prepo;

	
	@Override
	public void savePatient(Patient patient) {
		prepo.save(patient);
		
	}


	@Override
	public List<Patient> listAllPatients() {
		
		return (List<Patient>)prepo.findAll();
		
	}
}
