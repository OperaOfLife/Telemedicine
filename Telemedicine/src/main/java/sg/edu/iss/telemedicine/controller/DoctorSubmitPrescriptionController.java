package sg.edu.iss.telemedicine.controller;

import java.util.ArrayList; 
import java.util.Optional; 
 
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
 
  
 @RequestMapping("/submitPrescription") 
 public String submitPrescription(Model model) { 
  //hardcode doctor id  
  String doctorid = "0001"; 
  model.addAttribute("appointments",dservice.findAppointmentByDoctorId(doctorid)); 
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
  if(bindingresult.hasErrors()) { 
   return "doctor-submit-prescription-patient-particulars"; 
  } 
  Optional<Appointment> appoint = dservice.getAppointmentById(id); 
  if(appoint.isPresent()) { 
   Appointment a = appoint.get(); 
   prescription.setAppoint(a); 
   dservice.savePrescription(prescription); 
  } 
   
   
  return "forward:/submitPrescription"; 
 } 
}