package sg.edu.iss.telemedicine.controller;


import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import sg.edu.iss.telemedicine.domain.Appointment;
import sg.edu.iss.telemedicine.service.PatientService;


@Controller 
@RequestMapping("/consultationhistory") 
public class PatientConsultationHistoryController { 
 
	//kat
	
	
 @Autowired 
 PatientService pservice; 
  
 //Display consultation history by patientId 
  @RequestMapping("/list/{patientId}") 
  public String findConsultationHistoryByPatientId(@PathVariable("patientId") String patientId, Model model) 
  { 
   ArrayList<Appointment> alist = pservice.findConsultationHistoryByPatientId(patientId); 
   model.addAttribute("alist", alist); 
   return "patient-retrieve-consultation-history"; 
  } 
   
  //Display selected prescription 
  @RequestMapping("/prescription/{prescriptionId}") 
  public String findPrescriptionById(@PathVariable("prescriptionId") int prescriptionId, Model model) 
  { 
   model.addAttribute("prescription", pservice.findPrescriptionById(prescriptionId)); 
   return "patient-view-prescription"; 
  } 
   
  //Display selected MC 
  @RequestMapping("/mc/{mcId}") 
  public String findMCById(@PathVariable("mcId") String mcId, Model model) 
  { 
   model.addAttribute("mc", pservice.findMedicalCertificateById(mcId)); 
   return "patient-view-mc"; 
  } 
  
  
  //kat
}
