package sg.edu.iss.telemedicine.controller;

import java.time.LocalDate;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import sg.edu.iss.telemedicine.domain.Doctor;
import sg.edu.iss.telemedicine.domain.Patient;
import sg.edu.iss.telemedicine.domain.Role;
import sg.edu.iss.telemedicine.domain.User;
import sg.edu.iss.telemedicine.service.DoctorService;
import sg.edu.iss.telemedicine.service.PatientService;

@Controller
@RequestMapping
public class DashBoardController 
{
	@Autowired
	DoctorService dservice;
	
	@Autowired
	PatientService pservice;
	
	@RequestMapping(path = "/dashboard") 
	public String dashboard(Model model, HttpSession session)
	  {
	  
		UserSession usession = (UserSession) session.getAttribute("usession"); 
	     String currentusername=usession.getUser().getUsername();  
	  
	  
	  
	 
		  Doctor doctor=dservice.getDoctorById(currentusername);
		  String name="Hello, Dr. " + doctor.getFirstName() +" !";
		  
		  LocalDate currentDate = LocalDate.now();
		  int noOfAppts= dservice.getNumAppointmentsTodayById(currentDate,currentusername);
		  int noOfPatients= pservice.totalPatients();
		  int noOfMyPatients= dservice.myPatients(currentusername);
		  
		  List<Integer> appt=dservice.getAppointmentsTodayById(currentDate,currentusername);
		  int pres= dservice.totalPresByApptId(appt);
		  int queue = noOfAppts - pres;
		  
		  List<Patient> patients=dservice.getPatientsTodayById(currentDate,currentusername);
			
		  model.addAttribute("name", name);
		  model.addAttribute("totalAppointments", noOfAppts);
		  model.addAttribute("totalPatients", noOfPatients);
		  model.addAttribute("queue", queue);
		  model.addAttribute("myPatients", noOfMyPatients);
		  model.addAttribute("patients", patients);
		  
		  
		  return "home-doctor"; 
	  
	 
}
	
	

}
