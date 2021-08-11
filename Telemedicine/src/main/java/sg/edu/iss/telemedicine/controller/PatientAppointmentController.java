package sg.edu.iss.telemedicine.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import sg.edu.iss.telemedicine.domain.Appointment;
import sg.edu.iss.telemedicine.domain.Doctor;
import sg.edu.iss.telemedicine.domain.Patient;
import sg.edu.iss.telemedicine.service.DoctorService;
import sg.edu.iss.telemedicine.service.PatientService;


@Controller
@RequestMapping("/appointment")
public class PatientAppointmentController 
{
	@Autowired
	DoctorService dservice;
	@Autowired
	PatientService pservice;
	
	
	@RequestMapping("/list")
	public String list(@ModelAttribute("appointment") Appointment appointment,Model model) 
	{
		LocalDate date=appointment.getAppointmentDate();
		//String doctorId=appointment.getDoctor().getDoctorId();
		//model.addAttribute("appointment",pservice.findPatientbyAppointment(doctorId,date));
		
		return "time-slots"; 
		
	}
	
	@RequestMapping("bookAvailDoctor")
	 public String displayAvailDoctors(Model model) {
	  model.addAttribute("doctors", dservice.getAllDoctors());
	  
	  return "patient-book-consultation-list-doctors";
	 }
	

	@RequestMapping("/bookform/{doctorid}")
	 public String add(@PathVariable("doctorid") String id,Model model)
	 {
	  //get doctor with id
	  Doctor doctor = dservice.getDoctorById(id);
	  //hardcore patient id 
	  String patId = "A8888888B";
	  Patient pat = pservice.findPatientById(patId);
	    
	  //create new appointment
	  Appointment appointment = new Appointment();
	  if(appointment.getDoctor() == null)
	   appointment.setDoctor(doctor);
	  
	  if(appointment.getPatient() == null)
	   appointment.setPatient(pat);
	  model.addAttribute("appointment",appointment);
	  return "patient-book-consultation";
	 }
	
	@RequestMapping("/book")
	public String book(@ModelAttribute("appointment") Appointment appointment,Model model) throws ParseException 
	{
		
		LocalDate date=appointment.getAppointmentDate();
		String doctorId=appointment.getDoctor().getDoctorId();
		LocalDate time=appointment.getAppointmentTime();
		
		List<Appointment> apt =pservice.findPatientbyAppointment(doctorId,date);
		
		model.addAttribute("appointment",apt);
		
		return "time-slots";
	}
	
	
}
