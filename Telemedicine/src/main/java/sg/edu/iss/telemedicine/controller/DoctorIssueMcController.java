package sg.edu.iss.telemedicine.controller;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;


import sg.edu.iss.telemedicine.domain.MedicalCertificate;

@Controller
@RequestMapping("/mc")
public class DoctorIssueMcController 
{

	@RequestMapping("/mcform")
	public String add(Model model)
	{
		model.addAttribute("mc",new MedicalCertificate());
		return "doctor-issue-mc";
	}
	
	@RequestMapping("/issue")
	public String book(@ModelAttribute("mc") MedicalCertificate mc,Model model)
	{
		
		
		return "doctor-issue-mc";
	}
	
}
