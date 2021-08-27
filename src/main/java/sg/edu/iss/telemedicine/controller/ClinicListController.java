package sg.edu.iss.telemedicine.controller;


import java.util.ArrayList; 
import java.util.List; 
 
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.http.HttpStatus; 
import org.springframework.http.ResponseEntity; 
import org.springframework.web.bind.annotation.CrossOrigin; 
import org.springframework.web.bind.annotation.PathVariable; 
import org.springframework.web.bind.annotation.RequestMapping; 
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import sg.edu.iss.telemedicine.domain.Appointment;
import sg.edu.iss.telemedicine.domain.Clinic;

import sg.edu.iss.telemedicine.service.PatientService;
@CrossOrigin 
@RestController 
@RequestMapping("/api") 
public class ClinicListController { 
  
 @Autowired 
 PatientService pservice; 
  
  // KAT (23/8/2021) - Display clinics by zone 
  @RequestMapping("/clinics") 
  public ResponseEntity<List<Clinic>> findClinicsByZone(@RequestParam String zone) 
  { 
   ArrayList<Clinic> clist = pservice.findClinicsByZone(zone); 
   return new ResponseEntity<List<Clinic>>(clist, HttpStatus.OK); 
  } 
   
  // KAT (25/8/2021) - Display all clinics 
  @RequestMapping("/allclinics") 
  public ResponseEntity<List<Clinic>> findAllClinics() 
  { 
   ArrayList<Clinic> clist = pservice.findAllClinics(); 
   return new ResponseEntity<List<Clinic>>(clist, HttpStatus.OK); 
  }
  
//KAT (26/8/2021) - Display searched clinics 
 @RequestMapping("/searchedclinics") 
 public ResponseEntity<List<Clinic>> findSearchedClinics(@RequestParam String searchValue) 
 { 
  ArrayList<Clinic> clist = pservice.findSearchedClinics(searchValue); 
  return new ResponseEntity<List<Clinic>>(clist, HttpStatus.OK); 
 }
}
