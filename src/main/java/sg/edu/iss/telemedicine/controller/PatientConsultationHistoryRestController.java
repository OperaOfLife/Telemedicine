package sg.edu.iss.telemedicine.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import sg.edu.iss.telemedicine.domain.Appointment;
import sg.edu.iss.telemedicine.domain.Patient;
import sg.edu.iss.telemedicine.domain.Prescription;
import sg.edu.iss.telemedicine.service.PatientService;

@CrossOrigin 
@org.springframework.web.bind.annotation.RestController 
@RequestMapping("/api") 
public class PatientConsultationHistoryRestController 
{

		 
	 @Autowired 
	 PatientService pservice; 
	  
	  //Display consultation history by patientId 
	  @RequestMapping("/list") 
	  public ResponseEntity<List<Appointment>> findConsultationHistoryByPatientId(@RequestParam String patientId) 
	  { 
	   ArrayList<Appointment> alist = pservice.findConsultationHistoryByPatientId(patientId); 
	   return new ResponseEntity<List<Appointment>>(alist, HttpStatus.OK); 
	  } 
	   
	  //Display selected prescription 
	  @RequestMapping("/prescription") 
	  public ResponseEntity<Prescription> findPrescriptionById(@RequestParam int prescriptionId) 
	  { 
	   Prescription prescription = pservice.findPrescriptionById(prescriptionId); 
	   return new ResponseEntity<Prescription>(prescription, HttpStatus.OK); 
	  } 
	   
	 
	  //KAT (14/8/2021) 
	  @RequestMapping("/patient") 
	  public ResponseEntity<Optional<Patient>> findPatientByPatientId(@RequestParam String patientId) 
	  { 
	   Optional<Patient> patient = pservice.findPatientByPatientId(patientId); 
	   return new ResponseEntity<Optional<Patient>>(patient, HttpStatus.OK); 
	  } 
	
	
}
