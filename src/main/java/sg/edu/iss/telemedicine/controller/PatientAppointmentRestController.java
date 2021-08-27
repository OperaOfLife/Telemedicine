package sg.edu.iss.telemedicine.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import sg.edu.iss.telemedicine.domain.Appointment;
import sg.edu.iss.telemedicine.domain.Doctor;
import sg.edu.iss.telemedicine.domain.Patient;
import sg.edu.iss.telemedicine.service.DoctorService;
import sg.edu.iss.telemedicine.service.PatientService;


@RestController
@RequestMapping("/appointmentRest")
public class PatientAppointmentRestController 
{
	@Autowired
	PatientService pservice;
	@Autowired
	DoctorService dservice;

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
	
	//kat
	
	
	
	@RequestMapping("/validate") 
	 public ResponseEntity<String> validateAppointment(@RequestBody Appointment appointment,@RequestParam String date) { 
	   
	   
	    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy"); 
	    LocalDate datedate = LocalDate.parse(date, formatter); 
	    if(!pservice.validateAppointment(appointment.getAppointmentTime(),appointment.getDoctor(), datedate))  
	     return new ResponseEntity<String>(HttpStatus.OK);  
	    else  
	     return new ResponseEntity<String>(HttpStatus.FORBIDDEN); 
	 
	   
	 }
	

	  @RequestMapping("/getAllDoctors")
	  public ArrayList<Doctor> getAlldoctors(){
	   return dservice.getAllDoctors();
	  }
	  
	 //get appointment from android
	  


	  @RequestMapping("setAppointment")
	  public ResponseEntity<String> getAppointment(@RequestBody Appointment appointment ,@RequestParam String date) {
	   
	   DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
	   LocalDate datedate = LocalDate.parse(date, formatter);
	   appointment.setAppointmentDate(datedate);
	   dservice.saveAppointment(appointment);
	      
	   return ResponseEntity.ok("Successful Booking");
	  }
}
