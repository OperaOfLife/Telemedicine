package sg.edu.iss.telemedicine.controller;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import sg.edu.iss.telemedicine.domain.Doctor;
import sg.edu.iss.telemedicine.domain.Patient;
import sg.edu.iss.telemedicine.domain.Role;
import sg.edu.iss.telemedicine.domain.User;
import sg.edu.iss.telemedicine.repo.PatientRepository;
import sg.edu.iss.telemedicine.service.DoctorService;
import sg.edu.iss.telemedicine.service.PatientService;
import sg.edu.iss.telemedicine.service.UserService;



@Controller
@RequestMapping("/register")
public class RegisterController
{
	@Autowired
	PatientRepository prepo;
	
	@Autowired
	UserService uservice;

	@Autowired
	PatientService pservice;
	
	@Autowired
	DoctorService dservice;
	
	
	String msg="user already exists";
	
	@RequestMapping("/add") 
	 public String addNewPatient(Model model) 
	{ 
	  model.addAttribute("patient",new Patient());
	  model.addAttribute("user",new User());
	  return "register"; 
	 }
	
	
	
	@RequestMapping("/save")
	  public String savePatient(@ModelAttribute("patient") Patient patient, BindingResult bindingResult,
			  						@ModelAttribute("user") User user, 	Model model)
	{
		
		
		if (bindingResult.hasErrors())
	    {
	      return "home";
	    }
		
		Optional<Patient> pat=pservice.findPatientByPatientId(patient.getPatientId());
		
		//String id=pat.get();
		
		if(pat.isEmpty())
		{	
			pservice.savePatient(patient);
			
			String username=patient.getPatientId().toString();
			user.setUsername(username);
			user.setRole(Role.PATIENT);
			
			uservice.createUser(user);
		    
		    return "forward:/login/home";
			
		
		}
		else
		{
			model.addAttribute("errmsg",msg);
			return "register";
		}
	  }
	
		/*
		 * public static void saveuser(String uname,String pwd) {
		 * 
		 * }
		 */
	
	
	
	
	@RequestMapping("/saveDoctor")
	  public String saveDoctor(@ModelAttribute("doctor") Doctor doctor, BindingResult bindingResult,
			  						@ModelAttribute("user") User user, 	Model model)
	{
		
		
		if (bindingResult.hasErrors())
	    {
	      return "home";
	    }
		
		Optional<Doctor> doc=dservice.findDoctorBydoctorId(doctor.getDoctorId());
		
		if(doc.isEmpty())
		{		
		dservice.save(doctor);
		
		String username=doctor.getDoctorId().toString();
		user.setUsername(username);
		user.setRole(Role.DOCTOR);
		
		uservice.createUser(user);
	    
	    return "forward:/login/home";
		}
		else
		{
			model.addAttribute("errmsg",msg);
			return "register";
		}
	  }
	
	
	
	
		@RequestMapping(path = "/authenticate")
		public String authenticate(@ModelAttribute("user") User user, Model model) 
		{
			/*
			 * if(lservice.authenticate(user)) { User u =
			 * lservice.findByName(user.getUsername()); session.setAttribute("usession", u);
			 * return "register"; } else return "login";
			 */
			return null;
		}
		
	
	
}
