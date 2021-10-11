package sg.edu.iss.telemedicine.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sg.edu.iss.telemedicine.domain.Seminar;
import sg.edu.iss.telemedicine.repo.DoctorRepository;
import sg.edu.iss.telemedicine.repo.PatientRepository;
import sg.edu.iss.telemedicine.repo.SeminarRepository;

@Service
public class AdminServiceImpl implements AdminService
{

	@Autowired
	PatientRepository prepo;
	
	@Autowired
	DoctorRepository drepo;
	
	@Autowired
	SeminarRepository srepo;

	@Override
	public void saveSeminar(Seminar seminar) 
	{
		srepo.deleteAll();
		srepo.save(seminar);
		
	}
	
	
	@Override
	public Seminar findSeminars() 
	{
		
		Seminar s=srepo.findTopByOrderByIdDesc();
		return s;
		
	}
	
}
