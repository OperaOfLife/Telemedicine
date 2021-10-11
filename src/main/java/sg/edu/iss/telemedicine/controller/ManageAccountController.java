package sg.edu.iss.telemedicine.controller;

import java.util.Optional;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import sg.edu.iss.telemedicine.domain.Doctor;
import sg.edu.iss.telemedicine.domain.Patient;

import sg.edu.iss.telemedicine.domain.User;
import sg.edu.iss.telemedicine.service.DoctorService;
import sg.edu.iss.telemedicine.service.PatientService;

@Controller
@RequestMapping("/account")
public class ManageAccountController 
{
	
	String errmsg = "";
	String msg = "Not Updated";
	
	@Autowired
	PatientService pservice;
	
	
	@Autowired
	DoctorService dservice;
	

	@RequestMapping("/managePatient") 
	 public String managePatient(Model model,HttpSession session) 
	{ 
	  UserSession usession = (UserSession) session.getAttribute("usession");
	  String id=usession.getUser().getUsername();
	  
	  Patient pat = pservice.findPatientById(id);
	  
	  model.addAttribute("patient",pat);
	  model.addAttribute("user",new User());
	  return "patient-manage-profile"; 
	 }
	
	
	
	
	@RequestMapping("/manageDoctor") 
	 public String manageDoctor(Model model,HttpSession session) 
	{ 
		UserSession usession = (UserSession) session.getAttribute("usession");
		String id=usession.getUser().getUsername();
		  
		Doctor doc = dservice.findDoctorById(id);
	    model.addAttribute("doctor",doc);
	    model.addAttribute("user",new User());
	    return "doctor-manage-profile"; 
	 }
	
	
	
	
	
	
	 	@Transactional
	    @RequestMapping(path = "/updateProfilePatient")
		public String update(@ModelAttribute("patient") Patient patient, Model model, HttpSession session)
		{
			UserSession usession = (UserSession) session.getAttribute("usession");
		    String id=usession.getUser().getUsername();
		  
		    if(id!= null)
		    {
		    	pservice.updateProfilePatient(id, patient);
		    	
		    	return "home-patient";
		    }
		    else 
			  { 
				  model.addAttribute("errmsg",msg ); 
				  return "forward:/managePatient";
			 }
			
		}
	  
	
	 	
	 	@Transactional
	    @RequestMapping(path = "/updateProfileDoctor")
		public String update(@ModelAttribute("doctor") Doctor doctor, Model model, HttpSession session)
		{
			UserSession usession = (UserSession) session.getAttribute("usession");
		    String id=usession.getUser().getUsername();
		  
		    if(id!= null)
		    {
		    	dservice.updateProfileDoctor(id, doctor);
		    	
		    	return "home-doctor";
		    }
		    else 
			  { 
				  model.addAttribute("errmsg",msg ); 
				  return "forward:/manageDoctor";
			 }
			
		}
	  
}
