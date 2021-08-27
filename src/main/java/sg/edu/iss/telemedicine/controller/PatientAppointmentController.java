package sg.edu.iss.telemedicine.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.TemporalAccessor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;

import io.netty.handler.codec.DateFormatter;
import sg.edu.iss.telemedicine.domain.Appointment;
import sg.edu.iss.telemedicine.domain.Doctor;
import sg.edu.iss.telemedicine.domain.Patient;
import sg.edu.iss.telemedicine.domain.TimeSlots;
import sg.edu.iss.telemedicine.repo.AppointmentRepository;
import sg.edu.iss.telemedicine.service.DoctorService;
import sg.edu.iss.telemedicine.service.PatientService;
import sg.edu.iss.telemedicine.service.UserService;


@Controller
@RequestMapping("/appointment")
public class PatientAppointmentController 
{
	@Autowired
	DoctorService dservice;
	
	@Autowired
	PatientService pservice;
	
	@Autowired
	AppointmentRepository arepo;
	
	
	
	
	//@RequestMapping("slots")
	
	@RequestMapping(value = "slots", method = RequestMethod.GET)
	public @ResponseBody ModelAndView list1( HttpServletRequest request,Model model) 
	{
		ModelAndView modelAndView = new ModelAndView();
		
		String id=request.getParameter("doctorId");
		
		String date1=request.getParameter("date");
//		DateTimeFormatter df = DateTimeFormatter.ofPattern("dd-MM-yyyy");
//		
//		Date dateTime = (Date) df.parse(date1);
//		LocalDate localDate = dateTime.
//	    
//		LocalDate date=new Date().
//	    
		/*
		 * List<TimeSlots> apt =pservice.findSlotsbyAppointment(id,date); TimeSlots[]
		 * slots=TimeSlots.values(); List<TimeSlots> list = Arrays.asList(slots);
		 * 
		 * List<TimeSlots> slotList=new ArrayList<>(); if(!apt.isEmpty()) {
		 * for(TimeSlots t:apt) { for(int i=0;i<slots.length;i++) {
		 * if(!t.equals(slots[i])) { slotList.add(slots[i]); } } }
		 * model.addAttribute("appointment",slotList); } else {
		 * model.addAttribute("appointment",list); }
		 * 
		 */
		modelAndView.setViewName("time-slots:: content1");
	    return modelAndView;
		
		
	}
	
	
	
	
	@RequestMapping("bookAvailDoctor")
	 public String displayAvailDoctors(Model model) {
	  model.addAttribute("doctors", dservice.getAllDoctors());
	  
	  return "patient-book-consultation-list-doctors";
	 }
	

	@RequestMapping("/bookform/{doctorid}")
	 public String add(@PathVariable("doctorid") String id,Model model, HttpSession session)
	 {
		    UserSession usession = (UserSession) session.getAttribute("usession");
		    String currentusername=usession.getUser().getUsername();
	  //get doctor with id
	  Doctor doctor = dservice.getDoctorById(id);
	  
	  Patient pat = pservice.findPatientById(currentusername);
	    
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
	public String book(@ModelAttribute("appointment") Appointment appointment,Model model) 
	{
		 
		LocalDate date=appointment.getAppointmentDate();
		TimeSlots time=appointment.getAppointmentTime();
		
		String doctorId=appointment.getDoctor().getDoctorId();
		String patientId=appointment.getPatient().getPatientId();
		
		
		 List<Appointment> apt =pservice.findPatientbyAppointment(doctorId,date,time);
		 if(apt.isEmpty())
			 arepo.save(appointment);
		
		return "patient-book-consultation";
		
	}
	
	
}
