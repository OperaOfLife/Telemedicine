package sg.edu.iss.telemedicine.controller;

import java.time.LocalDate;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import sg.edu.iss.telemedicine.domain.Doctor;
import sg.edu.iss.telemedicine.domain.Patient;
import sg.edu.iss.telemedicine.domain.Role;
import sg.edu.iss.telemedicine.domain.Seminar;
import sg.edu.iss.telemedicine.domain.User;
import sg.edu.iss.telemedicine.service.AdminService;
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
	
	@Autowired
	AdminService aService;	


	String errmsg = "";
	String msg = "NO SUCH USER EXISTS.";
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
	
	

	@RequestMapping("/addPatient") 
	 public String adminAddNewPatient(Model model) 
	{ 
	  model.addAttribute("patient",new Patient());
	  model.addAttribute("user",new User());
	  return "admin-patient-register"; 
	 }
	
	
	@RequestMapping("/addDoctor") 
	 public String adminAddNewDoctor(Model model) 
	{ 
	  model.addAttribute("doctor",new Doctor());
	  model.addAttribute("user",new User());
	  return "admin-doctor-register"; 
	 }
	
	
	
	

	@RequestMapping(path = "/exit")
	public String logout(@ModelAttribute("user") User user, Model model, HttpSession session) 
	{
		Seminar s=aService.findSeminars();
		
		String seminarName=s.getName();
		String seminarLink=s.getLink();
		
		model.addAttribute("name",seminarName);
		model.addAttribute("link", seminarLink);
		
		session.setAttribute("usession", null);
		return "home";
	}

	
	  @RequestMapping(path = "/authenticate") 
	  public String	  register(@ModelAttribute("user") User user, Model model, HttpSession session)
	  {
	  
	  UserSession usession = new UserSession(); 
	  if(!uservice.authenticate(user))
	  {
		  model.addAttribute("errmsg",msg ); 
		  return "login1";
	  }
	  else if(uservice.authenticate(user))
	  {
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
	  else if(u.getRole().equals(Role.PATIENT))
		  return "home-patient";
	  
	  else if(u.getRole().equals(Role.ADMIN))
		  return "forward:/login/addPatient";
	  
	  else 
	  { 
		  
		  model.addAttribute("errmsg",msg ); 
		  return "register";
		  }
	  
	  
	  } 
	  else return "login1"; 
	  }
	  
	  
	  
	  @RequestMapping(path = "/changepwd")
		public String change(Model model, HttpSession session)
		{
			UserSession usession = (UserSession) session.getAttribute("usession");
		    Role role=usession.getUser().getRole();
		    
		    User u=new User();
	    	model.addAttribute("user", u);
		    
		    if(role.equals(Role.DOCTOR))
		    {
		    	return "doctor-change-password";
		    }
		    else if(role.equals(Role.PATIENT))
		    {
		    	
		    	return "patient-change-password";
		    }
		    else if(role.equals(Role.ADMIN))
		    	return "admin-change-password";
		    else 
			  { 
				  model.addAttribute("errmsg",msg ); 
				  return "forward:/home";
			 }
			
		}
	  
	  
	    @Transactional
	    @RequestMapping(path = "/updatePassword")
		public String update(@ModelAttribute("user") User user, Model model, HttpSession session)
		{
			UserSession usession = (UserSession) session.getAttribute("usession");
		    Role role=usession.getUser().getRole();
		    String id=usession.getUser().getUsername();
		    String pwd=user.getPassword();
		    if(role.equals(Role.DOCTOR))
		    {
		    	uservice.updatePassword(id, pwd);
		    	
		    	return "home-doctor";
		    }
		    else if(role.equals(Role.PATIENT))
		    {
		    	uservice.updatePassword(id, pwd);
		    	
		    	return "home-patient";
		    }
		    else if(role.equals(Role.ADMIN))
		    {
		    	uservice.updatePassword(id, pwd);
		    	
		    	Patient p=new Patient();
		    	 model.addAttribute("patient", p);
				  
		    	return "admin-patient-register";
		    }
		    else 
			  { 
				  model.addAttribute("errmsg",msg ); 
				  return "forward:/home";
			 }
			
		}
	  
	  @RequestMapping(path = "/manageProfile")
		public String manage(Model model, HttpSession session)
		{
			UserSession usession = (UserSession) session.getAttribute("usession");
		    Role role=usession.getUser().getRole();
		    if(role.equals(Role.DOCTOR))
		    	return "forward:/login/manageDoctor";
		    else if(role.equals(Role.PATIENT))
		    	return "forward:/login/managePatient";
		    
		    else 
			  { 
				  model.addAttribute("errmsg",msg ); 
				  return "forward:/home";
			 }
			
		}
	  
	 
}
