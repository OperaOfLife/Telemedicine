package sg.edu.iss.telemedicine.controller;


import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import sg.edu.iss.telemedicine.domain.Appointment;
import sg.edu.iss.telemedicine.domain.MedicalCertificate;
import sg.edu.iss.telemedicine.service.PatientService;


@Controller 
@RequestMapping("/consultationhistory") 
public class PatientConsultationHistoryController { 
 
	//kat
	
	
 @Autowired 
 PatientService pservice; 
  
 //Display consultation history by patientId 
 
 @RequestMapping("/list") 
 public String findConsultationHistoryByPatientId( Model model, HttpSession session)
 {
UserSession usession = (UserSession) session.getAttribute("usession");
	    String currentusername=usession.getUser().getUsername(); 
  ArrayList<Appointment> alist = pservice.findConsultationHistoryByPatientId(currentusername);   
  Collections.sort(alist, Collections.reverseOrder(new Comparator<Appointment>() {  
   @Override  
   public int compare(Appointment a, Appointment o) {  
    if (a.getAppointmentDate() == null || o.getAppointmentDate() == null)  
              return 0;  
          return a.getAppointmentDate().compareTo(o.getAppointmentDate());  
   }  
  }));  
  model.addAttribute("alist", alist);   
  return "patient-retrieve-consultation-history";   
 }
 
 @RequestMapping("/lis") 
 public String findConsultationHistoryByPatientId1( Model model, HttpSession session)
 {
UserSession usession = (UserSession) session.getAttribute("usession");
	    String currentusername=usession.getUser().getUsername();
  ArrayList<Appointment> alist = pservice.findConsultationHistoryByPatientId(currentusername); 
  model.addAttribute("alist", alist); 
  return "patient-retrieve-consultation-history"; 
 } 
 
 
	/*
	 * @RequestMapping("/list/{patientId}") public String
	 * findConsultationHistoryByPatientId(@PathVariable("patientId") String
	 * patientId, Model model) { ArrayList<Appointment> alist =
	 * pservice.findConsultationHistoryByPatientId(patientId);
	 * model.addAttribute("alist", alist); return
	 * "patient-retrieve-consultation-history"; }
	 */
   
  //Display selected prescription 
  @RequestMapping("/prescription/{prescriptionId}") 
  public String findPrescriptionById(@PathVariable("prescriptionId") int prescriptionId, Model model) 
  { 
   model.addAttribute("prescription", pservice.findPrescriptionById(prescriptionId)); 
   return "patient-view-prescription"; 
  } 
   
  //Display selected MC 
  @RequestMapping("/mc/{mcId}") 
  public String findMCById(@PathVariable("mcId") int mcId, Model model) 
  { 
	  MedicalCertificate mc = pservice.findMedicalCertificateById(mcId);
	  long duration =ChronoUnit.DAYS.between(mc.getDateFrom(),mc.getDateTo());
   model.addAttribute("mc", mc);
   model.addAttribute("duration", duration);
 
   
   return "patient-view-mc"; 
  } 
 
  
  //kat
}
