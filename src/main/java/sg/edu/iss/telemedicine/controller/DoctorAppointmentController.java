package sg.edu.iss.telemedicine.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import sg.edu.iss.telemedicine.domain.Appointment;
import sg.edu.iss.telemedicine.service.DoctorService;

@Controller 
@RequestMapping("/doctor") 
public class DoctorAppointmentController { 
  
 @Autowired 
 DoctorService dservice; 
  
 @RequestMapping("/bookings") 
 public String findBookingsByDoctorId(Model model, HttpSession session) { 
   
  UserSession usession = (UserSession) session.getAttribute("usession"); 
     String currentusername=usession.getUser().getUsername(); 
   
     ArrayList<Appointment> blist = dservice.findAllAppointmentsByDoctorId(currentusername);    
  
     model.addAttribute("blist", blist); 
     
  return "doctor-check-scheduled-bookings"; 
 } 
  
 //cancel appointment scheduled 
 @GetMapping("/cancel/{appointmentId}") 
 public String cancelBookingByAppointmentId(@PathVariable(value="appointmentId") int id) { 
  dservice.deleteBookingByAppointmentId(id); 
  return "redirect:/doctor/bookings"; 
 } 
 
}