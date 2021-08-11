package sg.edu.iss.telemedicine.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import sg.edu.iss.telemedicine.domain.Patient;
import sg.edu.iss.telemedicine.service.PatientService;
import sg.edu.iss.telemedicine.service.UserService;

@RestController
@RequestMapping("/appointment")
public class PatientAppointmentRestController 
{
	@Autowired
	PatientService pservice;

	@Autowired
	public void setUserInterface(PatientService ps) 
	{
		this.pservice = ps;
	}
	
	
	@RequestMapping("/list")
	public ResponseEntity<Patient> list(@RequestParam String doctorId,@RequestParam Date date) 
	{
		return pservice.findPatientbyAppointment(doctorId,date); 
		
	}
}
