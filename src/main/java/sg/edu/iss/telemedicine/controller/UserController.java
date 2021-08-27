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
import sg.edu.iss.telemedicine.service.UserService;

@Controller
@RequestMapping("/login")
public class UserController {
	@Autowired
	UserService uservice;
	
	@Autowired
	DoctorService dservice;
	
	@Autowired
	PatientService pservice;
	
	
	
	


	String errmsg = "";
	String msg = "NO SUCH EMAIL ID EXISTS.";
	String msg1 = "USER ALREADY EXISTS.";

	@Autowired
	public void setUserInterface(UserService us) {
		this.uservice = us;
	}

	@RequestMapping(path = "/home")
	public String login(Model model) {
		User u = new User();
		model.addAttribute("user", u);
		return "login1";
	}

	@RequestMapping(path = "/register")
	public String register(Model model) {
		User u = new User();
		model.addAttribute("newuser", u);

		return "register";
	}

	@RequestMapping(path = "/exit")
	public String logout(@ModelAttribute("user") User user, Model model, HttpSession session) {
		session.setAttribute("usession", null);
		return "home";
	}

	
	  @RequestMapping(path = "/authenticate") public String
	  register(@ModelAttribute("user") User user, Model model, HttpSession session)
	  {
	  
	  UserSession usession = new UserSession(); if(uservice.authenticate(user)) {
	  User u = uservice.findByName(user.getUsername());
	  
	  usession.setUser(u); 
	  session.setAttribute("usession", usession);
	  
	  String currentusername=usession.getUser().getUsername();
	  
	  if(u.getRole().equals(Role.DOCTOR))
	  {
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
	  else if(u.getRole().equals(Role.PATIENT)) return "home-patient";
	  
	  else { model.addAttribute("errmsg",msg ); return "register"; }
	  
	  
	  } else return "login1"; }
	  
	 
}
