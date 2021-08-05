package sg.edu.iss.telemedicine.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import sg.edu.iss.telemedicine.domain.Patient;
import sg.edu.iss.telemedicine.service.PatientService;

@Controller
@RequestMapping("/history")
public class DoctorPatientMedicalHistoryController 
{
	@Autowired
	PatientService pservice;

	
	
	@RequestMapping("/list")
	public String showEnrolment(@ModelAttribute("patients") Patient patient,Model model)
	{
		model.addAttribute("patients", pservice.listAllPatients());
		return "doctor-retrieve-medical-history";
	}
}
