package sg.edu.iss.telemedicine.controller;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import sg.edu.iss.telemedicine.domain.Patient;
import sg.edu.iss.telemedicine.service.PatientService;


@RestController
@RequestMapping("/appointmentRest")
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
	public ResponseEntity<List<Integer>> list(@RequestParam String doctorId,@RequestParam LocalDate date) 
	{
		
		
		return pservice.findPatientbyAppointmentRest(doctorId,date); 
		
	}
}
