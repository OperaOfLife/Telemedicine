package sg.edu.iss.telemedicine.controller;

import java.util.ArrayList; 
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Controller; 
import org.springframework.ui.Model; 
import org.springframework.validation.BindingResult; 
import org.springframework.web.bind.annotation.ModelAttribute; 
import org.springframework.web.bind.annotation.PathVariable; 
import org.springframework.web.bind.annotation.RequestMapping; 
 
import sg.edu.iss.telemedicine.domain.Appointment; 
import sg.edu.iss.telemedicine.domain.Patient; 
import sg.edu.iss.telemedicine.domain.Prescription; 
import sg.edu.iss.telemedicine.repo.PatientRepository; 
import sg.edu.iss.telemedicine.service.DoctorService; 
import sg.edu.iss.telemedicine.service.PatientService; 
 
@Controller 
public class DoctorSubmitPrescriptionController { 
 
  
 @Autowired 
 DoctorService dservice; 
  
 @Autowired 
 PatientService pservice; 
 
 String msg="Prescription Exists";
 String msg1="Appointment does not Exist";
 
  
 @RequestMapping("/submitPrescription") 
 public String submitPrescription(Model model, HttpSession session)
 {
UserSession usession = (UserSession) session.getAttribute("usession");
	    String currentusername=usession.getUser().getUsername();
  
  model.addAttribute("appointments",dservice.findAppointmentByDoctorId(currentusername)); 
  
  
  return "doctor-submit-prescription"; 
 } 
  
 @RequestMapping("/patientParticulars/{patientid}") 
 public String patientParticulars(Model model, @PathVariable("patientid") String id) { 
  ArrayList<Appointment> patientAppointments = dservice.findAppointmentsByPatientId(id); 
  model.addAttribute("appointmentdetails", patientAppointments.get(0)); 
  model.addAttribute("prescription", new Prescription()); 
       
      return "doctor-submit-prescription-patient-particulars"; 
 } 
  
 @RequestMapping("/savePrescription/{appointid}") 
 public String savePrscriptionParticulars(@PathVariable("appointid") int id,@ModelAttribute("prescription") Prescription prescription, BindingResult bindingresult, Model model) { 
  if(bindingresult.hasErrors())
  { 
   return "doctor-submit-prescription-patient-particulars"; 
  } 
  Optional<Appointment> appoint = dservice.getAppointmentById(id); 
  Appointment appointment=new Appointment();
  appointment=appoint.get();
  
  if(appoint.isPresent()) 
  { 
	  if(appointment.getPrescription()== null)
	  {
		  Appointment a = appoint.get(); 
		  prescription.setAppoint(a); 
		  dservice.savePrescription(prescription); 
		  return "submit-prescription-success"; 
	  }
	  else
	  {
		  model.addAttribute("errormsg",msg);
		  return "forward:/submitPrescription";
	  }
  } 
  else
  {
   
	  model.addAttribute("errormsg",msg1);
	  return "forward:/submitPrescription";
 
 } 
}
}