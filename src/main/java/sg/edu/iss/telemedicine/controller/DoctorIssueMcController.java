package sg.edu.iss.telemedicine.controller;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;


import sg.edu.iss.telemedicine.domain.MedicalCertificate;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.apache.tomcat.util.json.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import sg.edu.iss.telemedicine.domain.Appointment;
import sg.edu.iss.telemedicine.domain.MedicalCertificate;
import sg.edu.iss.telemedicine.domain.Patient;
import sg.edu.iss.telemedicine.domain.Prescription;
import sg.edu.iss.telemedicine.repo.AppointmentRepository;
import sg.edu.iss.telemedicine.repo.DoctorRepository;
import sg.edu.iss.telemedicine.repo.MedicalCertificateRepository;
import sg.edu.iss.telemedicine.service.DoctorService;

@Controller
@RequestMapping("/mc")
public class DoctorIssueMcController 
{
 @Autowired
 DoctorService dservice;

 @Autowired
 AppointmentRepository arepo;
 
 String msg="Start date should be before End date.";

 //Search bar 
 @RequestMapping("/search")
 public String searchbar(Model model, @Param("keyword") String keyword){
  List<Appointment> searchedAppointments = dservice.listAll(keyword);
  model.addAttribute("appointments", searchedAppointments);
  model.addAttribute("keyword", keyword);
  return "doctor-issue-mc-patient-list";
 }

 //display list of patients that the doctor has a consultation with 
 @RequestMapping("/patientlist")
 public String listOfPatients(Model model, HttpSession session)
 {
UserSession usession = (UserSession) session.getAttribute("usession");
	    String currentusername=usession.getUser().getUsername(); 
  ArrayList<Appointment> appointments = dservice.findAppointmentByDoctorId(currentusername);
  model.addAttribute("appointments", appointments);
  return "doctor-issue-mc-patient-list";
 }
 

 //display consultation details when clicked 
 @RequestMapping("/details/{id}")
 public String consultationDetails(@PathVariable("id") int id, Model model) {
  //get appointment and send
  Appointment appointment = arepo.getById(id);
  model.addAttribute("appointmentdetails", appointment);
  return "doctor-issue-mc-details";
 }
 
 //display mc form 
 @RequestMapping("/mcform/{appointmentid}")
 public String add(@PathVariable("appointmentid")int id,Model model)
 {
  //display appointment details 
  Appointment appointment = arepo.getById(id);
  model.addAttribute("appointment", appointment); 

  if(appointment.getMc() == null)
   model.addAttribute("newMc", new MedicalCertificate());
  else
   model.addAttribute("newMc", appointment.getMc());
  return "doctor-issue-mc";
 }
 
 //save mc form 
 @RequestMapping("/issue{id}")
 public String book(@PathVariable("id") int id,@ModelAttribute("appointment") Appointment appointment,@ModelAttribute("newMc") MedicalCertificate mc,BindingResult bindingresult,Model model)
 {
  if(bindingresult.hasErrors()) { 
      return "doctor-issue-mc"; 
     } 
		/*
		 * if(mc.getDateFrom().isAfter(mc.getDateTo())) { model.addAttribute("errormsg",
		 * msg); return "doctor-issue-mc"; }
		 */
  else {
  Optional<Appointment> appoint = dservice.getAppointmentById(id);
  if(appoint.isPresent()) {
   Appointment a = appoint.get();
   mc.setAppointMC(a);
   dservice.saveMc(mc);
  }
  }

  return "doctor-issue-mc";
 }
 
// /Genesis testing AJAX for Issue MC
 @RequestMapping(value = "/calculation/{datef}/{datet}", method = RequestMethod.GET)
 public String calculateDuration(Model model, @PathVariable("datef")String datef, @PathVariable("datet") String datet ) {
  DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd MM yyyy");
  
  LocalDateTime dateF = LocalDateTime.parse(datef,dtf);
  LocalDateTime dateT = LocalDateTime.parse(datet, dtf);
  long daysBetween = ChronoUnit.DAYS.between(dateF, dateT);
  System.out.println ("Days: " + daysBetween);
  
  model.addAttribute("day", daysBetween);
  
  return "doctor-issue-mc-results :: results";
  
}
}