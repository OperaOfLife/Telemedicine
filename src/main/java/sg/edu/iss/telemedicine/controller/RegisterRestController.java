package sg.edu.iss.telemedicine.controller;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import sg.edu.iss.telemedicine.domain.Patient;
import sg.edu.iss.telemedicine.domain.Role;
import sg.edu.iss.telemedicine.domain.User;
import sg.edu.iss.telemedicine.service.DoctorService;
import sg.edu.iss.telemedicine.service.PatientService;
import sg.edu.iss.telemedicine.service.UserService;

@RestController
@RequestMapping("/registerRest")
public class RegisterRestController
{

	@Autowired
	UserService uservice;
	
	@Autowired
	PatientService pservice;
	
	@RequestMapping("/registerPatient") 
	 public ResponseEntity<Boolean> register(@RequestParam String nric,@RequestParam String fname,@RequestParam String lname,
			 								@RequestParam String email,@RequestParam String mobile,@RequestParam String pwd,
			 								@RequestParam String gender) 
	 { 
	  boolean check =true; 
	  
	  Optional<Patient> pat=pservice.findPatientByPatientId(nric);
	  Patient p=new Patient();
	  User user=new User();
		
		//String id=pat.get();
		
		if(pat.isEmpty())
		{	
			
			p.setPatientId(nric);
			p.setFirstName(fname);
			p.setLastName(lname);
			p.setEmail(email);
			p.setMobile(mobile);
			p.setGender(gender);
			
			pservice.savePatient(p);
			
			user.setUsername(nric);
			user.setPassword(pwd);
			user.setRole(Role.PATIENT);
			
			uservice.createUser(user);
		    
			check = true; 	
		
		}
		else
		{
			
	   check = false; 
		}
	   
	  return new ResponseEntity<Boolean>(check, HttpStatus.OK); 
	 }
	
	@Transactional
	@RequestMapping("/updatePatient") 
	 public ResponseEntity<Boolean> updatePatient(@RequestParam String nric,@RequestParam String fname,@RequestParam String lname,
			 								@RequestParam String email,@RequestParam String mobile,@RequestParam String pwd,
			 								@RequestParam String gender) 
	 { 
	  boolean check =true; 
	  
	  Optional<Patient> pat=pservice.findPatientByPatientId(nric);
	  Patient p=new Patient();
	  User user=new User();
		
		//String id=pat.get();
		
		if(pat.isEmpty())
		{	
					    
			check = false; 	
		
		}
		else
		{
			
			p.setPatientId(nric);
			p.setFirstName(fname);
			p.setLastName(lname);
			p.setEmail(email);
			p.setMobile(mobile);
			p.setGender(gender);
			
			pservice.updateProfilePatient(nric, p);
						
			user.setPassword(pwd);
			uservice.updatePassword(nric, pwd);
			
			check = true; 
		}
	   
	  return new ResponseEntity<Boolean>(check, HttpStatus.OK); 
	 }
	
	
	
}
