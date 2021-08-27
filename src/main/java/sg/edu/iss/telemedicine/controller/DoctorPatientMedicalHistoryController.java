package sg.edu.iss.telemedicine.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import sg.edu.iss.telemedicine.domain.Appointment;
import sg.edu.iss.telemedicine.domain.Patient;
import sg.edu.iss.telemedicine.repo.AppointmentRepository;
import sg.edu.iss.telemedicine.service.DoctorService;
import sg.edu.iss.telemedicine.service.PatientService;

@Controller
@RequestMapping("/history")
public class DoctorPatientMedicalHistoryController 
{
 @Autowired
 PatientService pservice;
 
 @Autowired
 DoctorService dservice;

 @Autowired
 AppointmentRepository arepo;
 //searchbar
 @RequestMapping("/search")
 public String searchbar(Model model, @Param("keyword") String keyword){
  List<Patient> searchedPatients= pservice.listAll(keyword);
  model.addAttribute("patients", searchedPatients);
  model.addAttribute("keyword", keyword);
  return "doctor-retrieve-medical-history";
 }
 
 @RequestMapping("/list")
 public String showpatients(@ModelAttribute("patients") Patient patient,Model model)
 {
  model.addAttribute("patients", pservice.listAllPatients());
  return "doctor-retrieve-medical-history";
 }
 
 //display patient consultations 
 @RequestMapping("/details/{patientid}")
 public String getConsultations(@PathVariable("patientid")String id, Model model) {
  //get patient details 
  Patient patient = pservice.findPatientById(id);
  model.addAttribute("patient", patient);
  //get list of appointments with patient 
  ArrayList<Appointment> listOfAppt = dservice.findAppointmentsByPatientId(id);
  model.addAttribute("appointments", listOfAppt);
  
  return "doctor-retrieve-medical-history-details";
 }
 
 //display consultation details
 @RequestMapping("/apptdetail/{id}")
  public String getapptDetail(@PathVariable("id")int id, Model model) {
   //get appointment 
   Appointment appointment= arepo.getById(id);
   //validate if theres prescription 
   /*if(appointment.getPrescription() == null) {
    //return error page
   }*/
   //link to prescription page. (doctor-issue-mc-details.html)
   //else
   model.addAttribute("appointmentdetails", appointment);
   return "doctor-issue-mc-details";
  }
}